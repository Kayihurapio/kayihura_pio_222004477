package FORM;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import FORM.TICKET;

public class CUSTOMERFORM extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchTextField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CUSTOMERFORM frame = new CUSTOMERFORM();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CUSTOMERFORM() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 450, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblCUSTOMERHOMEPAGE = new JLabel("CUSTOMER DASHBOARD");
        lblCUSTOMERHOMEPAGE.setBounds(132, 29, 185, 25);
        contentPane.add(lblCUSTOMERHOMEPAGE);
        
        JLabel lblSearch = new JLabel("Search:");
        lblSearch.setBounds(40, 80, 60, 20);
        contentPane.add(lblSearch);
        
        searchTextField = new JTextField();
        searchTextField.setBounds(100, 80, 200, 20);
        contentPane.add(searchTextField);
        
        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(320, 80, 80, 20);
        contentPane.add(btnSearch);
        
        // Remaining code for displaying event details
        // Add JLabels and JTextFields for event details as needed
        
        JButton btnBUY = new JButton("BUY");
        btnBUY.addActionListener(e -> {
            TICKET ticketForm = new TICKET(); // Creating an instance of TICKET form
            ticketForm.setVisible(true); // Displaying TICKET form
            dispose(); // Closing the current form (CUSTOMERFORM)
        });
        btnBUY.setBounds(170, 120, 100, 30);
        contentPane.add(btnBUY);
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> {
            dispose(); // Close the current form (CUSTOMERFORM)
            // You may add additional logic here if needed
        });
        btnCancel.setBounds(280, 120, 100, 30);
        contentPane.add(btnCancel);
    }
}
