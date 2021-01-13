package at.ac.fhcampuswien;


import javax.swing.*;

@SuppressWarnings("serial")
public class Card extends JButton {
    private int fileName;
    private Icon pic = null;
    private boolean matched = false;

    public Card(Icon icon) {
        super(icon);
    }

    public int getFileName() {
        return fileName;
    }

    public void setFileName(int fileName) {
        this.fileName = fileName;
    }

    public void setPic(Icon icon) {
        this.pic = icon;
    }

    public Icon getPic() {

        return this.pic;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public boolean getMatched() {
        return this.matched;
    }
}

