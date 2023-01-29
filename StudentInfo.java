package finalproject;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author Nasir Abbas Mangrio
 */
public class StudentInfo extends JFrame {

    private JLabel label1;
    private JLabel label2;
    private JLabel nameLabel;
    private JLabel cmsLabel;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JTextField nameTextField;
    private JTextField cmsTextField;
    private JButton backButton;
    private JButton nextButton;
    private JButton OkayButton;
    private String name;
    private String email;
    private String cms_id;
    private int count = 0;

    StudentInfo() throws SQLException, ClassNotFoundException {

        super("Student Information.");
        UIManager.put("Button.disabledText", new ColorUIResource(Color.BLACK));
        setBounds(168, 140, 1000, 500);
        getContentPane().setBackground(new Color(93, 138, 168));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Images/ClockImage.png"));
        label1 = new JLabel(imageIcon);
        label1.setBounds(0, 0, 500, 500);
        add(label1);

        nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Corbel", Font.BOLD, 24));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(600, 120, 300, 20);
        add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 22));
        nameTextField.setBounds(670, 115, 250, 25);
        nameTextField.setBackground(new Color(93, 138, 168));
        nameTextField.setForeground(Color.BLACK);
        nameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(nameTextField);

        cmsLabel = new JLabel("CMS_ID: ");
        cmsLabel.setFont(new Font("Corbel", Font.BOLD, 24));
        cmsLabel.setForeground(Color.BLACK);
        cmsLabel.setBounds(600, 240, 300, 20);
        add(cmsLabel);

        cmsTextField = new JTextField();
        cmsTextField.setFont(new Font("Arial", Font.BOLD, 22));
        cmsTextField.setBounds(699, 232, 250, 25);
        cmsTextField.setBackground(new Color(93, 138, 168));
        cmsTextField.setForeground(Color.BLACK);
        cmsTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(cmsTextField);

        emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Corbel", Font.BOLD, 24));
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setBounds(600, 180, 300, 20);
        add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.BOLD, 22));
        emailTextField.setBounds(670, 173, 250, 25);
        emailTextField.setBackground(new Color(93, 138, 168));
        emailTextField.setForeground(Color.BLACK);
        emailTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(emailTextField);

        backButton = new JButton("Back ");
        backButton.setBounds(600, 350, 110, 60);
        backButton.setFont(new Font("Corbel", Font.BOLD, 20));
        backButton.setBackground(new Color(93, 138, 168));
        backButton.setForeground(Color.BLACK);
        backButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(backButton);

        OkayButton = new JButton("Okay");
        OkayButton.setBounds(700, 350, 110, 60);
        OkayButton.setFont(new Font("Corbel", Font.BOLD, 20));
        OkayButton.setBackground(new Color(93, 138, 168));
        OkayButton.setForeground(Color.BLACK);
        OkayButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(OkayButton);

        nextButton = new JButton("Next");
        nextButton.setBounds(800, 350, 110, 60);
        nextButton.setFont(new Font("Corbel", Font.BOLD, 20));
        nextButton.setBackground(new Color(93, 138, 168));
        nextButton.setForeground(Color.BLACK);
        nextButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(nextButton);
        nextButton.setEnabled(false);
        //  nextButton.(Color)Object /*get*/ = UIManager.getLookAndFeelDefaults().get("Button.disabledText");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //To change body of generated methods, choose Tools | Templates.               
                setVisible(false);
                new StatusWindow().setVisible(true);
            }
        });

        OkayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //To change body of generated methods, choose Tools | Templates.

                name = nameTextField.getText();
                cms_id = cmsTextField.getText();
                email = emailTextField.getText();

                if (email.equals("") || cms_id.equals("") || name.equals("")) {
                    JOptionPane.showMessageDialog(null, " All fields are mendatory.");
                    nextButton.setEnabled(false);
                } else if (!email.contains("@gmail.com")) {
                    if (!email.contains("@iba-suk.edu.pk")) {
                        JOptionPane.showMessageDialog(null, " Incorrect email!");
                        nextButton.setEnabled(false);
                    }
                } else if (!email.contains("@iba-suk.edu.pk")) {
                    if (!email.contains("@gmail.com")) {
                        JOptionPane.showMessageDialog(null, " Incorrect email!");
                        nextButton.setEnabled(false);
                    }
                }

                if ((!email.equals("") && !cms_id.equals("") && !name.equals("")) && (email.contains("@iba-suk.edu.pk") || email.contains("@gmail.com"))) {
                    JOptionPane.showMessageDialog(null, " Eligible to attempt quiz!");
                    nextButton.setEnabled(true);

                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //To change body of generated methods, choose Tools | Templates.
                setVisible(false);
                new SelectTopicCategory();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new StudentInfo();
    }
}
