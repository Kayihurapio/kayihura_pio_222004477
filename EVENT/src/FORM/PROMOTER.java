package FORM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class PROMOTER extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField events_desctxf;
	private JTextField datetxf;
	private JTextField timetxf;
	private JTextField venuetxf;
	private JTextField event_nametxf;
	private JTextField pricetxf;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PROMOTER frame = new PROMOTER();
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
	public PROMOTER() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEVENTCREATION = new JLabel("PROMOTER HOMEPAGE");
		lblEVENTCREATION.setBounds(177, 11, 147, 23);
		contentPane.add(lblEVENTCREATION);
		
		JLabel lblPROMOTERHOMEPAGE = new JLabel("event_name");
		lblPROMOTERHOMEPAGE.setBounds(10, 73, 119, 23);
		contentPane.add(lblPROMOTERHOMEPAGE);
		
		JLabel lblEVENT_DESCRIPTION = new JLabel("event_description");
		lblEVENT_DESCRIPTION.setBounds(10, 117, 119, 23);
		contentPane.add(lblEVENT_DESCRIPTION);
		
		JLabel lblDATE = new JLabel("date");
		lblDATE.setBounds(22, 160, 111, 23);
		contentPane.add(lblDATE);
		
		JLabel lblTIME = new JLabel("time");
		lblTIME.setBounds(22, 207, 119, 23);
		lblTIME.setBackground(new Color(240, 240, 240));
		lblTIME.setForeground(new Color(0, 0, 0));
		contentPane.add(lblTIME);
		
		JLabel lblVENUE = new JLabel("venue");
		lblVENUE.setBounds(22, 259, 119, 23);
		contentPane.add(lblVENUE);
		
		JButton btnADD = new JButton("ADD");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/management_event","root","");
			String sql="INSERT INTO PROMOTER VALUES(?,?,?,?,)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(event_nametxf.getText()));
			st.setString(2,events_desctxf.getText());
			st.setString(3, datetxf.getText());
			st.setString(4, timetxf.getText());
	            st.setString(5, venuetxf.getText());
	            st.setString(6, pricetxf.getText());
			
			
			
			st.executeUpdate();
			JOptionPane.showMessageDialog(btnADD, "data saved!!");
			
			st.close();
			con.close();
					
					
					
					
					
					
					
					
					
				} catch (Exception e2) {
					
				}	
			}
		});
		btnADD.setBounds(69, 360, 89, 23);
		contentPane.add(btnADD);
		
		JButton btnUPDATE = new JButton("UPDATE");
		btnUPDATE.setBounds(202, 360, 89, 23);
		contentPane.add(btnUPDATE);
		
		JButton btnDELETE = new JButton("DELETE");
		btnDELETE.setBounds(325, 360, 89, 23);
		contentPane.add(btnDELETE);
		
		events_desctxf = new JTextField();
		events_desctxf.setBounds(213, 118, 96, 20);
		contentPane.add(events_desctxf);
		events_desctxf.setColumns(10);
		
		datetxf = new JTextField();
		datetxf.setBounds(213, 161, 96, 20);
		contentPane.add(datetxf);
		datetxf.setColumns(10);
		
		timetxf = new JTextField();
		timetxf.setBounds(213, 208, 96, 20);
		contentPane.add(timetxf);
		timetxf.setColumns(10);
		
		venuetxf = new JTextField();
		venuetxf.setBounds(213, 260, 96, 20);
		contentPane.add(venuetxf);
		venuetxf.setColumns(10);
		
		event_nametxf = new JTextField();
		event_nametxf.setBounds(213, 74, 96, 20);
		contentPane.add(event_nametxf);
		event_nametxf.setColumns(10);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(356, 119, 5, 5);
		contentPane.add(tabbedPane);
		
		JLabel lblPRICE = new JLabel("price");
		lblPRICE.setBounds(22, 308, 107, 23);
		contentPane.add(lblPRICE);
		
		pricetxf = new JTextField();
		pricetxf.setBounds(213, 305, 96, 20);
		contentPane.add(pricetxf);
		pricetxf.setColumns(10);
		
		JLabel lblid = new JLabel("id");
		lblid.setBounds(10, 48, 49, 14);
		contentPane.add(lblid);
		
		textField = new JTextField();
		textField.setBounds(213, 45, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}

	public void searchEvent(String searchText) {
		// TODO Auto-generated method stub
		
	}
}
