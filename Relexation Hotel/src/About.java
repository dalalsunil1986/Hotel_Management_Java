import javax.swing.*;

import java.awt.*;

class About extends JFrame {
	JFrame jf;
	JLabel l1, l2, l3, l4, l5, l6, l7;
	JButton b1, b2, b3;

	About() {
		jf = new JFrame();

		jf.setLayout(null);

		l1 = new JLabel("Welcom To Relaxation Hotel ");
		l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		l1.setBounds(200, 30, 600, 40);
		l1.setForeground(Color.red);
		jf.add(l1);

		l2 = new JLabel(" Luxery Hotel of The Town ,");
		// l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		l2.setBounds(100, 150, 600, 40);
		jf.add(l2);

		l3 = new JLabel("Come & Enjoy Our Services .");

		l3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l3.setBounds(300, 200, 400, 40);
		l3.setForeground(Color.red);
		jf.add(l3);

		jf.setTitle("About System");
		jf.setSize(900, 700);
		jf.setLocation(20, 20);
		jf.setResizable(false);
		jf.getContentPane().setBackground(Color.cyan);
		jf.setVisible(true);

	}

	public static void main(String args[]) {
		new About();

	}
}
