package at.ac.fhcampuswien;

import javax.swing.*;
import java.awt.*;

public class Player extends Component {

    public String player1;
    public String player2;
    public int whoseTurn = 1;

    //creates two input messages to type in your nickname, also starts with the message of the person whose turn
    //is first -LILI
    public void inputPlayerName() {
        player1 = JOptionPane.showInputDialog(this,
                "What's your nickname, Player 1? ", "Choose your Nickname", 0);
        player2 = JOptionPane.showInputDialog(this,
                "What's your nickname, Player 2? ", "Choose your Nickname", 0);

       JOptionPane.showMessageDialog(this,
              player1 + "'s Turn", "Current Player", 0);
    }

    //also messages, starts with the person whose turn is the second and switches then between the two players -LILI
    public void currentPlayer() {


        if (whoseTurn == 1){
            JOptionPane.showMessageDialog(this,
                    player1 + "'s Turn", "Current Player", 0);

            whoseTurn--;
        }else{
            JOptionPane.showMessageDialog(this,
                    player2 + "'s Turn", "Current Player", 0);
            whoseTurn++;
        }
    }
    public void secondChance(){

        if (whoseTurn==1){
            JOptionPane.showMessageDialog(this,
                    player1 + "'s Turn again", "Current Player", 0);}
        else{  JOptionPane.showMessageDialog(this,
                player2 + "'s Turn again", "Current Player", 0);
        }
    }
}
