/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Nasir Abbas Mangrio
 */
public class TeacherWindow extends JFrame {

    private JFrame frame;
    private JLabel label;
    private JTextArea textField;
    private JLabel optionLabel1;
    private JLabel optionLabel2;
    private JLabel optionLabel3;
    private JLabel optionLabel4;
    private JLabel correctOptionLabel;
    private JTextField correctOptionTextField;
    private JTextField optionTextField1;
    private JTextField optionTextField2;
    private JTextField optionTextField3;
    private JTextField optionTextField4;
    private JButton addButton;
    private JButton nextButton;
    private JButton finishButton;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctOption;
    public static int count1 = 1;
    public static int count2 = 1;
    public static int count3 = 1;
    private String tableCategory1;
    private String tableCategory2;
    private String tableCategory3;

    TeacherWindow() throws SQLException, ClassNotFoundException {
        super("Create Quiz");
        setBounds(180, 130, 1500, 900);
        getContentPane().setBackground(new Color(93, 138, 168));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        label = new JLabel("         Question " + " :)");
        label.setFont(new Font("Corbel", Font.BOLD, 20));
        label.setSize(400, 70);
        label.setForeground(Color.BLACK);
        add(label);
        textField = new JTextArea();
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        textField.setBounds(150, 26, 730, 90);
        textField.setBackground(new Color(93, 138, 168));
        //textField.setEditable(false);
        textField.setForeground(Color.BLACK);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(textField);

        optionLabel1 = new JLabel("          Option1 :)");
        optionLabel1.setFont(new Font("Corbel", Font.BOLD, 20));
        optionLabel1.setSize(450, 260);
        optionLabel1.setForeground(Color.BLACK);
        add(optionLabel1);
        optionTextField1 = new JTextField();
        optionTextField1.setFont(new Font("Arial", Font.BOLD, 18));
        optionTextField1.setBounds(140, 120, 730, 20);
        optionTextField1.setBackground(new Color(93, 138, 168));
        optionTextField1.setForeground(Color.BLACK);
        optionTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(optionTextField1);

        optionLabel2 = new JLabel("          Option2 :)");
        optionLabel2.setFont(new Font("Corbel", Font.BOLD, 20));
        optionLabel2.setSize(400, 370);
        optionLabel2.setForeground(Color.BLACK);
        add(optionLabel2);
        optionTextField2 = new JTextField();
        optionTextField2.setFont(new Font("Arial", Font.BOLD, 18));
        optionTextField2.setBounds(140, 175, 730, 20);
        optionTextField2.setBackground(new Color(93, 138, 168));
        optionTextField2.setForeground(Color.BLACK);
        optionTextField2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(optionTextField2);

        optionLabel3 = new JLabel("          Option3 :)");
        optionLabel3.setFont(new Font("Corbel", Font.BOLD, 20));
        optionLabel3.setSize(450, 485);
        optionLabel3.setForeground(Color.BLACK);
        add(optionLabel3);
        optionTextField3 = new JTextField();
        optionTextField3.setFont(new Font("Arial", Font.BOLD, 18));
        optionTextField3.setBounds(140, 236, 730, 20);
        optionTextField3.setBackground(new Color(93, 138, 168));
        optionTextField3.setForeground(Color.BLACK);
        optionTextField3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(optionTextField3);

        optionLabel4 = new JLabel("          Option4 :)");
        optionLabel4.setFont(new Font("Corbel", Font.BOLD, 20));
        optionLabel4.setSize(400, 590);
        optionLabel4.setForeground(Color.BLACK);
        add(optionLabel4);
        optionTextField4 = new JTextField();
        optionTextField4.setFont(new Font("Arial", Font.BOLD, 18));
        optionTextField4.setBounds(140, 285, 730, 20);
        optionTextField4.setBackground(new Color(93, 138, 168));
        optionTextField4.setForeground(Color.BLACK);
        optionTextField4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(optionTextField4);

        correctOptionLabel = new JLabel("          Correct option :)");
        correctOptionLabel.setFont(new Font("Corbel", Font.BOLD, 20));
        correctOptionLabel.setSize(400, 700);
        correctOptionLabel.setForeground(Color.BLACK);
        add(correctOptionLabel);
        correctOptionTextField = new JTextField();
        correctOptionTextField.setFont(new Font("Arial", Font.BOLD, 18));
        correctOptionTextField.setBounds(190, 339, 730, 20);
        correctOptionTextField.setBackground(new Color(93, 138, 168));
        correctOptionTextField.setForeground(Color.BLACK);
        correctOptionTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(correctOptionTextField);

        addButton = new JButton("Add Question");
        addButton.setBounds(140, 390, 200, 60);
        addButton.setFont(new Font("Corbel", Font.BOLD, 20));
        addButton.setBackground(new Color(93, 138, 168));
        addButton.setForeground(Color.BLACK);
        addButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(addButton);

        nextButton = new JButton("Next Question");
        nextButton.setBounds(350, 390, 200, 60);
        nextButton.setFont(new Font("Corbel", Font.BOLD, 20));
        nextButton.setBackground(new Color(93, 138, 168));
        nextButton.setForeground(Color.BLACK);
        nextButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(nextButton);

        finishButton = new JButton("Finish");
        finishButton.setBounds(560, 390, 200, 60);
        finishButton.setFont(new Font("Corbel", Font.BOLD, 20));
        finishButton.setBackground(new Color(93, 138, 168));
        finishButton.setForeground(Color.BLACK);
        finishButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(finishButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //To change body of generated methods, choose Tools | Templates.
                textField.setText("");
                optionTextField1.setText("");
                optionTextField2.setText("");
                optionTextField3.setText("");
                optionTextField4.setText("");
                correctOptionTextField.setText("");
            }
        });

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //To change body of generated methods, choose Tools | Templates.
                setVisible(false);
                new StatusWindow().setVisible(true);
            }
        });

        String url = "jdbc:mysql://localhost/Teacher";
        String userName = "root";
        String password = "helloworld#123";

        if (TopicsWindow.check.equals("Basic Java")) {
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
        }
        /*if(SelectTopicCategory.check2.equals("Basic Java")){
             tableCategory1="CreateQuestions";
             tableCategory2="CreateOptions";
             tableCategory3="CorrectOptions";
        }
         if(SelectTopicCategory.check2.equals("Intermmediate Java")){
             tableCategory1="CreateQuestions2";
             tableCategory2="CreateOptions2";
             tableCategory3="CorrectOptions2";
        }
         /*if(SelectTopicCategory.check2.equals("Advanced  Java")){
             tableCategory1="CreateQuestions3";
             tableCategory2="CreateOptions3";
             tableCategory3="CorrectOptions3";
        }*/

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                //To change body of generated methods, choose Tools | Templates.
                if (textField.getText().equals("") || optionTextField1.getText().equals("") || optionTextField2.getText().equals("") || optionTextField3.getText().equals("") || optionTextField4.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, " all fields are mendatory!");
                    }
                else{
                    try {

                    question = textField.getText();
                    option1 = optionTextField1.getText();
                    option2 = optionTextField2.getText();
                    option3 = optionTextField3.getText();
                    option4 = optionTextField4.getText();
                    correctOption = correctOptionTextField.getText();

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, userName, password);

                    Statement st = con.createStatement();
                    PreparedStatement stmt = con.prepareStatement("insert into " + tableCategory1 + " values (?,?)");
                    stmt.setInt(1, count1);
                    stmt.setString(2, question);
                    stmt.executeUpdate();
                    stmt.close();

                    PreparedStatement stmt2 = con.prepareStatement("insert into " + tableCategory2 + " values (?,?,?,?,?)");
                    stmt2.setInt(1, count2);
                    stmt2.setString(2, option1);
                    stmt2.setString(3, option2);
                    stmt2.setString(4, option3);
                    stmt2.setString(5, option4);
                    stmt2.executeUpdate();
                    stmt2.close();

                    PreparedStatement stmt3 = con.prepareStatement("insert into " + tableCategory3 + " values (?,?)");
                    stmt3.setInt(1, count3);
                    stmt3.setString(2, correctOption);
                    stmt3.executeUpdate();
                    stmt3.close();

                    con.close();
                    
                    JOptionPane.showMessageDialog(null, count1 + " Question has been added");

                    count1++;
                    count2++;
                    count3++;
                } catch (Exception e) {

                }
                }
                

            }
        });

        setSize(1000, 500);
        setVisible(true);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new TeacherWindow();
    }

    void setVisible() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
