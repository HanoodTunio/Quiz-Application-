/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JWindow;

/**
 *
 * @author Nasir Abbas Mangrio
 */
public class ReviewScoreWindow extends JFrame {

    private JLabel imageLabel;
    private JLabel imageLabel2;
    private JLabel imageLabel3;
    private JLabel imageLabel4;
    private JLabel imageLabel5;
    private JLabel imageLabel6;
    private JLabel imageLabel7;
    private JLabel imageLabel8;
    private JLabel imageLabel9;
    private JLabel imageLabel10;
    private JLabel reviewScore;
    private JLabel reviewScore1;

    ReviewScoreWindow() {

        if (StudentQuizWindow.score == 10) {

            setBounds(0, 0, 1800, 750);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setLayout(null);
            getContentPane().setBackground(Color.WHITE);

            reviewScore1 = new JLabel("Congratulations !!");
            reviewScore1.setForeground(Color.BLACK);
            reviewScore1.setBackground(new Color(93, 138, 168));
            reviewScore1.setFont(new Font("Corbel", Font.HANGING_BASELINE, 40));
            reviewScore1.setBounds(530, 260, 700, 50);
            add(reviewScore1);
            reviewScore = new JLabel("Your Score is  : " + StudentQuizWindow.score + "/10");
            reviewScore.setForeground(Color.BLACK);
            reviewScore.setBackground(new Color(93, 138, 168));
            reviewScore.setFont(new Font("Corbel", Font.HANGING_BASELINE, 40));
            reviewScore.setBounds(530, 310, 700, 50);
            add(reviewScore);

            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Images/gif2.gif8.GIF"));
            imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(0, 0, 680, 580);
            add(imageLabel);
            ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/Images/gif2.gif8.GIF"));
            imageLabel2 = new JLabel(imageIcon2);
            imageLabel2.setBounds(1000, 0, 500, 90);
            add(imageLabel2);
            ImageIcon imageIcon3 = new ImageIcon(getClass().getResource("/Images/gif2.gif8.GIF"));
            imageLabel3 = new JLabel(imageIcon3);
            imageLabel3.setBounds(0, 220, 680, 580);
            add(imageLabel3);
            ImageIcon imageIcon4 = new ImageIcon(getClass().getResource("/Images/gif2.gif8.GIF"));
            imageLabel4 = new JLabel(imageIcon4);
            imageLabel4.setBounds(500, 0, 500, 90);
            add(imageLabel4);
            ImageIcon imageIcon5 = new ImageIcon(getClass().getResource("/Images/gif2.gif8.GIF"));
            imageLabel5 = new JLabel(imageIcon5);
            imageLabel5.setBounds(610, 03, 780, 600);
            add(imageLabel5);
            ImageIcon imageIcon6 = new ImageIcon(getClass().getResource("/Images/gif2.gif8.GIF"));
            imageLabel6 = new JLabel(imageIcon6);
            imageLabel6.setBounds(0, 0, 500, 90);
            add(imageLabel6);
            ImageIcon imageIcon7 = new ImageIcon(getClass().getResource("/Images/gif2.gif8.GIF"));
            imageLabel7 = new JLabel(imageIcon7);
            imageLabel7.setBounds(650, 510, 700, 200);
            add(imageLabel7);

        } else {

            setBounds(300, 65, 700, 550);
            getContentPane().setBackground(new Color(93, 138, 168));
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setLayout(null);

            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Images/finalScore.png"));
            imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(0, 0, 700, 200);
            add(imageLabel);
            reviewScore = new JLabel("Your Score is  : " + StudentQuizWindow.score + "/10");
            reviewScore.setForeground(Color.WHITE);
            reviewScore.setBackground(new Color(93, 138, 168));
            reviewScore.setFont(new Font("Corbel", Font.HANGING_BASELINE, 36));
            reviewScore.setBounds(230, 328, 700, 50);
            add(reviewScore);
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        ReviewScoreWindow r = new ReviewScoreWindow();
        JWindow subFrame = new JWindow();
        subFrame.setBounds(0, 0, 500, 500);
        subFrame.setAlwaysOnTop(true);
        subFrame.setOpacity(0.50f);
        subFrame.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.05f));
    }

}
