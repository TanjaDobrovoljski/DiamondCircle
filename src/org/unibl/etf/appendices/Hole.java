package org.unibl.etf.appendices;

public class Hole {
    private Integer positionX;
    private Integer positionY;

    public Hole(Integer x,Integer y)
    {
        this.positionX=x;
        this.positionY=y;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }
}
