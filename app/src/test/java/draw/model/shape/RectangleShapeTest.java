package draw.model.shape;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

import draw.model.Point;
import draw.model.Canvas;
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
        Canvas actual = new Canvas(width, height);
        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                expected[i][j] = new Point();
            }
        }

        for (int i=14-1; i<18; i++) {
          expected[0][i].setColor('x');
          expected[2][i].setColor('x');
        }
        expected[1][13].setColor('x');
        expected[1][17].setColor('x');

        RectangleShape rect = new RectangleShape(14,1,18,3);
        rect.draw(actual);

        assertTrue(Arrays.deepEquals(actual.getCanvas(), expected));
    }

    /** Scenario:
        enter command: R 18 3 14 1
        ----------------------
        |             xxxxx  |
        |             x   x  |
        |             xxxxx  |
        |                    |
        ----------------------
     */
    @Test 
    public void Draw_rectangle_with_point2_smaller_than_point1() throws Exception  {
        
        int height = 4;
        int width = 20;
        Canvas actual = new Canvas(width, height);
        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                expected[i][j] = new Point();
            }
        }

        for (int i=14-1; i<18; i++) {
          expected[0][i].setColor('x');
          expected[2][i].setColor('x');
        }
        expected[1][13].setColor('x');
        expected[1][17].setColor('x');

        RectangleShape rect = new RectangleShape(18,3,14,1);
        rect.draw(actual);

        assertTrue(Arrays.deepEquals(actual.getCanvas(), expected));
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

        RectangleShape rect = new RectangleShape(13,0,13,2);

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

        RectangleShape rect = new RectangleShape(13,0,17,0);

    }

    @Test(expected = OutOfBoundsException.class)
    public void Drawing_x1_outside_the_boundary_is_invalid() throws Exception  {
        
        int height = 4;
        int width = 20;
        int x1 = 100;
        int y1 = 2;
        int x2 = 3;
        int y2 = 4;
        Canvas actual = new Canvas(height, width);

        RectangleShape rect = new RectangleShape(x1,y1,x2,y2);
        rect.draw(actual);

    }

    @Test(expected = OutOfBoundsException.class)
    public void Drawing_y1_outside_the_boundary_is_invalid() throws Exception  {
        
        int height = 4;
        int width = 20;
        int x1 = 1;
        int y1 = 200;
        int x2 = 3;
        int y2 = 4;
        Canvas actual = new Canvas(height, width);

        RectangleShape rect = new RectangleShape(x1,y1,x2,y2);
        rect.draw(actual);

    }

    @Test(expected = OutOfBoundsException.class)
    public void Drawing_x2_outside_the_boundary_is_invalid() throws Exception  {
        
        int height = 4;
        int width = 20;
        int x1 = 1;
        int y1 = 2;
        int x2 = 300;
        int y2 = 4;
        Canvas actual = new Canvas(height, width);

        RectangleShape line = new RectangleShape(x1,y1,x2,y2);
        line.draw(actual);

    }

    @Test(expected = OutOfBoundsException.class)
    public void Drawing_y2_outside_the_boundary_is_invalid() throws Exception  {
        
        int height = 4;
        int width = 20;
        int x1 = 1;
        int y1 = 2;
        int x2 = 3;
        int y2 = 400;
        Canvas actual = new Canvas(height, width);

        RectangleShape line = new RectangleShape(x1,y1,x2,y2);
        line.draw(actual);

    }
}
