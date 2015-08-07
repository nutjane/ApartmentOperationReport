import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class APPC extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APPC frame = new APPC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public APPC() {
		/** set the contract window frame and the title bar of window **/
		String path = getClass().getClassLoader().getResource(".").getPath(); //get image directory
		setTitle("Contract Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/** The head sentence of the window **/
		JLabel lblChooseYourReport = new JLabel("Choose your report contract");
		lblChooseYourReport.setForeground(new Color(138, 43, 226));
		lblChooseYourReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourReport.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblChooseYourReport.setBounds(138, 22, 269, 79);
		contentPane.add(lblChooseYourReport);
		
		/** set the contract picture **/
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(path+"contract.jpg"));
		label.setBounds(22, 100, 258, 271);
		contentPane.add(label);
		
		/** set the button that link to the active contract report **/
		JButton btnNewButton = new JButton("Active");
		btnNewButton.setToolTipText("Click this if you want to see the active contract report");
		btnNewButton.addActionListener(new ActionListener() {
			/** the method when click the button the program will run to link the ReportContractActive class **/
			public void actionPerformed(ActionEvent arg0) {
				ReportContractActive a = new ReportContractActive();
			}
		});
		btnNewButton.setBackground(new Color(147, 112, 219));
		btnNewButton.setForeground(new Color(75, 0, 130));
		btnNewButton.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		btnNewButton.setBounds(312, 109, 200, 50);
		contentPane.add(btnNewButton);
		
		/** set the button that link to the terminated contract report **/
		JButton btnTerminated = new JButton("Terminated");
		btnTerminated.setToolTipText("Click this if you want to see the terminated contract report");
		btnTerminated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/** the method when click the button the program will run to link the ReportContractTerminated class **/
				ReportContractTerminated a = new ReportContractTerminated();
			}
		});
		btnTerminated.setBackground(new Color(147, 112, 219));
		btnTerminated.setForeground(new Color(75, 0, 130));
		btnTerminated.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		btnTerminated.setBounds(312, 196, 200, 50);
		contentPane.add(btnTerminated);
		
		/** set the button that link to both the contract report (active&terminated) **/
		JButton btnAll = new JButton("All");
		btnAll.setToolTipText("Click this if you want to see both of the contract report (Active&Terminated)\r\n");
		btnAll.addActionListener(new ActionListener() {
			/** the method when click the button the program will run to link the ReportContractAll class **/
			public void actionPerformed(ActionEvent arg0) {
				ReportContractAll a = new ReportContractAll();
			}
		});
		btnAll.setBackground(new Color(147, 112, 219));
		btnAll.setForeground(new Color(75, 0, 130));
		btnAll.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		btnAll.setBounds(312, 293, 200, 50);
		contentPane.add(btnAll);
		
		/** set the button that link back to the main menu**/
		JButton btnNewButton_1 = new JButton("<<<");
		btnNewButton_1.setToolTipText("Click this if you want to go back the main menu");
		btnNewButton_1.setBackground(new Color(147, 112, 219));
		btnNewButton_1.setForeground(new Color(75, 0, 130));
		btnNewButton_1.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 9));
		btnNewButton_1.addActionListener(new ActionListener() {
			/** the method when click the button the program will run to link back to the main window **/
			public void actionPerformed(ActionEvent arg0) {
				APP a = new APP();
				a.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(460, 389, 52, 35);
		contentPane.add(btnNewButton_1);
	}

}
