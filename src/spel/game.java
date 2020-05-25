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
    private Integer scoreCount = 1;

    private static String host = "jdbc:mysql://localhost:3306/game";

    private static String uname = "username";
    private static String upasswd = "password";

    private String spelpjas = "X";

    public static void main(String[] args) {

        JFrame frame = new JFrame("treirad");
        frame.setContentPane(new game().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private void valjspelare() {
        if (spelpjas.equalsIgnoreCase("X")) {
            spelpjas = "O";
        } else {
            spelpjas = "X";
            scoreCount++;
        }
    }

    //inte jättefina spelregler men de fungerar
    private void KollaVinnare() {
        //horisontellt
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
        //snett
        else if (button1.getText()==("O") && button5.getText() == ("O") && button9.getText() == ("O")){
            Presenteravinnare();
            Nollstall();
        }
        else if (button1.getText()==("X") && button5.getText() == ("X") && button9.getText() == ("X")){
            Presenteravinnare();
            Nollstall();
        }
        else if (button3.getText()==("X") && button5.getText() == ("X") && button7.getText() == ("X")){
            Presenteravinnare();
            Nollstall();
        }
        else if (button3.getText()==("O") && button5.getText() == ("O") && button7.getText() == ("O")){
            Presenteravinnare();
            Nollstall();
        }
        //vertikalt
        else if (button1.getText()==("X") && button4.getText() == ("X") && button7.getText() == ("X")){
            Presenteravinnare();
            Nollstall();
        }
        else if (button1.getText()==("O") && button4.getText() == ("O") && button7.getText() == ("O")){
            Presenteravinnare();
            Nollstall();
        }
        else if (button2.getText()==("X") && button5.getText() == ("X") && button8.getText() == ("X")){
            Presenteravinnare();
            Nollstall();
        }
        else if (button2.getText()==("O") && button5.getText() == ("O") && button8.getText() == ("O")){
            Presenteravinnare();
            Nollstall();
        }
        else if (button3.getText()==("X") && button6.getText() == ("X") && button9.getText() == ("X")){
            Presenteravinnare();
            Nollstall();
        }
        else if (button3.getText()==("O") && button6.getText() == ("O") && button9.getText() == ("O")){
            Presenteravinnare();
            Nollstall();
        }
        inithighscore();
    }

    private void Presenteravinnare() {
        saveHighscore();
        JOptionPane.showMessageDialog(null, namn + " vann. Du fick score: " + scoreCount);
        scoreCount = 1;

    }

    private void saveHighscore() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(host, uname, upasswd);
            Statement stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO `highscore` (id,namn,score, datum ) VALUES (id,?,?, now())");

            pstmt.setString(1, namn);
            pstmt.setInt(2, scoreCount);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
                button1.setText(spelpjas);
                spelpjas.equalsIgnoreCase(spelpjas);
                valjspelare();
                KollaVinnare();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setText(spelpjas);
                spelpjas.equalsIgnoreCase(spelpjas);
                valjspelare();
                KollaVinnare();
            }

        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3.setText(spelpjas);
                spelpjas.equalsIgnoreCase(spelpjas);
                valjspelare();
                KollaVinnare();
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button4.setText(spelpjas);
                spelpjas.equalsIgnoreCase(spelpjas);
                valjspelare();
                KollaVinnare();
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button5.setText(spelpjas);
                spelpjas.equalsIgnoreCase(spelpjas);
                valjspelare();
                KollaVinnare();
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button6.setText(spelpjas);
                spelpjas.equalsIgnoreCase(spelpjas);
                valjspelare();
                KollaVinnare();
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button7.setText(spelpjas);
                spelpjas.equalsIgnoreCase(spelpjas);
                valjspelare();
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button8.setText(spelpjas);
                spelpjas.equalsIgnoreCase(spelpjas);
                valjspelare();
                KollaVinnare();
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button9.setText(spelpjas);
                spelpjas.equalsIgnoreCase(spelpjas);
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
        inithighscore();
    }

    private void createUIComponents() {
    }
    private void inithighscore(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(host, uname, upasswd);
            Statement stmt = con.createStatement();
            ResultSet myRes = stmt.executeQuery("SELECT * FROM `highscore` ORDER BY SCORE; ");

            ArrayList<String> resultVisning = new ArrayList<String>();
            resultVisning.add("HIGHSCORES");
            resultVisning.add("__________");
            while (myRes.next()){
                resultVisning.add(myRes.getString("score") + " "
                                + myRes.getString("namn") + " "
                        /*+ myRes.getString("datum")*/);
            }

            list1.setListData(resultVisning.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

