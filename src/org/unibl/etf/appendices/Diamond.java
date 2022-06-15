package org.unibl.etf.appendices;

public final class Diamond {
    private Integer positionX;
    private Integer positionY;
    private static String diamondImage; //slicica

    public Diamond(Integer x,Integer y)
    {
        this.positionX=x;
        this.positionY=y;
        diamondImage="";
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
