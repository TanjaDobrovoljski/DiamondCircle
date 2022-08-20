package org.unibl.etf.game.figures;

import javafx.application.Platform;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import javafx.scene.shape.Circle;
import org.unibl.etf.shape.DiamondShape;
import org.unibl.etf.tools.GenLogger;
import org.unibl.etf.tools.Tuple;
import org.unibl.etf.shape.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import static sample.gameController.playField;
import sample.gameController;


public class Figure extends Thread  implements Serializable {
    private static Integer idCounter = 1,uniqueID;
    private static int Id=1;

    private boolean hasDiamond;
    public static List<Tuple<Integer, Integer>> futureMovements,passedMovements=null;
    private int numOfDiamonds;
    private long startTime;
    private static  Color color ;
    private DiamondShape dS;

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

          this.numOfDiamonds=0;
          this.hasDiamond=false;

    }

    public Figure(DiamondShape ds)
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

        this.numOfDiamonds=0;
        this.hasDiamond=false;
        this.dS=ds;
        futureMovements=(DiamondShape.matrixSize) % 2 == 0 ? ds.getMovementsEven() : dS.getMovementsOdd();

    }

    public int returnX()
    {
        return  getFutureMovements().get(0).getItem2();
    }


   @Override
    public  void  run()
    {

       // Runnable task = () -> {
          //  Platform.startup(() -> {
        Platform.runLater(()-> {
            long time = new Date().getTime();
            List<Circle> circles = new ArrayList();
            Figure.setFutureMovements((DiamondShape.matrixSize) % 2 == 0 ? dS.getMovementsEven() : dS.getMovementsOdd());
            while (true) {
                try {
                    //prikaz figura kao krugova

                    for (Tuple<Integer, Integer> lista : getFutureMovements()) {

                        System.out.println("radi");
                        //DiamondShape.addCirclesToGridPane(circles,lista.getItem1(),lista.getItem2());
                        ///playField.add(circles.get(0),lista.getItem1(),lista.getItem2());

                        //DiamondShape.drawMatrix(lista.getItem1(), lista.getItem2());
                        System.out.println("poslije");
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("I'm running later...");
            }
        });
    };

   /* public void test()
    {
        setFutureMovements((DiamondShape.matrixSize) % 2 == 0 ? DiamondShape.getMovementsEven() : DiamondShape.getMovementsOdd());
        while (true) {

                //prikaz figura kao krugova

                for (Tuple<Integer, Integer> lista : getFutureMovements()) {

                    System.out.println("radi");
                    //DiamondShape.addCirclesToGridPane(circles,lista.getItem1(),lista.getItem2());
                    ///playField.add(circles.get(0),lista.getItem1(),lista.getItem2());

                    DiamondShape.drawMatrix(lista.getItem1(), lista.getItem2());
                    System.out.println("poslije");
                }}
    }*/



    public static  Color getColor() {
        return color;
    }

    public  void setColor(Color color) {
        this.color = color;
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

    public int getNumOfDiamons() {
        return numOfDiamonds;
    }

    public void setNumOfDiamons(int numOdDiamons) {
        this.numOfDiamonds = numOdDiamons;
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
