import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddNewCustomer extends JFrame implements ActionListener {
	JFrame jf;
	JTextField t1, t2, t3, t4, t5, t6, t8, t9, t10;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, ln;
	JButton b0, b1, b2;
	JComboBox msname, tabtype;
	String s, sid1, tabt;
	Font f;
	Date date1;
	GregorianCalendar calendar;
	String strDate;
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();
	JTable tabGrid = new JTable(model);
	JScrollPane scrlPane = new JScrollPane(tabGrid);

	AddNewCustomer() {
		jf = new JFrame();
		f = new Font("Times New Roman", Font.BOLD, 15);
		jf.setLayout(null);

		ln = new JLabel("ROOM BOOKING");
		ln.setFont(new Font("Times New Roman", Font.BOLD, 25));
		ln.setForeground(Color.blue);
		ln.setBounds(300, 30, 400, 40);
		jf.add(ln);

		l1 = new JLabel("Customer Name *");
		// l1.setFont(f);
		l1.setBounds(50, 100, 200, 25);
		jf.add(l1);

		t1 = new JTextField(20);
		t1.setBounds(250, 100, 100, 25);
		t1.setToolTipText("Enter Customer Name");
		jf.add(t1);

		l2 = new JLabel("Customer Email*");
		// l2.setFont(f);
		l2.setBounds(50, 140, 200, 25);
		jf.add(l2);

		t2 = new JTextField(20);
		t2.setBounds(250, 140, 200, 25);
		t2.setToolTipText("Enter Customer email");
		jf.add(t2);

		l3 = new JLabel("City*");
		// l3.setFont(f);
		l3.setBounds(50, 180, 200, 25);
		jf.add(l3);

		t3 = new JTextField(20);
		t3.setBounds(250, 180, 200, 25);
		t3.setToolTipText("Enter city");
		jf.add(t3);

		l4 = new JLabel("State*");
		// l4.setFont(f);
		l4.setBounds(50, 220, 200, 25);
		jf.add(l4);

		t4 = new JTextField(20);
		t4.setBounds(250, 220, 100, 25);
		t4.setToolTipText("Enter State");
		jf.add(t4);

		l5 = new JLabel("Country*");
		// l5.setFont(f);
		l5.setBounds(50, 260, 250, 25);
		jf.add(l5);

		t5 = new JTextField(20);
		t5.setBounds(250, 260, 100, 25);
		t5.setToolTipText("Enter country");
		jf.add(t5);

		l6 = new JLabel("Room Booking date*");
		// l6.setFont(f);
		l6.setBounds(50, 300, 260, 25);
		jf.add(l6);

		t6 = new JTextField(20);
		t6.setBounds(250, 300, 100, 25);
		t6.setToolTipText("Enter booking date");
		jf.add(t6);

		date1 = new Date();
		calendar = new GregorianCalendar();
		calendar.setTime(date1);
		strDate = calendar.get(Calendar.DATE) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-"
				+ calendar.get(Calendar.YEAR);
		t6.setText(strDate);

		l7 = new JLabel("ID Proof*");
		// l7.setFont(f);
		l7.setBounds(470, 100, 200, 25);
		jf.add(l7);

		tabtype = new JComboBox();
		tabtype.addItem("--type--");
		tabtype.addItem("Voter-ID");
		tabtype.addItem("Driving Licence");
		tabtype.addItem("Official ID Card");
		tabtype.addItem("Passport");
		tabtype.setBounds(720, 100, 100, 25);
		tabtype.setToolTipText("Select id type");
		jf.add(tabtype);
		tabtype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				tabt = (String) tabtype.getSelectedItem();
			}
		});

		l8 = new JLabel("ID Proof Number*");
		// l8.setFont(f);
		l8.setBounds(470, 140, 220, 25);
		jf.add(l8);

		t8 = new JTextField(20);
		t8.setBounds(720, 140, 100, 25);
		t8.setToolTipText("Enter ID proof Number");
		jf.add(t8);

		l9 = new JLabel("Room No*");
		// l9.setFont(f);
		l9.setBounds(470, 180, 200, 25);
		jf.add(l9);

		t9 = new JTextField(20);
		t9.setBounds(720, 180, 100, 25);
		t9.setToolTipText("Enter Room no");
		jf.add(t9);

		b0 = new JButton("Book", new ImageIcon("images//save.png"));
		b0.setBounds(150, 330, 110, 35);
		b0.setToolTipText("click to save Customer details");
		jf.add(b0);
		b0.addActionListener(this);

		b1 = new JButton("Clear", new ImageIcon("images//clear.png"));
		b1.setBounds(300, 330, 110, 35);
		b1.setToolTipText("click to clear all textfields");
		jf.add(b1);
		b1.addActionListener(this);

		b2 = new JButton("All", new ImageIcon("images//all.png"));
		b2.setBounds(450, 330, 110, 35);
		b2.setToolTipText("click to view all Customer details");
		jf.add(b2);
		b2.addActionListener(this);

		scrlPane.setBounds(0, 380, 900, 600);
		jf.add(scrlPane);
		tabGrid.setFont(new Font("Times New Roman", 0, 15));

		model.addColumn("C_Name");
		model.addColumn("C_Email");
		model.addColumn("C_City");
		model.addColumn("C_State");
		model.addColumn("C_Country");
		model.addColumn("C_Date");
		model.addColumn("C_ID");
		model.addColumn("C_IDNUM");
		model.addColumn("C_Room");

		jf.setTitle("Room Booking ");
		jf.setSize(900, 700);
		jf.setLocation(20, 20);
		jf.setResizable(false);
		jf.getContentPane().setBackground(Color.cyan);
		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b0) {
			try {
				if (((t1.getText()).equals("")) || ((t2.getText()).equals("")) || ((t3.getText()).equals(""))
						|| ((t4.getText()).equals("")) || ((t5.getText()).equals("")) || ((t6.getText()).equals(""))
						|| ((t8.getText()).equals(""))) {
					JOptionPane.showMessageDialog(this, "* Details are Missing !", "Warning!!!",
							JOptionPane.WARNING_MESSAGE);
				}

				else {

					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/relex", "root", "");
					System.out.println("Connected to database.");

					ps = con.prepareStatement(
							"insert into Customer (c_name,c_email,c_city,c_state,c_country,c_date,c_id,c_idnum,c_room)values(?,?,?,?,?,?,?,?,?)");

					ps.setString(1, t1.getText());
					ps.setString(2, t2.getText());
					ps.setString(3, t3.getText());
					ps.setString(4, t4.getText());
					ps.setString(5, t5.getText());
					ps.setString(6, t6.getText());
					ps.setString(7, tabt);
					ps.setString(8, t8.getText());
					ps.setInt(9, Integer.parseInt(t9.getText()));

					ps.executeUpdate();

					int reply = JOptionPane.showConfirmDialog(null,
							"Customer added successfully.Do you want add more Customer?", "Added Customer",
							JOptionPane.YES_NO_OPTION);

					if (reply == JOptionPane.YES_OPTION) {
						jf.setVisible(false);
						new AddNewCustomer();
					} else if (reply == JOptionPane.NO_OPTION) {
						jf.setVisible(false);
					}
				}

				con.close();
			} catch (SQLException se) {
				System.out.println(se);
				JOptionPane.showMessageDialog(null, "SQL Error:" + se);
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Error:" + e);
			}

		} else if (ae.getSource() == b1) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t8.setText("");
			t9.setText("");

		}

		else if (ae.getSource() == b2) {// list
			int r = 0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/relex", "root", "");
				System.out.println("Connected to database.");
				stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				rs = stmt.executeQuery("SELECT * from Customer");
				while (rs.next()) {
					model.insertRow(r++,
							new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
									rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
									rs.getString(9) });
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
		new AddNewCustomer();
	}
}
