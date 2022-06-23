package org.unibl.etf.game.figures;

import javafx.scene.paint.Color;

import org.unibl.etf.shape.DiamondShape;
import org.unibl.etf.tools.GenLogger;
import org.unibl.etf.tools.Tuple;
import org.unibl.etf.shape.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class Figure  implements Serializable {
    private static Integer idCounter = 0,uniqueID;
    private static int Id=1;

    private boolean hasDiamond;
    private static List<Tuple<Integer, Integer>> futureMovements,passedMovements;
    private int numOdDiamons;
    private long startTime;
    private  static Color color = null;



    public Figure()
    {
        uniqueID=idCounter++;
        if(Id==1)
        { color=Color.RED;
                Id++;
        }
        else if(Id==2) {
            color = Color.GREEN;
            Id++;
        }
          else if(Id==3) {
            color = Color.BLUE;
            Id++;
        }
          else if(Id==4) {
            color = Color.YELLOW;
            Id = 1;
        }

          this.numOdDiamons=0;
          this.hasDiamond=false;

        new Thread(() -> {
           startTime=new Date().getTime();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    GenLogger.log(Figure.class, e);
                }

        }).start();
    }





    public static Color getColor() {
        return color;
    }

    public static void setColor(Color color) {
        Figure.color = color;
    }

    public boolean isHasDiamond() {
        return hasDiamond;
    }

    public void setHasDiamond(boolean hasDiamond) {
        this.hasDiamond = hasDiamond;
    }

    public static List<Tuple<Integer, Integer>> getFutureMovements() {
        return futureMovements;
    }

    public static void setFutureMovements(List<Tuple<Integer, Integer>> futureMovements) {
        Figure.futureMovements = futureMovements;
    }

    public static List<Tuple<Integer, Integer>> getPassedMovements() {
        return passedMovements;
    }

    public static void setPassedMovements(List<Tuple<Integer, Integer>> passedMovements) {
        Figure.passedMovements = passedMovements;
    }

    public int getNumOdDiamons() {
        return numOdDiamons;
    }

    public void setNumOdDiamons(int numOdDiamons) {
        this.numOdDiamons = numOdDiamons;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Figure) && obj != null)
            return false;
        if (((Figure) obj).uniqueID == this.uniqueID)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return ", Figura "+uniqueID;
    }
}
