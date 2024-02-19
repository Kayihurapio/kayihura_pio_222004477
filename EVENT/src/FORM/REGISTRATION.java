package FORM;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import FORM.LOGINFORM;

public class REGISTRATION extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usertxf;
    private JTextField emailtxf;
    private JTextField phonetxf;
    private JTextField passwordtxf;
    private JTextField user_typetxf;

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost/pio_kayihura_222004477";
    private static final String DB_USER = "kayihura";
    private static final String DB_PASSWORD = "222004477";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    REGISTRATION frame = new REGISTRATION();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public REGISTRATION() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblREGISTERATIONFORM = new JLabel("REGISTRATIONFORM");
        lblREGISTERATIONFORM.setBounds(189, 11, 191, 24);
        contentPane.add(lblREGISTERATIONFORM);
        
        JLabel lblUSER_NAME = new JLabel("username");
        lblUSER_NAME.setBounds(24, 87, 100, 14);
        contentPane.add(lblUSER_NAME);
        
        JLabel lblEMAIL = new JLabel("email");
        lblEMAIL.setBounds(24, 137, 100, 14);
        contentPane.add(lblEMAIL);
        
        JLabel lblPHONE = new JLabel("phone");
        lblPHONE.setBounds(24, 190, 100, 14);
        contentPane.add(lblPHONE);
        
        JLabel lblPASSWORD = new JLabel("password");
        lblPASSWORD.setBounds(24, 252, 100, 14);
        contentPane.add(lblPASSWORD);
        
        usertxf = new JTextField();
        usertxf.setBounds(170, 84, 210, 33);
        contentPane.add(usertxf);
        usertxf.setColumns(10);
        
        emailtxf = new JTextField();
        emailtxf.setBounds(170, 134, 210, 33);
        contentPane.add(emailtxf);
        emailtxf.setColumns(10);
        
        phonetxf = new JTextField();
        phonetxf.setBounds(170, 187, 210, 33);
        contentPane.add(phonetxf);
        phonetxf.setColumns(10);
        
        passwordtxf = new JTextField();
        passwordtxf.setBounds(170, 249, 210, 33);
        contentPane.add(passwordtxf);
        passwordtxf.setColumns(10);
        
        JLabel lblUSER_TYPE = new JLabel("user_type");
        lblUSER_TYPE.setBounds(24, 300, 100, 14);
        contentPane.add(lblUSER_TYPE);
        
        user_typetxf = new JTextField();
        user_typetxf.setBounds(170, 297, 210, 33);
        contentPane.add(user_typetxf);
        user_typetxf.setColumns(10);
        
        JButton btnAlreadyHaveAccount = new JButton("ALREADY HAVE ACCOUNT");
        btnAlreadyHaveAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the registration form
                LOGINFORM loginForm = new LOGINFORM();
                loginForm.setVisible(true); // Open the login form
            }
        });
        btnAlreadyHaveAccount.setBounds(310, 407, 199, 37);
        contentPane.add(btnAlreadyHaveAccount);
        
        JButton btnSIGN_IN = new JButton("SIGN_IN");
        btnSIGN_IN.setBounds(91, 414, 89, 30);
        contentPane.add(btnSIGN_IN);
        
        // Action listener for SIGN_IN button
        btnSIGN_IN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get data from text fields
                String username = usertxf.getText();
                String email = emailtxf.getText();
                String phone = phonetxf.getText();
                String password = passwordtxf.getText();
                String userType = user_typetxf.getText();
                
                // Insert data into database
                try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                    String query = "INSERT INTO users (username, email, phone, password, user_type) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement statement = conn.prepareStatement(query);
                    statement.setString(1, username);
                    statement.setString(2, email);
                    statement.setString(3, phone);
                    statement.setString(4, password);
                    statement.setString(5, userType);
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(contentPane, "User registered successfully!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(contentPane, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
