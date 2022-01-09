package draw.model.shape;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

import draw.model.Point;
import draw.model.shape.RectangleShape;
import draw.exception.InvalidShapeException;
import draw.exception.OutOfBoundsException;

public class RectangleShapeTest {

     /** Scenario:
        enter command: R 1 1 1 1
        ----------------------
        |x                   |
        |                    |
        |                    |
        |                    |
        ----------------------
     */
     @Test(expected = InvalidShapeException.class)
    public void Drawing_rectangles_with_a_single_point_is_invalid() throws Exception {

        RectangleShape rect = new RectangleShape(1,1,1,1);
        
    }

    /** Scenario:
        enter command: R 14 1 18 3
        ----------------------
        |             xxxxx  |
        |             x   x  |
        |             xxxxx  |
        |                    |
        ----------------------
     */
    @Test 
    public void Draw_rectangle_with_point1_smaller_than_point2() throws Exception  {
        
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

        for (int i=14-1; i<18; i++) {
          expected[0][i].setColor('x');
          expected[2][i].setColor('x');
        }
        expected[1][13].setColor('x');
        expected[1][17].setColor('x');

        RectangleShape line = new RectangleShape(14,1,18,3);
        Point[][] actual = line.draw(blank);

        assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test 
    public void Draw_rectangle_with_point2_smaller_than_point1() throws Exception  {
        
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

        for (int i=14-1; i<18; i++) {
          expected[0][i].setColor('x');
          expected[2][i].setColor('x');
        }
        expected[1][13].setColor('x');
        expected[1][17].setColor('x');

        RectangleShape line = new RectangleShape(18,3,14,1);
        Point[][] actual = line.draw(blank);

        assertTrue(Arrays.deepEquals(actual, expected));
    }

    /** Scenario:
        enter command: R 14 1 14 3
        ----------------------
        |             x      |
        |             x      |
        |             x      |
        |                    |
        ----------------------
     */
    @Test (expected = InvalidShapeException.class)
    public void Drawing_rectangles_with_no_width_is_invalid() throws Exception  {

        RectangleShape line = new RectangleShape(14,1,14,3);

    }

    /** Scenario:
        enter command: R 14 1 18 1
        ----------------------
        |             xxxxx  |
        |                    |
        |                    |
        |                    |
        ----------------------
     */
    @Test (expected = InvalidShapeException.class)
    public void Drawing_rectangles_with_no_height_is_invalid() throws Exception  {

        RectangleShape line = new RectangleShape(14,1,18,1);

    }
}
