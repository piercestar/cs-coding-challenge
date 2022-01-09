/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package draw.model;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

import draw.model.LineShape;

public class LineShapeTest {

    /** Scenario:
        enter command: L 1 1 1 1
        ----------------------
        |x                   |
        |                    |
        |                    |
        |                    |
        ----------------------
     */
    @Test 
    public void Paint_single_point() {

        int height = 4;
        int width = 20;
        Point[][] blank = new Point[height][width];
        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                blank[i][j] = new Point();
                expected[i][j] = new Point();
            }
        }

        expected[0][0].setColor('x');

        LineShape line = new LineShape(1,1,1,1);
        Point[][] actual = line.paint(blank);

        assertTrue(Arrays.deepEquals(actual, expected));
        
    }

    /** Scenario:
        enter command: L 1 2 6 2
        ----------------------
        |                    |
        |xxxxxx              |
        |                    |
        |                    |
        ----------------------
     */
    @Test 
    public void Paint_horizontal_line() {
        
        int height = 4;
        int width = 20;
        Point[][] blank = new Point[height][width];
        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                blank[i][j] = new Point();
                expected[i][j] = new Point();
            }
        }

        for (int i=0; i<6; i++) {
          expected[1][i].setColor('x');
        }

        LineShape line = new LineShape(1,2,6,2);
        Point[][] actual = line.paint(blank);

        assertTrue(Arrays.deepEquals(actual, expected));
    }

    /** Scenario:
        enter command: L 6 3 6 4
        ----------------------
        |                    |
        |                    |
        |     x              |
        |     x              |
        ----------------------
     */
    @Test 
    public void Paint_vertical_line() {

        int height = 4;
        int width = 20;
        Point[][] blank = new Point[height][width];
        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                blank[i][j] = new Point();
                expected[i][j] = new Point();
            }
        }

        for (int i=2; i<=3; i++) {
          expected[i][5].setColor('x');
        }

        LineShape line = new LineShape(6,3,6,4);
        Point[][] actual = line.paint(blank);

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                char color = actual[i][j].getColor();

                System.out.print(color);
            }
            System.out.print('\n');
        }

        assertTrue(Arrays.deepEquals(actual, expected));      
    }

    @Test 
    public void Diagonal_lines_are_invalid() {
        fail();
    }
}