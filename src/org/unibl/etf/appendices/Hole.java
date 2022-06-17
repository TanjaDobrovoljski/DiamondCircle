package org.unibl.etf.appendices;

import javafx.scene.shape.Rectangle;

public class Hole {
    private Integer positionX;
    private Integer positionY;
    private Rectangle hole;

    public Rectangle getHole() {
        return hole;
    }

    public void setHole(Rectangle hole) {
        this.hole = hole;
    }

    public Hole(Integer x, Integer y)
    {
        this.positionX=x;
        this.positionY=y;
        this.hole=new Rectangle();
        this.hole.setX(positionX);
        this.hole.setY(positionY);
        this.hole.setHeight(60);
        this.hole.setWidth(60);
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
