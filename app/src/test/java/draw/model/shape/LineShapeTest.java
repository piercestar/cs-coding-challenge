package draw.model.shape;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

import draw.model.Point;
import draw.model.Canvas;
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
        Canvas actual = new Canvas(width, height);
        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                expected[i][j] = new Point();
            }
        }

        expected[0][0].setColor('x');

        LineShape line = new LineShape(1,1,1,1);
        line.draw(actual);

        assertTrue(Arrays.deepEquals(actual.getCanvas(), expected));
        
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
        int x1 = 6;
        int y1 = 2;
        int x2 = 1;
        int y2 = 2;
        Canvas actual = new Canvas(width, height);
        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                expected[i][j] = new Point();
            }
        }

        for (int i=0; i<6; i++) {
          expected[1][i].setColor('x');
        }

        LineShape line = new LineShape(x1,y1,x2,y2);
        line.draw(actual);

        assertTrue(Arrays.deepEquals(actual.getCanvas(), expected));
    }

    /** Scenario:
        enter command: L 6 2 1 2
        ----------------------
        |                    |
        |xxxxxx              |
        |                    |
        |                    |
        ----------------------
     */
    @Test 
    public void Draw_horizontal_line_with_point2_smaller_than_point1() throws Exception  {
        
        int height = 4;
        int width = 20;
        int x1 = 6;
        int y1 = 2;
        int x2 = 1;
        int y2 = 2;
        Canvas actual = new Canvas(width, height);
        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                expected[i][j] = new Point();
            }
        }

        for (int i=0; i<6; i++) {
          expected[1][i].setColor('x');
        }

        LineShape line = new LineShape(x2,y2,x1,y1);
        line.draw(actual);

        assertTrue(Arrays.deepEquals(actual.getCanvas(), expected));
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
        int x1 = 6;
        int y1 = 3;
        int x2 = 6;
        int y2 = 4;
        Canvas actual = new Canvas(width, height);
        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                expected[i][j] = new Point();
            }
        }

        for (int i=2; i<=3; i++) {
          expected[i][5].setColor('x');
        }

        LineShape line = new LineShape(x1,y1,x2,y2);
        line.draw(actual);

        assertTrue(Arrays.deepEquals(actual.getCanvas(), expected));      
    }

    /** Scenario:
        enter command: L 6 4 6 3
        ----------------------
        |                    |
        |                    |
        |     x              |
        |     x              |
        ----------------------
     */
    @Test 
    public void Draw_vertical_line_with_point2_smaller_than_point1() throws Exception  {

        int height = 4;
        int width = 20;
        int x1 = 6;
        int y1 = 3;
        int x2 = 6;
        int y2 = 4;
        Canvas actual = new Canvas(width, height);
        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                expected[i][j] = new Point();
            }
        }

        for (int i=2; i<=3; i++) {
          expected[i][5].setColor('x');
        }

        LineShape line = new LineShape(x2,y2,x1,y1);
        line.draw(actual);

        assertTrue(Arrays.deepEquals(actual.getCanvas(), expected));      
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
        
        int x1 = 1;
        int y1 = 1;
        int x2 = 3;
        int y2 = 3;

        LineShape line = new LineShape(x1,y1,x2,y2);

    }

    @Test(expected = OutOfBoundsException.class)
    public void Drawing_x1_outside_the_boundary_is_invalid() throws Exception  {
        
        int height = 4;
        int width = 20;
        int x1 = 100;
        int y1 = 1;
        int x2 = 1;
        int y2 = 1;
        Canvas actual = new Canvas(height, width);

        LineShape line = new LineShape(x1,y1,x2,y2);
        line.draw(actual);

    }

    @Test(expected = OutOfBoundsException.class)
    public void Drawing_y1_outside_the_boundary_is_invalid() throws Exception  {
        
        int height = 4;
        int width = 20;
        int x1 = 1;
        int y1 = 100;
        int x2 = 1;
        int y2 = 1;
        Canvas actual = new Canvas(height, width);

        LineShape line = new LineShape(x1,y1,x2,y2);
        line.draw(actual);

    }

    @Test(expected = OutOfBoundsException.class)
    public void Drawing_x2_outside_the_boundary_is_invalid() throws Exception  {
        
        int height = 4;
        int width = 20;
        int x1 = 1;
        int y1 = 1;
        int x2 = 100;
        int y2 = 1;
        Canvas actual = new Canvas(height, width);

        LineShape line = new LineShape(x1,y1,x2,y2);
        line.draw(actual);

    }

    @Test(expected = OutOfBoundsException.class)
    public void Drawing_y2_outside_the_boundary_is_invalid() throws Exception  {
        
        int height = 4;
        int width = 20;
        int x1 = 1;
        int y1 = 1;
        int x2 = 1;
        int y2 = 100;
        Canvas actual = new Canvas(height, width);

        LineShape line = new LineShape(x1,y1,x2,y2);
        line.draw(actual);

    }
}
