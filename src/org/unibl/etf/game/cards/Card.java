package org.unibl.etf.game.cards;

import java.io.Serializable;

public abstract class Card implements Serializable {
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
