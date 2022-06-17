package org.unibl.etf.game.cards;

public abstract class Card {
    protected String image;

    public Card ()
    {
        this.image="";

    }

    public String getSlika() {
        return image;
    }

    public void setSlika(String slika) {
        this.image = slika;
    }
}
