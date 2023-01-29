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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author Nasir Abbas Mangrio
 */
public class StartWindow extends JFrame {

    private JButton startButton;
    private JButton backButton;
    private JLabel rulesLabel;

    StartWindow() {
        setBounds(300, 30, 800, 650);
        getContentPane().setBackground(new Color(93, 138, 168));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        JLabel l2 = new JLabel("");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l2.setBounds(20, 100, 600, 450);
        l2.setText(
                "<html>"
                + "1. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>"
                + "2. You may have lot of options in life but here all the questions are compulsory" + "<br><br>"
                + "3. Crying is allowed but please do so quietly." + "<br><br>"
                + "4. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>"
                + "5. Do something today that your future self will thank you for." + "<br><br>"
                + "6. Finish on time, Good Luck" + "<br><br>"
                + "<html>"
        );
        add(l2);

        backButton = new JButton("Back");
        backButton.setBounds(250, 540, 120, 50);
        backButton.setFont(new Font("Corbel", Font.BOLD, 30));
        backButton.setBackground(new Color(93, 138, 168));
        backButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        backButton.setForeground(Color.WHITE);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //To change body of generated methods, choose Tools | Templates.
                setVisible(false);
                new SelectTopicCategory().setVisible(true);
            }
        });

        startButton = new JButton("Start");
        startButton.setBounds(400, 540, 120, 50);
        startButton.setFont(new Font("Corbel", Font.BOLD, 30));
        startButton.setBackground(new Color(93, 138, 168));
        // startButton.setBackground(new Color(30, 144, 255));
        startButton.setForeground(Color.WHITE);
        add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    setVisible(false);
                    new StudentQuizWindow().setVisible(true);//To change body of generated methods, choose Tools | Templates.
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StartWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(StartWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        rulesLabel = new JLabel("Rules ");
        rulesLabel.setBounds(350, 30, 130, 70);
        rulesLabel.setFont(new Font("Corbel", Font.BOLD, 40));
        rulesLabel.setBackground(new Color(93, 138, 168));
        // startButton.setBackground(new Color(30, 144, 255));
        rulesLabel.setForeground(Color.WHITE);
        add(rulesLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new StartWindow();
    }

}
