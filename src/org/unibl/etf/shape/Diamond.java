package org.unibl.etf.shape;

import javafx.scene.Node;

import java.io.File;
import java.nio.file.Paths;

public class Diamond  {
    private int xCoordinate;
    private int yCoordinate;
    private String logo;
   private  File resourcesDirectory;


    public Diamond(int x,int y)
    {
        this.xCoordinate=x;
        this.yCoordinate=y;
        this.resourcesDirectory = new File("src/sample");
        this.logo=String.valueOf(Paths.get(resourcesDirectory.getAbsolutePath()+"/diamond.png").toUri());
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }


}
