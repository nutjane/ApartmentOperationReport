import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class APP extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APP frame = new APP();
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
	public APP() {
		/** set the main menu window frame and the title bar of window **/
		String path = getClass().getClassLoader().getResource(".").getPath(); //get image directory
		setType(Type.POPUP);
		setForeground(Color.BLACK);
		setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 20));
		setIconImage(Toolkit.getDefaultToolkit().getImage(path+"logo.png"));
		setTitle("SALAYA TOWER - Apartment Operation Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 472);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**  set The head sentence of the window **/
		JLabel lblChooseTheReport = new JLabel("Choose The Report");
		lblChooseTheReport.setForeground(new Color(0, 0, 205));
		lblChooseTheReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseTheReport.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 25));
		lblChooseTheReport.setBounds(129, 27, 286, 52);
		contentPane.add(lblChooseTheReport);
		
		/** set the second sentence near the button **/
		JLabel lblWelcomeToOur = new JLabel("Welcome to our apartment");
		lblWelcomeToOur.setForeground(new Color(0, 0, 255));
		lblWelcomeToOur.setBackground(Color.RED);
		lblWelcomeToOur.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToOur.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 16));
		lblWelcomeToOur.setBounds(35, 286, 215, 61);
		contentPane.add(lblWelcomeToOur);
		
		/** set the button that link to the contract window **/
		JButton btnContract = new JButton("Contract");
		btnContract.setToolTipText("Click this if you want to see the contract report");
		btnContract.addActionListener(new ActionListener() {
			/** the method when click the button the program will run to link the contract window **/
			public void actionPerformed(ActionEvent arg0) {
				APPC a = new APPC();
				a.setVisible(true);
			}
		});
		btnContract.setForeground(new Color(0, 0, 128));
		btnContract.setBackground(new Color(100, 149, 237));
		btnContract.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		btnContract.setBounds(295, 100, 200, 50);
		contentPane.add(btnContract);
		
		/** set the button that link to the invoice window **/
		JButton btnInvoicee = new JButton("Invoice");
		btnInvoicee.setToolTipText("Click this if you want to see the invoice report");
		btnInvoicee.addActionListener(new ActionListener() {
			/** the method when click the button the program will run to link the invoice window **/
			public void actionPerformed(ActionEvent arg0) {
				APPI b = new APPI();
				b.setVisible(true);
			}
		});
		btnInvoicee.setForeground(new Color(0, 0, 128));
		btnInvoicee.setBackground(new Color(100, 149, 237));
		btnInvoicee.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		btnInvoicee.setBounds(295, 174, 200, 50);
		contentPane.add(btnInvoicee);
		
		/** set the button that link to the usage water window **/
		JButton btnUsageWater = new JButton("Water Usage");
		btnUsageWater.setToolTipText("Click this if you want to see the usage water report");
		btnUsageWater.addActionListener(new ActionListener() {
			/** the method when click the button the program will run to link the usage water window **/
			public void actionPerformed(ActionEvent arg0) {
				APPW c = new APPW();
				c.setVisible(true);
			}
		});
		btnUsageWater.setForeground(new Color(0, 0, 128));
		btnUsageWater.setBackground(new Color(100, 149, 237));
		btnUsageWater.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		btnUsageWater.setBounds(295, 250, 200, 50);
		contentPane.add(btnUsageWater);
		
		/**set the button that link to the usage electricity window **/
		JButton btnUsageElectricity = new JButton("Electricity Usage");
		btnUsageElectricity.setToolTipText("Click this if you want to see the usage electricity report");
		btnUsageElectricity.addActionListener(new ActionListener() {
			/** the method when click the button the program will run to link the usage electricity window **/
			public void actionPerformed(ActionEvent arg0) {
				APPE a = new APPE();
				a.setVisible(true);
			}
		});
		btnUsageElectricity.setForeground(new Color(0, 0, 128));
		btnUsageElectricity.setBackground(new Color(100, 149, 237));
		btnUsageElectricity.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		btnUsageElectricity.setBounds(295, 327, 200, 50);
		contentPane.add(btnUsageElectricity);
		
		/** set the picture salaya tower **/
		JLabel lblNewLabel = new JLabel(path);
		lblNewLabel.setIcon(new ImageIcon(path+"logo.png"));
		lblNewLabel.setBounds(69, 27, 130, 319);
		contentPane.add(lblNewLabel);
	}
}
