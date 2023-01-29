/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Nasir Abbas Mangrio
 */
public class TopicsWindow extends JFrame {

    private JLabel label1;
    private JLabel textLabel;
    private String[] optionsToChoose;
    public static String check;
    private String tableCategory1;
    private String tableCategory2;
    private String tableCategory3;
    private String query1;
    private String query2;
    private String query3;
    private JButton backButton;

    TopicsWindow() {
        super("Topic Categories");
        setBounds(165, 130, 1000, 500);
        getContentPane().setBackground(new Color(93, 138, 168));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Images/right.png"));
        label1 = new JLabel(imageIcon);
        label1.setBounds(0, 0, 600, 500);
        add(label1);

        textLabel = new JLabel("Choose Quiz Level category !!");
        textLabel.setFont(new Font("Corbel", Font.BOLD, 21));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(600, 110, 300, 20);
        add(textLabel);

        optionsToChoose = new String[]{"Basic Java", "Intermmediate Java", "Advanced Java"};

        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
        jComboBox.setBounds(600, 180, 270, 28);
        jComboBox.setFont(new Font("Corbel", Font.BOLD, 21));
        jComboBox.setForeground(Color.BLACK);
        add(jComboBox);

        String url = "jdbc:mysql://localhost/Teacher";
        String userName = "root";
        String password = "helloworld#123";

        backButton = new JButton("Back");
        backButton.setBounds(650, 350, 120, 50);
        backButton.setFont(new Font("Corbel", Font.BOLD, 30));
        backButton.setBackground(new Color(93, 138, 168));
        backButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        backButton.setForeground(Color.BLACK);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //To change body of generated methods, choose Tools | Templates.
                setVisible(false);
                new StatusWindow().setVisible(true);
            }
        });
        /* if (TopicsWindow.check.equals("Basic Java")) {
            tableCategory1 = "CreateQuestions";
            tableCategory2 = "CreateOptions";
            tableCategory3 = "CorrectOptions";
        }
        if (TopicsWindow.check.equals("Intermmediate Java")) {
            tableCategory1 = "CreateQuestions2";
            tableCategory2 = "CreateOptions2";
            tableCategory3 = "CorrectOptions2";
        }
        if (TopicsWindow.check.equals("Advanced Java")) {
            tableCategory1 = "CreateQuestions3";
            tableCategory2 = "CreateOptions3";
            tableCategory3 = "CorrectOptions3";
        }*/

        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //To change body of generated methods, choose Tools | Templates.
                if (jComboBox.getItemAt(jComboBox.getSelectedIndex()).equals("Basic Java")) {
                    try {
                        check = "Basic Java";
                        setVisible(false);
                        new TeacherWindow().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(StatusWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(StatusWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (jComboBox.getItemAt(jComboBox.getSelectedIndex()).equals("Intermmediate Java")) {
                    try {
                        check = "Intermmediate Java";
                        setVisible(false);
                        new TeacherWindow().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(StatusWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(StatusWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (jComboBox.getItemAt(jComboBox.getSelectedIndex()).equals("Advanced Java")) {
                    try {
                        check = "Advanced Java";
                        tableCategory1 = "CreateQuestions3";
                        tableCategory2 = "CreateOptions3";
                        tableCategory3 = "CorrectOptions3";
                        System.out.println(tableCategory1);
                        System.out.println(tableCategory2);
                        System.out.println(tableCategory3);
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = DriverManager.getConnection(url, userName, password);

                            Statement st = con.createStatement();
                            query1 = "DELETE from " + tableCategory1;
                            query2 = "DELETE from " + tableCategory2;
                            query3 = "DELETE from " + tableCategory3;

                            Statement stmt1 = con.createStatement();
                            Statement stmt2 = con.createStatement();
                            Statement stmt3 = con.createStatement();
                            stmt1.executeUpdate(query1);
                            stmt2.executeUpdate(query2);
                            stmt3.executeUpdate(query3);

                            con.close();
                        } catch (Exception e) {

                        }
                        setVisible(false);
                        new TeacherWindow().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(StatusWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(StatusWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        System.out.println(tableCategory1);
        System.out.println(tableCategory2);
        System.out.println(tableCategory3);
        setVisible(true);

    }

    public static void main(String[] args) {
        new TopicsWindow();
    }

    static class setVisible {

        public setVisible(boolean b) {
        }
    }

}
