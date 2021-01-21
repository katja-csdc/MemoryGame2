package at.ac.fhcampuswien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

//serial//
public class Board extends JFrame {

    private List<Card> cards;
    private Card selectedCard;
    private Card c1;
    private Card c2;
    Icon icon = new ImageIcon("src/images/icon.png"); //upside down image
    private Timer t;
    //i need that int for the colorswitch -LILI
    public int turn = 1;
    public int score1 = 0;
    public int score2 = 0;
    Player p = new Player();

    public Board() {
        int pairs = 10;
        List<Card> cardsList = new ArrayList<Card>();
        List<Icon> cardVals = new ArrayList<Icon>();

        //implementation of the input messages -LILI
        p.inputPlayerName();

        for (int i = 0; i < pairs; i++) {
            String fileName = "src/images/" + (i + 1) + ".jpg";
            Icon b = new ImageIcon(fileName);
            cardVals.add(b);
            cardVals.add(b);
        }
        for (Icon val : cardVals) {
            Card c = new Card(icon); //that the card can have an image
            c.setPic(val);
            c.setFileName(c.getPic().hashCode());
            c.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    selectedCard = c;
                    doTurn();
                }
            });
            cardsList.add(c);

        }
        Collections.shuffle(cardsList); //class method using random to shuffle given list of cards
        this.cards = cardsList;

        t = new Timer(750, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                checkCards();
            }
        });

        t.setRepeats(false);

        //changed the content pane to a JPanel to add borders, only then u can see the colorswitch -LILI
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(4, 5));
        //creates the border with the pane in the center -LILI
        pane.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));
        //sets the Background for the first player -LILI
        pane.setBackground(Color.PINK);
        for (Card c : cards) {
            pane.add(c);
        }
        setContentPane(pane);
        setTitle("Memory Game");
    }

    //switches Background color for each player -LILI
    public void switchColor() {
        if (turn == 1) {
            getContentPane().setBackground(Color.ORANGE);
            turn--;
        } else {
            getContentPane().setBackground(Color.PINK);
            turn++;
        }
    }

    public void doTurn() {

        if (c1 == null && c2 == null) {  //set the image return if not match

            c1 = selectedCard;
            c1.setIcon(c1.getPic());
        }

        if (c1 != null && c1 != selectedCard && c2 == null) { //set the image return if not match
            c2 = selectedCard;
            c2.setIcon(c2.getPic());

            t.start();
        }
    }

    public void checkCards() {
        //implementation of the colorswitch and the playerswitch -LILI
        switchColor();
        p.currentPlayer();

        if (turn == 1) {
            if (c1.getFileName() == c2.getFileName()) {
                c1.setEnabled(false);
                c2.setEnabled(false);
                c1.setMatched(true);
                c2.setMatched(true);
                score1++;
                if (this.isGameWon()) {
                    if (score1 == score2) {
                        JOptionPane.showMessageDialog(this,
                                p.player2 + " , your score is: " + score2 + ". "
                                        + p.player1 + " , your score is: " + score1 + "."
                                        + " Nobody wins, it's a draw, congrats?");
                        System.exit(0);
                    }else if(score1 > score2){
                        JOptionPane.showMessageDialog(this,
                                p.player1 + " You win!, Your score is: " + score1
                                , "The Winner is...", 0);
                        System.exit(0);
                    } else{
                        JOptionPane.showMessageDialog(this,
                            p.player2 + " You win!, Your score is: " + score2
                                , "The Winner is...", 0);
                        System.exit(0);}
                }
                 }
        } else{
            c1.setIcon(icon);
            c1.setIconTextGap(-10);
            c2.setIcon(icon);
            c2.setIconTextGap(-10);
        }

        if (turn == 0){
            if (c1.getFileName() == c2.getFileName()) {
                c1.setEnabled(false);
                c2.setEnabled(false);
                c1.setMatched(true);
                c2.setMatched(true);
                score2++;
                if (this.isGameWon()) {
                    if (score2 == score1){
                        JOptionPane.showMessageDialog(this,
                                p.player2 + " , your score is: " + score2 + ". "
                                        + p.player1 + " , your score is: " + score1 + "."
                                        + " Nobody wins, it's a draw, congrats?");
                        System.exit(0);
                    }else if (score1 < score2){
                        JOptionPane.showMessageDialog(this,
                                p.player2 + " You win!, Your score is: " + score2
                                , "The Winner is...", 0);
                        System.exit(0);
                    } else{
                        JOptionPane.showMessageDialog(this,
                            p.player1 + " You win!, Your score is: " + score1
                                , "The Winner is...", 0);
                        System.exit(0);}
                }
            }
        } else{
            c1.setIcon(icon);
            c1.setIconTextGap(-10);
            c2.setIcon(icon);
            c2.setIconTextGap(-10);
        }

        c1 = null;
        c2 = null;
    }

    public boolean isGameWon() {
        for (Card c : this.cards) {
            if (c.getMatched() == false) {
                return false;
            }
        }
        return true;
    }
}
