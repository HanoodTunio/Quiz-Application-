/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimerTask;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.util.Timer;
import javax.swing.JTextArea;

public class StudentQuizWindow extends JFrame implements ActionListener {

    private JLabel label1;
    private JTextArea textLabel;
    private JRadioButton jOption1;
    private JRadioButton jOption2;
    private JRadioButton jOption3;
    private JRadioButton jOption4;
    private JButton nextButton;
    private JButton submitButton;
    private String tableCategory1;
    private String tableCategory2;
    private String tableCategory3;
    public static JLabel timerLabel;
    ButtonGroup buttonGroup;
    public static int secondsPassed = 60;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctOption;
    private String query1;
    private String query2;
    private String query3;
    public int count = 0;
    private int index = 0;
    private int i = 0;
    public static int score = 0;
    private int minutes = 2;
    private int a = 0, b = 0, c = 0;
    private String a1;
    private String a2;
    ArrayList<String> questionList = new ArrayList<String>();
    ArrayList<ArrayList<String>> x = new ArrayList<ArrayList<String>>();
    ArrayList<String> correctOptionList = new ArrayList<String>();

    StudentQuizWindow() throws ClassNotFoundException, SQLException {
        super("Quiz Time");
        setBounds(151, 56, 1400, 1200);
        getContentPane().setBackground(new Color(93, 138, 168));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setResizable(false);
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Images/quizTime5.PNG"));
        label1 = new JLabel(imageIcon);
        label1.setBounds(128, 0, 800, 200);
        add(label1);

        if (SelectTopicCategory.check2.equals("Basic Java")) {
            tableCategory1 = "CreateQuestions";
            tableCategory2 = "CreateOptions";
            tableCategory3 = "CorrectOptions";
        } else if (SelectTopicCategory.check2.equals("Intermmediate Java")) {
            tableCategory1 = "CreateQuestions2";
            tableCategory2 = "CreateOptions2";
            tableCategory3 = "CorrectOptions2";
        } else if (SelectTopicCategory.check2.equals("Advanced Java")) {
            tableCategory1 = "CreateQuestions3";
            tableCategory2 = "CreateOptions3";
            tableCategory3 = "CorrectOptions3";
        }

        System.out.println(SelectTopicCategory.check2);
        System.out.println(tableCategory1);

        String url = "jdbc:mysql://localhost/Teacher";
        String userName = "root";
        String password = "helloworld#123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, password);

            Statement st = con.createStatement();
            query1 = "select * from " + tableCategory1;
            query2 = "select * from " + tableCategory2;
            query3 = "select * from " + tableCategory3;

            Statement stmt1 = con.createStatement();
            Statement stmt2 = con.createStatement();
            Statement stmt3 = con.createStatement();
            ResultSet rs1 = stmt1.executeQuery(query1);
            ResultSet rs2 = stmt2.executeQuery(query2);
            ResultSet rs3 = stmt3.executeQuery(query3);

            while (rs1.next()) {
                count = rs1.getInt(1);
                question = rs1.getString(2);
                questionList.add(question);
            }
            index = 0;
            while (rs2.next()) {
                option1 = rs2.getString(2);
                option2 = rs2.getString(3);
                option3 = rs2.getString(4);
                option4 = rs2.getString(5);
                x.add(new ArrayList<String>(Arrays.asList(option1, option2, option3, option4)));
            }
            index = 0;
            while (rs3.next()) {
                count = rs3.getInt(1);
                correctOption = rs3.getString(2);
                correctOptionList.add(correctOption);
            }
            count = 1;

            con.close();
        } catch (Exception e) {

        }
        textLabel = new JTextArea("Q" + count + ": " + questionList.get(i));
        textLabel.setFont(new Font("Corbel", Font.BOLD, 21));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(50, 230, 750, 100);
        textLabel.setEditable(false);
        textLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textLabel.setBackground(new Color(93, 138, 168));
        add(textLabel);
        jOption1 = new JRadioButton(x.get(a).get(b));
        jOption1.setForeground(Color.BLACK);
        jOption1.setBackground(new Color(93, 138, 168));
        jOption1.setFont(new Font("Corbel", Font.BOLD, 20));
        jOption1.setBounds(75, 368, 700, 25);
        add(jOption1);
        jOption2 = new JRadioButton(x.get(a).get(b + 1));
        jOption2.setFont(new Font("Corbel", Font.BOLD, 20));
        jOption2.setBounds(75, 438, 700, 25);
        jOption2.setForeground(Color.BLACK);
        jOption2.setBackground(new Color(93, 138, 168));
        add(jOption2);
        jOption3 = new JRadioButton(x.get(a).get(b + 2));
        jOption3.setFont(new Font("Corbel", Font.BOLD, 20));
        jOption3.setBounds(75, 506, 700, 25);
        jOption3.setForeground(Color.BLACK);
        jOption3.setBackground(new Color(93, 138, 168));
        add(jOption3);
        jOption4 = new JRadioButton(x.get(a).get(b + 3));
        jOption4.setFont(new Font("Corbel", Font.BOLD, 20));
        jOption4.setBounds(75, 570, 700, 25);
        jOption4.setForeground(Color.BLACK);
        jOption4.setBackground(new Color(93, 138, 168));
        add(jOption4);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(jOption1);
        buttonGroup.add(jOption2);
        buttonGroup.add(jOption3);
        buttonGroup.add(jOption4);

        nextButton = new JButton("Next  MCQ");
        nextButton.setBounds(870, 380, 110, 60);
        nextButton.setFont(new Font("Corbel", Font.BOLD, 20));
        nextButton.setBackground(new Color(93, 138, 168));
        nextButton.setForeground(Color.BLACK);
        nextButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        nextButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                if (count == 9) {
                    if (jOption1.isSelected()) {
                        a2 = jOption1.getText();
                    } else if (jOption2.isSelected()) {
                        a2 = jOption2.getText();
                    } else if (jOption3.isSelected()) {
                        a2 = jOption3.getText();
                    } else if (jOption4.isSelected()) {
                        a2 = jOption4.getText();
                    }

                    a1 = correctOptionList.get(c);
                    if (a1.equals(a2)) {
                        score += 1;
                    }
                    nextButton.setEnabled(false);
                    submitButton.setEnabled(true);

                }
                if (jOption1.isSelected()) {
                    a2 = jOption1.getText();
                } else if (jOption2.isSelected()) {
                    a2 = jOption2.getText();
                } else if (jOption3.isSelected()) {
                    a2 = jOption3.getText();
                } else if (jOption4.isSelected()) {
                    a2 = jOption4.getText();
                }

                a1 = correctOptionList.get(c);
                if (a1.equals(a2)) {
                    score += 1;

                }

                i++;
                a++;
                count++;
                c++;
                textLabel.setText("Q" + count + ": " + questionList.get(i));
                jOption1.setText(x.get(a).get(b));
                jOption2.setText(x.get(a).get(b + 1));
                jOption3.setText(x.get(a).get(b + 2));
                jOption4.setText(x.get(a).get(b + 3));
                buttonGroup.clearSelection();
            }
        });
        add(nextButton);

        submitButton = new JButton("Submit Quiz");
        submitButton.setBounds(870, 430, 110, 60);
        submitButton.setFont(new Font("Corbel", Font.BOLD, 20));
        submitButton.setBackground(new Color(93, 138, 168));
        submitButton.setForeground(Color.BLACK);
        submitButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        submitButton.setEnabled(false);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //To change body of generated methods, choose Tools | Templates.
                System.out.println(" " + score);
                new ReviewScoreWindow();
                setVisible(false);
            }
        });

        add(submitButton);

        /*fiftyFiftyButton = new JButton("50/50  life-line");
        fiftyFiftyButton.setBounds(870, 480, 130, 60);
        fiftyFiftyButton.setFont(new Font("Corbel", Font.BOLD, 20));
        fiftyFiftyButton.setBackground(new Color(93, 138, 168));
        fiftyFiftyButton.setForeground(Color.BLACK);
        fiftyFiftyButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(fiftyFiftyButton);*/
        System.out.println(" " + score);
        setSize(1100, 650);
        setVisible(true);

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new StudentQuizWindow();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //To change body of generated methods, choose Tools | Templates.
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time Left: " + minutes + ":" + secondsPassed + " seconds"; // 15
        g.setColor(new Color(218, 216, 216));
        g.setFont(new Font("Tahoma", Font.BOLD, 20));

        if (minutes >= 0) {
            g.drawString(time, 820, 350);
        }
        if (secondsPassed == 0) {
            secondsPassed = 10;
            minutes--;
        }
        if (minutes == -1) {
            if (jOption1.isSelected()) {
                a2 = jOption1.getText();
            } else if (jOption2.isSelected()) {
                a2 = jOption2.getText();
            } else if (jOption3.isSelected()) {
                a2 = jOption3.getText();
            } else if (jOption4.isSelected()) {
                a2 = jOption4.getText();
            }

            a1 = correctOptionList.get(c);
            System.out.println(a1.equals(a2));
            System.out.println(a1 + " " + a2);
            System.out.println(correctOptionList.get(c));
            if (a1.equals(a2)) {
                //System.out.println(buttonGroup.getSelection().getActionCommand());
                score += 1;
                System.out.println(" " + score);
            }
            setVisible(false);
            new ReviewScoreWindow();
        }
        secondsPassed--; // 
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
