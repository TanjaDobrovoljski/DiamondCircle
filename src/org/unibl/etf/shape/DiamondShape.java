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
import java.util.List;

public class DiamondShape implements Serializable
{

    public GridPane matrix;
    private List<Tuple<Integer,Integer>> movements;

    public DiamondShape(GridPane matrix)
    {
        this.matrix=matrix;


        diamondSpiral(matrix);
    }


        public void spiralDiamondView(GridPane matrix,
                                      int x, int y, int m, int n, int k)
        {
            List<Circle> circles = new ArrayList(); //prikaz figura kao krugova
            for (int i = 0; i < 100; i++) {
                circles.add(new Circle(10, Color.BLACK));
            }
            if(m%2==0)
            {// Get middle column
                int midCol = y + ((n - y) / 2);
                int midRow = midCol;
                // Case A
                // ----------
                //      P1
                //       \
                //        \
                //         \
                //          P2
                for (int i = midCol, j = 0;
                     i < n && k > 0; ++i, k--, j++) {
                    addCirclesToGridPane(matrix, circles, x + j, i);// matrix[x + j][i]
                }
                // Case B
                // -----------
                //      P1
                //
                //
                //
                //          P2
                //          /
                //         /
                //        /
                //       P3
                for (int i = n, j = 0;
                     i >= midCol && k > 0; --i, k--, j++) {
                    addCirclesToGridPane(matrix, circles, (midRow) + j, i);// matrix[(midRow) + j][i]);
                }
                // Case C
                // ---------------
                //      P1
                //
                //
                //
                // p4        P2
                //   \
                //    \
                //     \
                //      P3
                for (int i = midCol - 1, j = 1;
                     i >= y && k > 0; --i, k--, j++) {
                    addCirclesToGridPane(matrix, circles, (n) - j, i);//matrix[(n) - j][i]);
                }
                // Case D
                // -----------------
                //      P1
                //    /
                //   /
                //  /
                // P4        P2
                //
                //
                //
                //      P3
                for (int i = y + 1, j = 1;
                     i < midCol && k > 0; ++i, k--, j++) {
                    addCirclesToGridPane(matrix, circles, (midRow) - j, i);//matrix[(midRow) - j][i]);
                }
                if (x + 1 <= m - 1 && k > 0) {
                    // Recursive call
                    spiralDiamondView(matrix, x + 1,
                            y + 1, m - 1, n - 1, k);
                }
            }
            else{
                /*
                // Get middle column
                int midCol = y + ((n - y) / 2);
                int midRow = midCol;
                // Case A
                // ----------
                //      P1
                //       \
                //        \
                //         \
                //          P2
                for (int i = midCol, j = 0;
                     i <= n && k > 0; ++i, k--, j++) {
                    addCirclesToGridPane(matrix, circles, x + j, i);// matrix[x + j][i]
                }
                // Case B
                // -----------
                //      P1
                //
                //
                //
                //          P2
                //          /
                //         /
                //        /
                //       P3
                for (int i = n, j = 0;
                     i-1 > midCol && k > 0; --i, k--, j++) {
                    addCirclesToGridPane(matrix, circles, (midRow) + j+2, i-1);// matrix[(midRow) + j][i]);
                }
                // Case C
                // ---------------
                //      P1
                //
                //
                //
                // p4        P2
                //   \
                //    \
                //     \
                //      P3
                for (int i = midCol - 1, j = 1;
                     i+1 >= y && k > 0; --i, k--, j++) {
                    addCirclesToGridPane(matrix, circles, (n) - j, i+1);//matrix[(n) - j][i]);
                }
                // Case D
                // -----------------
                //      P1
                //    /
                //   /
                //  /
                // P4        P2
                //
                //
                //
                //      P3
                for (int i = y + 1, j = 1;
                     i < midCol && k > 0; ++i, k--, j++) {
                    addCirclesToGridPane(matrix, circles, (midRow) - j, i);//matrix[(midRow) - j][i]);
                }*/

                // Get middle column

                int midCol = y + ((n+1 - y) / 2);
                int midRow = midCol;
                // Case A
                // ----------
                //      P1
                //       \
                //        \
                //         \
                //          P2
                for (int i = midCol, j = 0;
                     i < n && k > 0; ++i, k--, j++) {
                    addCirclesToGridPane(matrix, circles, x + j, i);// matrix[x + j][i]
                }
                // Case B
                // -----------
                //      P1
                //
                //
                //
                //          P2
                //          /
                //         /
                //        /
                //       P3
                for (int i = n, j = 0;
                     i >= midCol && k > 0; --i, k--, j++) {
                    addCirclesToGridPane(matrix, circles, (midRow) + j, i);// matrix[(midRow) + j][i]);
                }
                // Case C
                // ---------------
                //      P1
                //
                //
                //
                // p4        P2
                //   \
                //    \
                //     \
                //      P3
                for (int i = midCol - 1, j = 1;
                     i >= y && k > 0; --i, k--, j++) {
                    addCirclesToGridPane(matrix, circles, (n) - j, i);//matrix[(n) - j][i]);
                }
                // Case D
                // -----------------
                //      P1
                //    /
                //   /
                //  /
                // P4        P2
                //
                //
                //
                //      P3
                for (int i = y + 1, j = 1;
                     i < midCol && k > 0; ++i, k--, j++) {
                    addCirclesToGridPane(matrix, circles, (midRow) - j, i);//matrix[(midRow) - j][i]);
                }

                if (x + 1 <= m - 1 && k > 0) {
                    // Recursive call
                    spiralDiamondView(matrix, x + 1,
                            y + 1, m - 1, n - 1, k);
                }

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
            // Print result
            spiralDiamondView(matrix, 0, 0, row - 1,
                    col - 1, (row * col) - ((col + 1) / 2) * 4);

        }

    private static int s=0;
    public void addCirclesToGridPane(GridPane gridPane, List<Circle> circles,int a,int b) //dodavanje figura kao krugova
    {

            gridPane.add(circles.get(s), b,a);
            s++;

    }

    public void addRectangleToGridPane(GridPane gridPane, List<Rectangle> rects) //dodavanje rupa kao krugova
    {
        for (int i = 0; i < 7 * 7; i++) {
            gridPane.add(rects.get(i), i % 7, i / 7);
        }
    }

    public Node getNodeByRowColumnIndex ( int row,  int column, GridPane gridPane) {

            Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;

                //result.setStyle("-fx-bar-fill: red;");
                break;
            }
        }


        return result;
    }


        public void gridToMatrix(GridPane g)
        {
            int[][] matrix=new int[g.getRowCount()][g.getColumnCount()];
            int x=0;
            int y=0;

            for (Node node : g.getChildren()) {
                {

                }
            }
            //return null;
        }


}
