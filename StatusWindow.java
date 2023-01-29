package finalproject;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatusWindow extends JFrame {

    private JLabel label1;
    private JLabel label2;
    private JLabel textLabel;
    private JTextField textField;
    private JButton jButton;
    private String[] optionsToChoose;

    StatusWindow() {
        super("Status Window");
        setBounds(165, 130, 1000, 500);
        getContentPane().setBackground(new Color(93, 138, 168));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Images/StudentTeacherBoth.png"));
        label1 = new JLabel(imageIcon);
        label1.setBounds(0, 0, 600, 500);
        add(label1);

        textLabel = new JLabel("Select Your Status...");
        textLabel.setFont(new Font("Corbel", Font.BOLD, 21));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(700, 120, 300, 20);
        add(textLabel);

        optionsToChoose = new String[]{"Teacher", "Student"};

        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
        jComboBox.setBounds(700, 180, 140, 28);
        jComboBox.setFont(new Font("Corbel", Font.BOLD, 21));
        jComboBox.setForeground(Color.BLACK);

        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //To change body of generated methods, choose Tools | Templates.
                if (jComboBox.getItemAt(jComboBox.getSelectedIndex()).equals("Student")) {
                    try {
                        setVisible(false);
                        new StudentInfo().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(StatusWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(StatusWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    setVisible(false);
                    new TopicsWindow().setVisible(true);
                }
            }
        });
        add(jComboBox);

        setVisible(true);

    }

    public static void main(String[] args) {
        new StatusWindow();
    }
}
