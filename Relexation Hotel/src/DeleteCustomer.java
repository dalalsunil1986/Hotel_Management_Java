import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class DeleteCustomer extends JFrame implements ActionListener {

	JFrame jf;
	JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, ln;
	JButton b0, b1, b2, b3;
	Font f;
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();
	JTable tabGrid = new JTable(model);
	JScrollPane scrlPane = new JScrollPane(tabGrid);

	DeleteCustomer() {

		jf = new JFrame();
		f = new Font("Times New Roman", Font.BOLD, 20);
		jf.setLayout(null);

		ln = new JLabel(" Delete Coustmor ");
		ln.setFont(new Font("Times New Roman", Font.BOLD, 25));
		ln.setForeground(Color.blue);
		ln.setBounds(300, 30, 300, 40);
		jf.add(ln);

		l1 = new JLabel("Customer Room Number*");
		// l1.setFont(f);
		l1.setBounds(50, 100, 200, 25);
		jf.add(l1);

		t1 = new JTextField(20);
		t1.setBounds(250, 100, 100, 25);
		t1.setToolTipText("Enter Customer room no to delete");
		jf.add(t1);

		b1 = new JButton("Delete", new ImageIcon("images//delete.png"));
		b1.setBounds(300, 330, 110, 35);
		b1.setToolTipText("click to delete customer details");
		jf.add(b1);
		b1.addActionListener(this);

		b2 = new JButton("Clear", new ImageIcon("images//clear.png"));
		b2.setBounds(450, 330, 110, 35);
		b2.setToolTipText("click to clear all textfields");
		jf.add(b2);
		b2.addActionListener(this);

		b3 = new JButton("All", new ImageIcon("images//all.png"));// if button
																	// is press
																	// then
																	// record
																	// display
																	// repeat
		b3.setBounds(600, 330, 110, 35);
		b3.setToolTipText("click to view all customer details");
		jf.add(b3);
		b3.addActionListener(this);

		scrlPane.setBounds(0, 380, 900, 600);
		jf.add(scrlPane);
		tabGrid.setFont(new Font("Times New Roman", 0, 15));

		model.addColumn("C_Name");
		model.addColumn("C_Email");
		model.addColumn("C_City");
		model.addColumn("C_Room");

		jf.setTitle("Delete Customer ");
		jf.setSize(900, 700);
		jf.setLocation(20, 20);
		jf.setResizable(false);
		jf.getContentPane().setBackground(Color.cyan);
		jf.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b0) {
			try {
				if (((t1.getText()).equals(""))) {
					JOptionPane.showMessageDialog(this, "Please enter customer room no  !", "Warning!!!",
							JOptionPane.WARNING_MESSAGE);
				} else {
					int foundrec = 0;

					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/relex", "root", "");
					System.out.println("Connected to database.");

					ps = con.prepareStatement("select * from Customer where c_room = '" + t1.getText() + "'");
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
		} else if (ae.getSource() == b1) {// delete
			if (((t1.getText()).equals(""))) {
				JOptionPane.showMessageDialog(this, "Are You SUre !", "Warning!!!", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/relex", "root", "");
					System.out.println("Connected to database.");
					ps = con.prepareStatement("delete from Customer where c_room='" + t1.getText() + "'");
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record is deleted.");
					t1.setText("");

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

		else if (ae.getSource() == b2) {
			t1.setText("");

		} else if (ae.getSource() == b3) {// list
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
		new DeleteCustomer();
	}
}
