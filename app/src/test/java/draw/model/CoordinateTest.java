package draw.model;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

import draw.model.Coordinate;

public class CoordinateTest {

    @Test
    public void Two_points_with_the_same_X_coordinates_form_a_vertical_line() throws Exception {

        int x1 = 1;
        int y1 = 4;
        int x2 = 1;
        int y2 = 5;
        
        Coordinate point1 = new Coordinate(x1, y1);
        Coordinate point2 = new Coordinate(x2, y2);

        assertTrue(point1.isVerticalLine(point2));
        
    }

    @Test
    public void Two_points_with_different_X_coordinates_do_not_form_a_vertical_line() throws Exception {

        int x1 = 1;
        int y1 = 2;
        int x2 = 3;
        int y2 = 4;
        
        Coordinate point1 = new Coordinate(x1, y1);
        Coordinate point2 = new Coordinate(x2, y2);

        assertFalse(point1.isVerticalLine(point2));
        
    }

    @Test
    public void Two_points_with_the_same_Y_coordinates_form_a_horizontal_line() throws Exception {

        int x1 = 2;
        int y1 = 1;
        int x2 = 3;
        int y2 = 1;
        
        Coordinate point1 = new Coordinate(x1, y1);
        Coordinate point2 = new Coordinate(x2, y2);

        assertTrue(point1.isHorizontalLine(point2));
        
    }

    @Test
    public void Two_points_with_different_Y_coordinates_do_not_form_a_horizontal_line() throws Exception {

        int x1 = 1;
        int y1 = 2;
        int x2 = 3;
        int y2 = 4;
        
        Coordinate point1 = new Coordinate(x1, y1);
        Coordinate point2 = new Coordinate(x2, y2);

        assertFalse(point1.isHorizontalLine(point2));
        
    }

    @Test
    public void Swap_coordinates() throws Exception {

        int x1 = 1;
        int y1 = 2;
        int x2 = 3;
        int y2 = 4;
        
        Coordinate point1 = new Coordinate(x1, y1);
        Coordinate point2 = new Coordinate(x2, y2);

        point1.swap(point2);

        assertEquals(point1.getX(), x2);
        assertEquals(point1.getY(), y2);
        assertEquals(point2.getX(), x1);
        assertEquals(point2.getY(), y1);
        
    }

}