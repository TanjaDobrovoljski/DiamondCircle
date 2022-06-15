package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import org.unibl.etf.shape.*;
import org.unibl.etf.tools.*;


public class gameController implements Initializable {



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
    private ImageView cardImage;

    @FXML
    private Label opisKarte;

    @FXML
    private Button prikazRezultataButton;

    @FXML
    private GridPane matrixGame;
    @FXML
    TextField sizeField;
    Scene matrixScene;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }




   @FXML
   void startClicked(ActionEvent event) throws InterruptedException {//exception za ponovno pokretanje ako vec igra traje

        int min = 7;
       int max =10;
       int random=0;
       random=(int)Math.floor(Math.random()*(max-min+1)+min);
       int k=1;

       for (int y = 0; y < 8; y++) {
           for (int x = 0; x < 8; x++) {

               // Create a new TextField in each Iteration
               TextField tf = new TextField();
               tf.setPrefHeight(60);
               tf.setPrefWidth(60);
               tf.setAlignment(Pos.CENTER);
               tf.setEditable(true);
               tf.setText(String.valueOf(k));
               matrixGame.setRowIndex(tf, y);
               matrixGame.setColumnIndex(tf, x);
               matrixGame.getChildren().add(tf);
               k++;
           }
       }


       List<Circle> circles = new ArrayList(); //prikaz figura kao krugova
       for (int i = 0; i < 7 * 7; i++) {
           circles.add(new Circle(10, Color.BLACK));
       }

       matrixGame.setAlignment(Pos.CENTER);

       DiamondShape d=new DiamondShape(matrixGame);

      // List<Tuple<Integer, Integer>> lista=d.getMovementsEven();
       //d.addCirclesToGridPane(matrixGame,circles,lista.get(0).getItem1(),lista.get(0).getItem2());

       /*List<Circle> circles = new ArrayList(); //prikaz figura kao krugova
       for (int i = 0; i < 7 * 7; i++) {
           circles.add(new Circle(10, Color.BLACK));
       }

       d.addCirclesToGridPane(matrixGame, circles,4,0);
       matrixGame.setPadding(new Insets(20, 20, 20, 20));*/



      /* List<Rectangle> recs = new ArrayList(); //prikaz rupa
       for (int i = 0; i < 2 * 2; i++) {
           recs.add(new Rectangle(60,60));
       }
       d.addRectangleToGridPane(matrixGame, recs);
       matrixGame.setPadding(new Insets(20, 20, 20, 20));*/


       }

   }



