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
    Icon icon = new ImageIcon("src/images/icon.png");
    private Timer t;

    public Board() {
        int pairs = 10;
        List<Card> cardsList = new ArrayList<Card>();
        List<Icon> cardVals = new ArrayList<Icon>();
        for (int i = 0; i < pairs; i++) {
            String fileName = "src/images/" + (i + 1) + ".png";
            Icon b = new ImageIcon(fileName);
            cardVals.add(b);
            cardVals.add(b);
        }
        for (Icon val : cardVals) {
            Card c = new Card(icon);
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
        Collections.shuffle(cardsList);
        this.cards = cardsList;

        t = new Timer(750, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                checkCards();
            }
        });

        t.setRepeats(false);

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 5));
        for (Card c : cards) {
            pane.add(c);
        }
        setTitle("Memory Match");
    }

    public void doTurn() {
        if (c1 == null && c2 == null) {
            c1 = selectedCard;
            c1.setIcon(c1.getPic());

        }

        if (c1 != null && c1 != selectedCard && c2 == null) {
            c2 = selectedCard;
            c2.setIcon(c2.getPic());

            t.start();
        }
    }

    public void checkCards() {
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
