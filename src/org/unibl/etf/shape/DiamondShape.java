package org.unibl.etf.shape;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.unibl.etf.tools.Tuple;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class DiamondShape implements Serializable {

    private GridPane matrix;
    private static List<Tuple<Integer, Integer>> movementsOdd;
    private static List<Tuple<Integer, Integer>> movementsEven;

    public DiamondShape(GridPane matrix) {
        this.matrix = matrix;

        diamondSpiral(matrix);
    }

    public GridPane getMatrix() {
        return matrix;
    }

    public void setMatrix(GridPane matrix) {
        this.matrix = matrix;
    }

    public List<Tuple<Integer, Integer>> getMovementsOdd() {
        return movementsOdd;
    }

    public void setMovementsOdd(List<Tuple<Integer, Integer>> movementsOdd) {
        this.movementsOdd = movementsOdd;
    }

    public List<Tuple<Integer, Integer>> getMovementsEven() {
        return movementsEven;
    }

    public void setMovementsEven(List<Tuple<Integer, Integer>> movementsEven) {
        this.movementsEven = movementsEven;
    }

    public void spiralDiamondViewOdd(GridPane matrix,
                                     int x, int y, int m, int n, int k, List<Tuple<Integer,Integer>> movements) { //7x7
        List<Circle> circles = new ArrayList(); //prikaz figura kao krugova
        for (int i = 0; i < 100; i++) {
            circles.add(new Circle(10, Color.BLACK));
        }
        Tuple<Integer,Integer> movement;
        //Get middle column
        int midCol = y + ((n - y) / 2);
        int midRow = midCol;

        for (int i = midCol, j = 0;
             i < n && k > 0; ++i, k--, j++) {
            movement = new Tuple<>();
            movement.setItems(x + j, i);
            movements.add( movement);
            //addCirclesToGridPane(matrix, circles, x + j, i);// matrix[x + j][i]
        }

        for (int i = n, j = 0;
             i >= midCol && k > 0; --i, k--, j++) {
            movement = new Tuple<>();
            movement.setItems((midRow) + j, i);
            movements.add( movement);
            // addCirclesToGridPane(matrix, circles, (midRow) + j, i);// matrix[(midRow) + j][i]);
        }


        for (int i = midCol - 1, j = 1;
             i >= y && k > 0; --i, k--, j++) {
            movement = new Tuple<>();
            movement.setItems( (n) - j, i);
            movements.add( movement);
            //addCirclesToGridPane(matrix, circles, (n) - j, i);//matrix[(n) - j][i]);
        }

        for (int i = y + 1, j = 1;
             i < midCol && k > 0; ++i, k--, j++) {
            movement = new Tuple<>();
            movement.setItems((midRow) - j, i);
            movements.add( movement);
            //addCirclesToGridPane(matrix, circles, (midRow) - j, i);//matrix[(midRow) - j][i]);
        }
        if (x + 1 <= m - 1 && k > 0) {
            // Recursive call
            spiralDiamondViewOdd(matrix, x + 1,
                    y + 1, m - 1, n - 1, k,movements);
        }
    }

    public void spiralDiamondViewEven(GridPane matrix,
                                  int x, int y, int m, int n, int k,List<Tuple<Integer,Integer>> movements) //8x8
    {
        List<Circle> circles = new ArrayList(); //prikaz figura kao krugova
        for (int i = 0; i < 100; i++) {
            circles.add(new Circle(10, Color.BLACK));
        }

        Tuple<Integer,Integer> movement;
                // Get middle column
                int midCol = y + ((n - y) / 2);
                int midRow = midCol;

                for (int i = midCol, j = 0;
                     i <= n && k > 0; ++i, k--, j++) {
                    movement = new Tuple<>();
                    movement.setItem1(x+j);
                    movement.setItem2(i);
                    movements.add(movement); //addCirclesToGridPane(matrix, circles, x + j, i);// matrix[x + j][i]
                }

                for (int i = n, j = 0;
                     i-1 > midCol && k > 0; --i, k--, j++) {
                    movement = new Tuple<>();
                    movement.setItems((midRow) + j+2, i-1);
                    movements.add( movement);
                    //addCirclesToGridPane(matrix, circles, (midRow) + j+2, i-1);// matrix[(midRow) + j][i]);
                }

                for (int i = midCol - 1, j = 1;
                     i+1 >= y && k > 0; --i, k--, j++) {
                    movement = new Tuple<>();
                    movement.setItems((n) - j, i+1);
                    movements.add(movement);
                    //addCirclesToGridPane(matrix, circles, (n) - j, i+1);//matrix[(n) - j][i]);
                }

                for (int i = y + 1, j = 1;
                     i < midCol && k > 0; ++i, k--, j++) {
                    movement = new Tuple<>();
                    movement.setItems((midRow) - j, i);
                    movements.add(movement);
                    //addCirclesToGridPane(matrix, circles, (midRow) - j, i);//matrix[(midRow) - j][i]);
                }
                if (x + 1 <= m - 1 && k > 0) {
                    // Recursive call
                    spiralDiamondViewEven(matrix, x +1,
                            y +1, m - 1, n - 1, k,movements);
                }


            }


        public void diamondSpiral(GridPane matrix)
        {
            // Get the size
            int row = matrix.getRowCount();
            int col = matrix.getColumnCount(); //matrix[0].length;
            if (row != col )
            {
                System.out.println("\nNot  odd square matrix");
                return;
            }
            if(row%2==0)
            {
                movementsEven=new LinkedList<>();
                spiralDiamondViewEven(matrix, 0, 0, row - 1,
                    col - 1, (row * col) - ((col + 1) / 2) * 4,movementsEven);}
            else {
                movementsOdd=new LinkedList<>();
                spiralDiamondViewOdd(matrix, 0, 0, row - 1,
                        col - 1, (row * col) - ((col + 1) / 2) * 4,movementsOdd);
            }


        }

    private static int c=0;
    public void addCirclesToGridPane(GridPane gridPane, List<Circle> circles,int a,int b) //dodavanje figura kao krugova
    {

            gridPane.add(circles.get(c), b,a);
            c++;

    }

    private static int r=0;
    public void addRectangleToGridPane(GridPane gridPane, Rectangle rects,int a, int b) //dodavanje rupa kao krugova
    {
        gridPane.add(rects,a,b);
        r++;

    }

}
