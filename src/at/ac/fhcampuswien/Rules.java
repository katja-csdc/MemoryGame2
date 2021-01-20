package at.ac.fhcampuswien;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Rules {



 ImageIcon ico = new ImageIcon("src/images/1.png");



    public int  printRules(){
        ImageIcon icon = new ImageIcon("src/images/icon.jpg");
        String[] options = { "Verstanden" };
       JOptionPane.showMessageDialog(null, "Memory-Game", "Team-Profi", JOptionPane.WHEN_IN_FOCUSED_WINDOW, icon);

        return JOptionPane.showOptionDialog(null,"<html>  <div align='center'><h2>Spielregeln<h2></div>" +
                "<u>Folgende Regeln muss du beachten und einhalten umd zu gewinnen!\n  " +
                "* alle Steine werden versteckt dargestellt. \n" +
                "* Die Spieler decken wechselweise zwei Steine auf und merken sich\n" +
                "* deren Position.\n" +
                "* Angeklickte Stein-Paare werden für zwei Sekunden gezeigt.\n" +
                "* Zeigen sie identische Muster werden sie gelöscht \n" +
                "* Wenn sie keine identischen Muster zeigen, werden sie wieder umgedreht ","Spielregeln", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, icon , options, options[0]);}




    public static void main(String[] args){
        Rules rules=new Rules();
        rules.printRules();

}}