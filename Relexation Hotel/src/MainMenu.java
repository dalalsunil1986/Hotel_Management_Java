
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener {
	JFrame jf;
	JMenuBar mbar;
	JMenu m1, m2, m4, m5;
	JMenuItem m1_1, m1_2, m1_3, m1_4, m1_5, m2_1, m2_2, m3_1, m3_2, m4_1, m5_1;
	JLabel l1, LogoColl;
	GridBagLayout gbl;

	public MainMenu() {
		jf = new JFrame();
		gbl = new GridBagLayout();
		jf.setLayout(gbl);

		l1 = new JLabel("WELCOME TO HOTEL RELAXATION ");
		l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jf.add(l1);

		mbar = new JMenuBar();
		jf.setJMenuBar(mbar);

		m1 = new JMenu("Customer");
		mbar.add(m1);
		m1_1 = new JMenuItem("Book New Room", new ImageIcon("images//addnew.png"));
		m1.add(m1_1);
		m1_2 = new JMenuItem("search Customer", new ImageIcon("images//search.png"));
		m1.add(m1_2);
		m1_4 = new JMenuItem("Delete Customer", new ImageIcon("images//delete.png"));
		m1.add(m1_4);

		m2 = new JMenu("List Of Customer");
		mbar.add(m2);
		m2_1 = new JMenuItem("Customer List", new ImageIcon("images//all.png"));
		m2.add(m2_1);

		m4 = new JMenu("About");
		mbar.add(m4);
		m4_1 = new JMenuItem("About System", new ImageIcon("images//help.png"));
		m4.add(m4_1);

		m5 = new JMenu("Exit");
		mbar.add(m5);
		m5_1 = new JMenuItem("Exit", new ImageIcon("images//exit.png"));
		m5.add(m5_1);

		m1_1.addActionListener(this);
		m1_2.addActionListener(this);
		m1_4.addActionListener(this);

		m2_1.addActionListener(this);

		m4_1.addActionListener(this);
		m5_1.addActionListener(this);

		jf.setTitle("Main Menu");
		jf.setLocation(20, 20);
		jf.setSize(900, 700);
		jf.setResizable(false);
		jf.getContentPane().setBackground(Color.cyan);
		jf.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == m1_1) {
			new AddNewCustomer();
		} else if (ae.getSource() == m1_2) {
			new SearchCustomer();
		}

		else if (ae.getSource() == m1_4) {
			new DeleteCustomer();
		}

		else if (ae.getSource() == m2_1) {
			new CustomerList();
		}

		else if (ae.getSource() == m4_1) {
			new About();
		}

		else if (ae.getSource() == m5_1) {
			System.exit(0);
		}

	}

	public static void main(String args[]) {
		new MainMenu();
	}
}
