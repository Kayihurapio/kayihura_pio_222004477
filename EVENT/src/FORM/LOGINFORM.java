package FORM;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class LOGINFORM extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usertxf;
    private JTextField emailtxf;
    private JTextField passwordtxf;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LOGINFORM frame = new LOGINFORM();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LOGINFORM() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200,600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblLOGINFORM = new JLabel("LOGINFORM");
        lblLOGINFORM.setBounds(231, 36, 96, 14);
        contentPane.add(lblLOGINFORM);
        
        JLabel lblEMAIL = new JLabel("EMAIL");
        lblEMAIL.setBounds(28, 160, 89, 19);
        contentPane.add(lblEMAIL);
        
        JLabel lblPASSWORD = new JLabel("PASSWORD");
        lblPASSWORD.setBounds(28, 220, 89, 26);
        contentPane.add(lblPASSWORD);
        
        JButton loginformtxf = new JButton("LOGIN");
        loginformtxf.setBounds(123, 321, 89, 37);
        contentPane.add(loginformtxf);
        
        JButton btnBACK = new JButton("BACK");
        btnBACK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the login form
                REGISTRATION registrationForm = new REGISTRATION();
                registrationForm.setVisible(true); // Open the registration form
            }
        });
        btnBACK.setBounds(334, 321, 89, 37);
        contentPane.add(btnBACK);
        
        usertxf = new JTextField();
        usertxf.setBounds(184, 105, 200, 29);
        contentPane.add(usertxf);
        usertxf.setColumns(10);
        
        emailtxf = new JTextField();
        emailtxf.setBounds(184, 157, 200, 29);
        contentPane.add(emailtxf);
        emailtxf.setColumns(10);
        
        passwordtxf = new JTextField();
        passwordtxf.setBounds(184, 217, 200, 29);
        contentPane.add(passwordtxf);
        passwordtxf.setColumns(10);
        
        JLabel lblUSER_NAME = new JLabel("USER_NAME");
        lblUSER_NAME.setBounds(28, 108, 89, 26);
        contentPane.add(lblUSER_NAME);
        
        JLabel lblUSER_TYPE = new JLabel("USER_TYPE");
        lblUSER_TYPE.setBounds(28, 271, 89, 26);
        contentPane.add(lblUSER_TYPE);
        
        JComboBox<String> user_typetxf = new JComboBox<>(new String[]{"Customer", "Promoter"});
        user_typetxf.setBounds(184, 273, 200, 22);
        contentPane.add(user_typetxf);
        
        // Action listener for the login button
        loginformtxf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
    				Class.forName("com.mysql.cj.jdbc.Driver");

    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/management_event","root","");
    		String sql="INSERT INTO LOGIN VALUES(?,?,?,?)";
    		PreparedStatement st=con.prepareStatement(sql);
    		st.setInt(1, Integer.parseInt(usertxf.getText()));
    		st.setString(2,emailtxf.getText());
    		st.setString(3, passwordtxf.getText());
    		st.setString(4, usertxf.getText());
    		
    		
    		
    		st.executeUpdate();
    		Object logintxf = null;
			JOptionPane.showMessageDialog((Component) logintxf, "data saved!!");
    		
    		st.close();
    		con.close();
    				
    				
    				
    				
    				
    				
    				
    				
    				
    			} catch (Exception e2) {
    				
    			}	
    				
                String userType = (String) user_typetxf.getSelectedItem(); // Get the selected user type
                if ("Customer".equals(userType)) { // If user type is Customer
                    dispose(); // Close the login form
                    CUSTOMERFORM customerForm = new CUSTOMERFORM();
                    customerForm.setVisible(true); // Open the customer homepage
                } else if ("Promoter".equals(userType)) { // If user type is Promoter
                    dispose(); // Close the login form
                    PROMOTER promoterForm = new PROMOTER();
                    promoterForm.setVisible(true); // Open the promoter homepage
                }
            }
        });
    }
}
