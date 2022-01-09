package draw.model.shape;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

import draw.model.Point;
import draw.model.shape.LineShape;
import draw.exception.InvalidShapeException;
import draw.exception.OutOfBoundsException;

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
    public void Draw_single_point() throws Exception {

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
        Point[][] actual = line.draw(blank);

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
    public void Draw_horizontal_line_with_point1_smaller_than_point2() throws Exception  {
        
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
        Point[][] actual = line.draw(blank);

        assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test 
    public void Draw_horizontal_line_with_point2_smaller_than_point1() throws Exception  {
        
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

        LineShape line = new LineShape(6,2,1,2);
        Point[][] actual = line.draw(blank);

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
    public void Draw_vertical_line_with_point1_smaller_than_point2() throws Exception  {

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
        Point[][] actual = line.draw(blank);

        assertTrue(Arrays.deepEquals(actual, expected));      
    }

    @Test 
    public void Draw_vertical_line_with_point2_smaller_than_point1() throws Exception  {

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

        LineShape line = new LineShape(6,4,6,3);
        Point[][] actual = line.draw(blank);

        assertTrue(Arrays.deepEquals(actual, expected));      
    }


    /** Scenario:
        enter command: L 1 1 3 3
        ----------------------
        |x                   |
        | x                  |
        |  x                 |
        |                    |
        ----------------------
     */
    @Test(expected = InvalidShapeException.class)
    public void Drawing_diagonal_lines_is_invalid() throws Exception  {
        
        LineShape line = new LineShape(1,1,3,3);

    }

    @Test(expected = OutOfBoundsException.class)
    public void Drawing_outside_the_boundary_is_invalid() throws Exception  {
        
        int height = 4;
        int width = 20;
        Point[][] blank = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                blank[i][j] = new Point();
            }
        }

        LineShape line = new LineShape(20,4,21,4);
        line.draw(blank);

    }
}
