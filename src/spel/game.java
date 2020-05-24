package spel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

import static javax.swing.JList.*;

public class game {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton restart;
    private JList list1;
    private String namn;

    private static String host = "jdbc:mysql://localhost:3306/game";

    private static String uname = "username";
    private static String upasswd = "password";

    private String startaspel = "X";

    public static void main(String[] args) {

        Connection con = null;
        try {
            con = DriverManager.getConnection(host, uname, upasswd);
            Statement stmt = con.createStatement();
            ResultSet myRes = stmt.executeQuery("SELECT * FROM `highscore`; ");
            while (myRes.next()){
                System.out.println(myRes.getString("namn")+ myRes.getString("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        JFrame frame = new JFrame("treirad");
        frame.setContentPane(new game().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private void valjspelare() {
        if (startaspel.equalsIgnoreCase("X")) {
            startaspel = "O";
        } else {
            startaspel = "X";
        }
    }

    private void KollaVinnare() {
        if (button1.getText()==("X") && button2.getText() == ("X") && button3.getText() == ("X")){
            Presenteravinnare();
            Nollstall();
        }
        else if (button1.getText()==("O") && button2.getText() == ("O") && button3.getText() == ("O")){
            Presenteravinnare();
            Nollstall();
        }
        else if (button4.getText()==("X") && button5.getText() == ("X") && button6.getText() == ("X")){
            Presenteravinnare();
            Nollstall();
        }
        else if (button4.getText()==("O") && button5.getText() == ("O") && button6.getText() == ("O")){
            Presenteravinnare();
            Nollstall();
        }
        else if (button7.getText()==("X") && button8.getText() == ("X") && button9.getText() == ("X")){
            Presenteravinnare();
            Nollstall();
        }
        else if (button7.getText()==("O") && button8.getText() == ("O") && button9.getText() == ("O")){
            Presenteravinnare();
            Nollstall();
        }


    }

    private void Presenteravinnare() {
        JOptionPane.showMessageDialog(null, namn + " vann");
    }

    private void Nollstall() {
        button1.setText(null);
        button2.setText(null);
        button3.setText(null);
        button4.setText(null);
        button5.setText(null);
        button6.setText(null);
        button7.setText(null);
        button8.setText(null);
        button9.setText(null);
    }


    public game() {
        namn = JOptionPane.showInputDialog(null, "skriv ditt namn");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setText(startaspel);
                startaspel.equalsIgnoreCase(startaspel);
                valjspelare();
                KollaVinnare();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setText(startaspel);
                startaspel.equalsIgnoreCase(startaspel);
                valjspelare();
                KollaVinnare();
            }

        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3.setText(startaspel);
                startaspel.equalsIgnoreCase(startaspel);
                valjspelare();
                KollaVinnare();
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button4.setText(startaspel);
                startaspel.equalsIgnoreCase(startaspel);
                valjspelare();
                KollaVinnare();
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button5.setText(startaspel);
                startaspel.equalsIgnoreCase(startaspel);
                valjspelare();
                KollaVinnare();
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button6.setText(startaspel);
                startaspel.equalsIgnoreCase(startaspel);
                valjspelare();
                KollaVinnare();
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button7.setText(startaspel);
                startaspel.equalsIgnoreCase(startaspel);
                valjspelare();
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button8.setText(startaspel);
                startaspel.equalsIgnoreCase(startaspel);
                valjspelare();
                KollaVinnare();
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button9.setText(startaspel);
                startaspel.equalsIgnoreCase(startaspel);
                valjspelare();
                KollaVinnare();
            }
        });
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Nollstall();
            }
        });
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);



    }

    private void createUIComponents() {
    }
}
