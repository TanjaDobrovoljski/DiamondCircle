package sample;
import com.sun.javafx.menu.MenuBase;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.unibl.etf.appendices.*;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.net.URL;
import java.util.*;

import org.unibl.etf.game.figures.Figure;
import org.unibl.etf.shape.*;
import org.unibl.etf.tools.*;
import org.unibl.etf.game.cards.*;


public class gameController implements Initializable {


    public boolean execute = true;
    @FXML
    private ImageView cardImage;

    @FXML
    private Label title;

    @FXML
    private Button startPauseButton;

    @FXML
    private Label numOfGames;

    @FXML
    private Label player1;

    @FXML
    private Label player2;

    @FXML
    private Label player3;

    @FXML
    private Label player4;

    @FXML
    private Label vrijemeLabel;

    @FXML
    private Label opisKarte;

    @FXML
    private Button prikazRezultataButton;

    @FXML
    public   GridPane matrixGame ;

    public static GridPane playField;

    @FXML
    TextField sizeField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        OrdinaryCard o = new OrdinaryCard(4);

        Image imProfile = new Image(getClass().getResourceAsStream(o.getSlika())); //ucitavanje slike
        cardImage.setImage(imProfile);
        Deck gameDeck = new Deck();

    }

    public static GridPane getMatrix()
    {
        return  playField;
    }

    public static void setMatrix(GridPane matrix)
    {
        playField=matrix;
    }




   /* static {
       GridPane temp = new GridPane();
        int k=0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {

                // Create a new TextField in each Iteration
                TextField tf = new TextField();
                tf.setPrefHeight(60);
                tf.setPrefWidth(60);
                tf.setAlignment(Pos.CENTER);
                tf.setEditable(true);
                tf.setText(String.valueOf(k));



                GridPane.setRowIndex(tf, y);
                GridPane.setColumnIndex(tf, x);
                //System.out.println(matrixGame.getRowCount());
                temp.add(tf,x,y);
                k++;
            }
        }
        temp.setAlignment(Pos.CENTER);
        System.out.println(temp.getColumnCount());
        setMatrix(temp);
    }*/

    /*public void movement(Figure f, DiamondShape d) {


        int i = 0;
        List<Circle> circles = new ArrayList(); //prikaz figura kao krugova
        for (int j = 0; j < DiamondShape.matrixSize * DiamondShape.matrixSize; j++) {
            circles.add(new Circle(10, f.getColor()));
        }


        try {

            while (execute) {
                try {

                    d.addCirclesToGridPane(d.getMatrix(), circles, Figure.getFutureMovements().get(i).getItem1(), Figure.getFutureMovements().get(i).getItem2());
                    Thread.sleep(1000);
                    i++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }*/


    @FXML
    void startClicked(ActionEvent event)  {//exception za ponovno pokretanje ako vec igra traje


        playField=matrixGame;
        DiamondShape d=new DiamondShape();
        /*
        List<Circle> circles = new ArrayList(); //prikaz figura kao krugova
        for (int i = 0; i < 7 * 7; i++) {
            circles.add(new Circle(10, Color.BLACK));
        }
        d.addCirclesToGridPane( circles,4,0);*/

       Figure f=new Figure();
        f.setDaemon(true);
        f.start();

       /*List<Circle> circles = new ArrayList(); //prikaz figura kao krugova
        for (int i = 0; i < 7 * 7; i++) {
            circles.add(new Circle(10, Color.BLACK));
        }*/


        // List<Tuple<Integer, Integer>> lista=d.getMovementsEven();
        //d.addCirclesToGridPane(matrixGame,circles,lista.get(0).getItem1(),lista.get(0).getItem2());






      /* List<Rectangle> recs = new ArrayList(); //prikaz rupa
       for (int i = 0; i < 2 * 2; i++) {
           recs.add(new Rectangle(60,60));
       }
       d.addRectangleToGridPane(matrixGame, recs);
       matrixGame.setPadding(new Insets(20, 20, 20, 20));*/
        matrixGame.setGridLinesVisible(true);

    }



    private void showMatrix() {
        int min = 7;
        int max = 10;
        int random = 0;
        random = (int) Math.floor(Math.random() * (max - min + 1) + min);
        // DiamondShape.matrixSize=7;
        int k = 1;

        for (int y = 0; y < random; y++) {
            for (int x = 0; x < random; x++) {

                // Create a new TextField in each Iteration
                TextField tf = new TextField();
                tf.setPrefHeight(70);
                tf.setPrefWidth(70);
                tf.setAlignment(Pos.CENTER);
                tf.setEditable(true);
                tf.setText(String.valueOf(k));
                matrixGame.setRowIndex(tf, y);
                matrixGame.setColumnIndex(tf, x);
                matrixGame.getChildren().add(tf);
                tf.setEditable(false);
                k++;
            }
        }
        matrixGame.setAlignment(Pos.CENTER);
        matrixGame.setGridLinesVisible(true);



    }
}
