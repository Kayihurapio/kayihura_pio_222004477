package FORM;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.math.BigDecimal;

import FORM.CUSTOMERFORM;

public class TICKET extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JComboBox<String> ticketTypeComboBox;
    private JTextField textField_1;
    private int ticketIdCounter = 0;
    private Connection connection;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TICKET frame = new TICKET();
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
    public TICKET() {
        try {
            // Establish database connection
            String url = "jdbc:mysql://localhost:3306/pio_kayihura_222004477";
            String username = "kayihura";
            String password = "222004477";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 450, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTICKET = new JLabel("TICKET");
        lblTICKET.setBounds(186, 23, 137, 26);
        contentPane.add(lblTICKET);

        JLabel lblTICKET_ID = new JLabel("ticket_id");
        lblTICKET_ID.setBounds(10, 95, 95, 26);
        contentPane.add(lblTICKET_ID);

        JLabel lblTICKET_TYPE = new JLabel("ticket_type");
        lblTICKET_TYPE.setBounds(10, 169, 95, 26);
        contentPane.add(lblTICKET_TYPE);

        JLabel lblPRICE = new JLabel("price");
        lblPRICE.setBounds(10, 239, 95, 26);
        contentPane.add(lblPRICE);

        JButton btnSEND = new JButton("send");
        btnSEND.addActionListener(e -> {
            try {
                // Prepare SQL statement
                String sql = "INSERT INTO Ticket (ticket_type, price) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, (String) ticketTypeComboBox.getSelectedItem());
                
                // Set price based on selected ticket type
                BigDecimal price;
                switch ((String) ticketTypeComboBox.getSelectedItem()) {
                    case "VIP":
                        price = BigDecimal.valueOf(10000);
                        break;
                    case "RUGULAR":
                        price = BigDecimal.valueOf(5000);
                        break;
                    case "GENERAL":
                        price = BigDecimal.valueOf(3000);
                        break;
                    default:
                        price = BigDecimal.ZERO;
                }
                statement.setBigDecimal(2, price);

                // Execute SQL statement
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new ticket was inserted successfully!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        btnSEND.setBounds(68, 351, 117, 32);
        contentPane.add(btnSEND);

        JButton btnCANCEL = new JButton("cancel");
        btnCANCEL.addActionListener(e -> {
            dispose(); // Close the current form (TICKET)
            CUSTOMERFORM customerForm = new CUSTOMERFORM(); // Create an instance of CUSTOMERFORM
            customerForm.setVisible(true); // Display CUSTOMERFORM
        });
        btnCANCEL.setBounds(271, 348, 109, 39);
        contentPane.add(btnCANCEL);

        textField = new JTextField();
        textField.setBounds(155, 92, 180, 39);
        contentPane.add(textField);
        textField.setColumns(10);
        textField.setText(String.valueOf(++ticketIdCounter)); // Auto-incrementing ticket_id

        ticketTypeComboBox = new JComboBox<>();
        ticketTypeComboBox.addItem("VIP");
        ticketTypeComboBox.addItem("RUGULAR");
        ticketTypeComboBox.addItem("GENERAL");
        ticketTypeComboBox.setBounds(155, 169, 180, 26);
        contentPane.add(ticketTypeComboBox);

        textField_1 = new JTextField();
        textField_1.setBounds(155, 239, 180, 26);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        textField_1.setEditable(false); // Price field is not editable by user
    }
}
