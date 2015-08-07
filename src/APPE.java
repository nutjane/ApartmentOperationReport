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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.NumberFormatException;


public class APPE extends JFrame {
	

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JComboBox comboBox1;
	private JComboBox comboBox_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APPW frame = new APPW();
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
	public APPE() {
		/** set the usage electricity window frame and the title bar of window **/
		String path = getClass().getClassLoader().getResource(".").getPath(); //get image directory
		setTitle("Electricity Usage Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/** set The head sentence of the window **/
		JLabel lblSelectTheDate = new JLabel("Select the date that you use the electricity");
		lblSelectTheDate.setForeground(new Color(255, 165, 0));
		lblSelectTheDate.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 18));
		lblSelectTheDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTheDate.setBounds(94, 11, 383, 74);
		contentPane.add(lblSelectTheDate);
		
		/** set The sentence in the frame **/
		JLabel lblFrom = new JLabel("From");
		lblFrom.setForeground(new Color(255, 165, 0));
		lblFrom.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		lblFrom.setBounds(277, 72, 200, 50);
		contentPane.add(lblFrom);
		
		/** set the start month box **/
		comboBox1 = new JComboBox();
		comboBox1.setToolTipText("Choose the month (January 1 February 2..) what month is you start use the electricity?");
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox1.setMaximumRowCount(13);
		comboBox1.setForeground(new Color(255, 165, 0));
		comboBox1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
		comboBox1.setBackground(new Color(255, 228, 196));
		comboBox1.setBounds(336, 114, 35, 37);
		contentPane.add(comboBox1);
		
		/** set The sentence in the frame **/
		JLabel lblYear = new JLabel("Year :");
		lblYear.setForeground(new Color(255, 165, 0));
		lblYear.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		lblYear.setBounds(381, 113, 74, 37);
		contentPane.add(lblYear);
		
		/** set The sentence in the frame **/
		JLabel lblTo = new JLabel("To");
		lblTo.setForeground(new Color(255, 165, 0));
		lblTo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		lblTo.setBounds(277, 162, 200, 50);
		contentPane.add(lblTo);
		
		/** set the lastest month box **/
		comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("Choose the month (January 1 February 2..) what month is you stop use the electricity?");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1.setMaximumRowCount(13);
		comboBox_1.setForeground(new Color(255, 165, 0));
		comboBox_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
		comboBox_1.setBackground(new Color(255, 228, 196));
		comboBox_1.setBounds(336, 204, 35, 37);
		contentPane.add(comboBox_1);
		
		
		/** set The sentence in the frame **/
		JLabel label_2 = new JLabel("Year :");
		label_2.setForeground(new Color(255, 165, 0));
		label_2.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		label_2.setBounds(381, 203, 74, 37);
		contentPane.add(label_2);
		
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
		button.setForeground(new Color(255, 165, 0));
		button.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 9));
		button.setBackground(new Color(255, 228, 196));
		button.setBounds(479, 373, 52, 35);
		contentPane.add(button);
		
		/** set the electricity picture **/
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(path+"ele.jpg"));
		lblNewLabel.setBounds(35, 72, 180, 304);
		contentPane.add(lblNewLabel);
		
		/** set The sentence in the frame **/
		JLabel lblMonth_1 = new JLabel("Month :");
		lblMonth_1.setForeground(new Color(255, 165, 0));
		lblMonth_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		lblMonth_1.setBounds(275, 114, 74, 37);
		contentPane.add(lblMonth_1);
		
		/** set The sentence in the frame **/
		JLabel lblMonth = new JLabel("Month :");
		lblMonth.setForeground(new Color(255, 165, 0));
		lblMonth.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		lblMonth.setBounds(275, 204, 74, 37);
		contentPane.add(lblMonth);
		
		/** set the start year box **/
		comboBox = new JComboBox();
		comboBox.setToolTipText("Choose the year between 2012-2015 what year is you start use the electricity?");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2012", "2013", "2014", "2015"}));
		comboBox.setMaximumRowCount(13);
		comboBox.setForeground(new Color(255, 165, 0));
		comboBox.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
		comboBox.setBackground(new Color(255, 228, 196));
		comboBox.setBounds(458, 114, 62, 37);
		contentPane.add(comboBox);
		
		/** set the lastest year box **/
		comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("Choose the year between 2012-2015 what year is you stop use the electricity?");
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2012", "2013", "2014", "2015"}));
		comboBox_2.setMaximumRowCount(13);
		comboBox_2.setForeground(new Color(255, 165, 0));
		comboBox_2.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
		comboBox_2.setBackground(new Color(255, 228, 196));
		comboBox_2.setBounds(458, 204, 62, 37);
		contentPane.add(comboBox_2);
		String p = (String) comboBox_2.getSelectedItem();
		
		/** set the button that link to the usage electricity report **/
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setToolTipText("Click this if you want to confirm the date that you want to see (Usage electricity)");
		btnNewButton.addActionListener(new ActionListener() {
			/** the method when click the button the program will run to link the ReportUsedElectricity class **/
			public void actionPerformed(ActionEvent arg0) {
				
					/** chage the string that recieve from the comboBox to integer **/
					String p = (String) comboBox_2.getSelectedItem();
					int endYear = Integer.parseInt(p);
					String o = (String) comboBox.getSelectedItem();
					int startYear = Integer.parseInt(o);
					String n = (String) comboBox_1.getSelectedItem();
					int endMonth = Integer.parseInt(n);
					String m = (String) comboBox1.getSelectedItem();
					int startMonth = Integer.parseInt(m);

					ReportUsedElectricity a = new ReportUsedElectricity(startMonth,startYear,endMonth,endYear);				}
		});
		

		btnNewButton.setForeground(new Color(255, 165, 0));
		btnNewButton.setBackground(new Color(255, 228, 196));
		btnNewButton.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		btnNewButton.setBounds(346, 262, 62, 37);
		contentPane.add(btnNewButton);
	}
		
}
