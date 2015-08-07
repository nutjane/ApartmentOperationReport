import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class APPI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APPI frame = new APPI();
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
	public APPI() {
		/** set the invoice window frame and the title bar of window **/
		String path = getClass().getClassLoader().getResource(".").getPath(); //get image directory
		setTitle("Invoice Report\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/** The head sentence of the window **/
		JLabel lblChooseYourInvoice = new JLabel("Choose your invoice");
		lblChooseYourInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourInvoice.setForeground(Color.RED);
		lblChooseYourInvoice.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblChooseYourInvoice.setBounds(167, 31, 200, 50);
		contentPane.add(lblChooseYourInvoice);
		
		/** set the invoice picture **/
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(path+"invoice.jpg"));
		lblNewLabel.setBounds(32, 117, 206, 233);
		contentPane.add(lblNewLabel);
		
		/** set the button that link to the paid invoice report **/
		JButton btnPaid = new JButton("Paid");
		btnPaid.setToolTipText("Click this if you want to see the invoice that paid already report");
		btnPaid.addActionListener(new ActionListener() {
			/** the method when click the button the program will run to link the ReportInvoicePaid class **/
			public void actionPerformed(ActionEvent arg0) {
				ReportInvoicePaid a = new ReportInvoicePaid();
			}
		});
		btnPaid.setBackground(new Color(233, 150, 122));
		btnPaid.setForeground(Color.RED);
		btnPaid.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		btnPaid.setBounds(295, 92, 200, 50);
		contentPane.add(btnPaid);
		
		/** set the button that link to the unpaid invoice report **/
		JButton btnUnpaid = new JButton("Unpaid");
		btnUnpaid.setToolTipText("Click this if you want to see the invoice that unpaid report");
		btnUnpaid.addActionListener(new ActionListener() {
			/** the method when click the button the program will run to link the ReportInvoiceUnpaid class **/
			public void actionPerformed(ActionEvent arg0) {
				ReportInvoiceUnpaid a = new ReportInvoiceUnpaid();
			}
		});
		btnUnpaid.setBackground(new Color(233, 150, 122));
		btnUnpaid.setForeground(Color.RED);
		btnUnpaid.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		btnUnpaid.setBounds(295, 173, 200, 50);
		contentPane.add(btnUnpaid);
		
		/** set the button that link back to the main menu**/
		JButton button = new JButton("<<<");
		button.setToolTipText("Click this if you want to go back the main menu");
		button.addActionListener(new ActionListener() {
			/** the method when click the button the program will run to link back to the main window **/
			public void actionPerformed(ActionEvent arg0) {
				APP a = new APP();
				a.setVisible(true);
			}
		});
		button.setForeground(Color.RED);
		button.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 9));
		button.setBackground(new Color(233, 150, 122));
		button.setBounds(480, 388, 52, 35);
		contentPane.add(button);
		
		/** set the button that link both the invoice report (paid&unpaid) **/
		JButton btnAll = new JButton("All");
		btnAll.setToolTipText("Click this if you want to see both of the invoice report (Paid & Unpaid)");
		btnAll.addActionListener(new ActionListener() {
			/** the method when click the button the program will run to link the ReportInvoiceAll class **/
			public void actionPerformed(ActionEvent arg0) {
				ReportInvoiceAll a = new ReportInvoiceAll();
			}
		});
		btnAll.setForeground(Color.RED);
		btnAll.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		btnAll.setBackground(new Color(233, 150, 122));
		btnAll.setBounds(295, 256, 200, 50);
		contentPane.add(btnAll);
	}

}
