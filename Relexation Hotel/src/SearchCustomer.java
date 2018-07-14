import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class SearchCustomer extends JFrame implements ActionListener {

	JFrame jf;
	JTextField t1, t2, t3, t4;
	JLabel l1, ln;
	JButton b0, b1, b2;
	JComboBox msname;
	String s;
	Font f;
	Connection con;
	
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();
	JTable tabGrid = new JTable(model);
	JScrollPane scrlPane = new JScrollPane(tabGrid);

	SearchCustomer() {

		jf = new JFrame();
		f = new Font("Times New Roman", Font.BOLD, 20);
		jf.setLayout(null);

		ln = new JLabel("Search Customer");
		ln.setFont(new Font("Times New Roman", Font.BOLD, 25));
		ln.setForeground(Color.blue);
		ln.setBounds(300, 30, 300, 40);
		jf.add(ln);

		l1 = new JLabel("Customer Room No*");
		// l1.setFont(f);
		l1.setBounds(50, 100, 200, 25);
		jf.add(l1);

		t1 = new JTextField(20);
		t1.setBounds(250, 100, 100, 25);
		t1.setToolTipText("Enter Customer's room no to search");
		jf.add(t1);

		b0 = new JButton("Search", new ImageIcon("images//search.png"));
		b0.setBounds(150, 330, 110, 35);
		b0.setToolTipText("click to search customer details");
		jf.add(b0);
		b0.addActionListener(this);

		b1 = new JButton("Clear", new ImageIcon("images//clear.png"));
		b1.setBounds(300, 330, 110, 35);
		b1.setToolTipText("click to clear all textfields");
		jf.add(b1);
		b1.addActionListener(this);

		b2 = new JButton("All", new ImageIcon("images//all.png"));
		b2.setBounds(450, 330, 110, 35);
		b2.setToolTipText("click to view all customer details");
		jf.add(b2);
		b2.addActionListener(this);

		scrlPane.setBounds(0, 380, 900, 600);
		jf.add(scrlPane);
		tabGrid.setFont(new Font("Times New Roman", 0, 15));

		model.addColumn("C_Name");
		model.addColumn("C_Email");
		model.addColumn("C_City");
		model.addColumn("C_Room");

		jf.setTitle("Search Customer ");
		jf.setSize(900, 700);
		jf.setLocation(20, 20);
		jf.setResizable(false);
		jf.getContentPane().setBackground(Color.cyan);
		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b0) {// fetch
			try {
				if (((t1.getText()).equals(""))) {
					JOptionPane.showMessageDialog(this, "Please enter Customer's room no !", "Warning!!!",
							JOptionPane.WARNING_MESSAGE);
				} else {
					int foundrec = 0;

					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/relex", "root", "");
					System.out.println("Connected to database.");

					ps = con.prepareStatement("select * from Customer where c_room='" + t1.getText() + "'");
					rs = ps.executeQuery();
					while (rs.next()) {
						t1.setText(rs.getString(1));

						foundrec = 1;
					}
					if (foundrec == 0) {
						JOptionPane.showMessageDialog(null, "Record is not available", "Dialog",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				con.close();
			} catch (SQLException se) {
				System.out.println(se);
				JOptionPane.showMessageDialog(null, "SQL Error." + se);
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Error." + e);
			}
		} else if (ae.getSource() == b1) {
			t1.setText("");

		} else if (ae.getSource() == b2) {// list
			int r = 0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/relex", "root", "");
				System.out.println("Connected to database.");
				stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				rs = stmt.executeQuery("SELECT * from Customer");
				while (rs.next()) {
					model.insertRow(r++,
							new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(9) });

				}
				con.close();
			} catch (SQLException se) {
				System.out.println(se);
				JOptionPane.showMessageDialog(null, "SQL Error:" + se);
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Error:" + e);
			}
		}
	}

	public static void main(String args[]) {
		new SearchCustomer();
	}

}
