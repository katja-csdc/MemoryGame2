package at.ac.fhcampuswien;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Rules {



 ImageIcon ico = new ImageIcon("src/images/1.png");



    public int  printRules() {
        ImageIcon icon = new ImageIcon("src/images/icon.jpg");
        String[] options = {"Understood"};
        JOptionPane.showMessageDialog(null, "Memory Game", "Team Profi", JOptionPane.WHEN_IN_FOCUSED_WINDOW, icon);

        return JOptionPane.showOptionDialog(null, "<html>  <div align='center'><h2>Game Rules<h2></div>" +
                        "*The following rules mustn't be ignored and must be adhered to as to win!\n" +
                        "* All cards will be hidden at the start.\n" +
                        "* The players will take turns turning around 2 cards each and remembering their\n" +
                        "* position.\n" +
                        "* Clicked card pairs will be shown for 2 seconds.\n" +
                        "* If they are identical the cards won't be clickable anymore. \n" +
                        "* If they aren't identical the cards will turn around again. ", "Game Rules", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
    }
}