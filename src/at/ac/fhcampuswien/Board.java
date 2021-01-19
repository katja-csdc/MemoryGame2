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
    public int turn = 1;
    Player p = new Player();

    public Board() {
        int pairs = 10;
        List<Card> cardsList = new ArrayList<Card>();
        List<Icon> cardVals = new ArrayList<Icon>();

        //implementation of the input messages -LILI
        p.inputPlayerName();

        for (int i = 0; i < pairs; i++) {
            String fileName = "src/images/" + (i + 1) + ".png";
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
        pane.setBorder(BorderFactory.createEmptyBorder(11,11,11,11));
        //sets the Background for the first player -LILI
        pane.setBackground(Color.PINK);
        for (Card c : cards) {
            pane.add(c);
        }
        setContentPane(pane);
        setTitle("Memory Game");
    }
    //summary: switches Background color for each player -LILI
    public void switchColor(){
        if (turn == 1){
            getContentPane().setBackground(Color.ORANGE);
            turn--;
        }else{
            getContentPane().setBackground(Color.PINK);
            turn++;
        }
    }

    public void doTurn(){

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

        if (c1.getFileName() == c2.getFileName()) {
            c1.setEnabled(false);
            c2.setEnabled(false);
            c1.setMatched(true);
            c2.setMatched(true);
            if (this.isGameWon()) {
                JOptionPane.showMessageDialog(this, "You win!");
                System.exit(0);
            }
        } else {
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
