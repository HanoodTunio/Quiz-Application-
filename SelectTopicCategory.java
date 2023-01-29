/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Nasir Abbas Mangrio
 */
public class SelectTopicCategory extends JFrame {

    private JLabel label1;
    private JLabel categoryLabel1;
    private JLabel categoryLabel2;
    private JLabel imageLabel1;
    private JLabel imageLabel2;
    private JLabel imageLabel3;
    private JLabel textLabel1;
    private JLabel textLabel2;
    private JLabel textLabel3;
    private JLabel url_Label1;
    private JLabel url_Label2;
    private JLabel url_Label3;
    private JLabel url_Label4;
    public static String check2;
    private JButton backButton;

    SelectTopicCategory() {
        super("Select Topic Category");
        setBounds(156, 95, 1100, 600);
        getContentPane().setBackground(new Color(93, 138, 168));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Images/select.png"));
        label1 = new JLabel(imageIcon);
        label1.setBounds(150, 0, 700, 200);
        add(label1);

        /* ImageIcon image1 = new ImageIcon(getClass().getResource("/Images/shape.png"));
        imageLabel1 = new JLabel(image1);
        imageLabel1.setBounds(50, 120, 300, 20);
        add(imageLabel1);*/
        categoryLabel1 = new JLabel("Defined categories");
        categoryLabel1.setFont(new Font("Arial", Font.HANGING_BASELINE, 24));
        categoryLabel1.setForeground(Color.BLACK);
        categoryLabel1.setBounds(100, 200, 500, 28);
        add(categoryLabel1);

        categoryLabel2 = new JLabel("Built-in categories");
        categoryLabel2.setFont(new Font("Arial", Font.HANGING_BASELINE, 24));
        categoryLabel2.setForeground(Color.BLACK);
        categoryLabel2.setBounds(700, 200, 350, 28);
        add(categoryLabel2);

        textLabel1 = new JLabel("Basic Java");
        textLabel1.setFont(new Font("Arial", Font.HANGING_BASELINE, 22));
        textLabel1.setBounds(120, 270, 300, 25);
        add(textLabel1);

        textLabel2 = new JLabel("Intermmediate Java");
        textLabel2.setFont(new Font("Arial", Font.HANGING_BASELINE, 22));
        textLabel2.setBounds(120, 340, 300, 25);
        add(textLabel2);

        textLabel3 = new JLabel("Advanced Java");
        textLabel3.setFont(new Font("Arial", Font.HANGING_BASELINE, 22));
        textLabel3.setBounds(120, 410, 300, 25);
        add(textLabel3);

        textLabel1.setForeground(Color.BLUE.darker());
        textLabel1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        textLabel2.setForeground(Color.BLUE.darker());
        textLabel2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        textLabel3.setForeground(Color.BLUE.darker());
        textLabel3.setCursor(new Cursor(Cursor.HAND_CURSOR));

        textLabel1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    check2 = "Basic Java";
                    new StartWindow();
                    setVisible(false);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        textLabel2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    check2 = "Intermmediate Java";
                    setVisible(false);
                    new StartWindow();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        textLabel3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    check2 = "Advanced Java";
                    setVisible(false);
                    new StartWindow();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        url_Label1 = new JLabel("Basic Java");
        url_Label1.setFont(new Font("Arial", Font.HANGING_BASELINE, 22));
        url_Label1.setBounds(720, 270, 300, 25);
        add(url_Label1);

        url_Label2 = new JLabel("Intermmediate Java");
        url_Label2.setFont(new Font("Arial", Font.HANGING_BASELINE, 22));
        url_Label2.setBounds(720, 340, 300, 25);
        add(url_Label2);

        url_Label3 = new JLabel("Advanced Java");
        url_Label3.setFont(new Font("Arial", Font.HANGING_BASELINE, 22));
        url_Label3.setBounds(720, 410, 300, 25);
        add(url_Label3);

        url_Label1.setForeground(Color.BLUE.darker());
        url_Label1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        url_Label2.setForeground(Color.BLUE.darker());
        url_Label2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        url_Label3.setForeground(Color.BLUE.darker());
        url_Label3.setCursor(new Cursor(Cursor.HAND_CURSOR));

        backButton = new JButton("Back");
        backButton.setBounds(440, 450, 180, 50);
        backButton.setFont(new Font("Corbel", Font.HANGING_BASELINE, 30));
        backButton.setBackground(new Color(93, 138, 168));
        backButton.setForeground(Color.BLACK);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //To change body of generated methods, choose Tools | Templates.
                setVisible(false);
                try {
                    new StudentInfo().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SelectTopicCategory.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SelectTopicCategory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        url_Label1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.studytonight.com/java/tests/1"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });
        url_Label2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.studytonight.com/java/tests/4"));

                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });

        url_Label3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {

                    Desktop.getDesktop().browse(new URI("https://www.studytonight.com/java/tests/8"));

                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }

        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new SelectTopicCategory();
    }

    static class setVisible {

        public setVisible(boolean b) {
        }
    }

}
