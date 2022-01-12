package draw.command;

import java.util.Arrays;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import draw.model.Canvas;
import draw.command.LineCommand;

public class RectangleCommandTest {

    private final ByteArrayOutputStream actual = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(actual));
    }

    @Test
    public void Draw_rectangle_on_canvas() throws Exception {

        int x1 = 1;
        int y1 = 2;
        int x2 = 3;
        int y2 = 4;
        int height = 4;
        int width = 20;

        String expected =   "----------------------" + System.getProperty("line.separator") +
                            "|                    |" + System.getProperty("line.separator") +
                            "|xxx                 |" + System.getProperty("line.separator") +
                            "|x x                 |" + System.getProperty("line.separator") +
                            "|xxx                 |" + System.getProperty("line.separator") +
                            "----------------------" + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        RectangleCommand command = new RectangleCommand(canvas, x1, y1, x2, y2);
        command.execute();

        assertEquals(expected, actual.toString());
        
    }

    @Test
    public void Displays_error_when_drawing_rectangle_with_a_single_point() throws Exception {

        int x1 = 1;
        int y1 = 1;
        int x2 = 1;
        int y2 = 1;
        int height = 4;
        int width = 20;

        String expected = "Cannot draw rectangle with a single point." + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        RectangleCommand command = new RectangleCommand(canvas, x1, y1, x2, y2);
        command.execute();

        assertEquals(expected, actual.toString());
        
    }

    @Test
    public void Displays_error_when_drawing_rectangle_with_no_height() throws Exception {

        int x1 = 1;
        int y1 = 2;
        int x2 = 3;
        int y2 = 2;
        int height = 4;
        int width = 20;

        String expected = "Cannot draw rectangle with no height." + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        RectangleCommand command = new RectangleCommand(canvas, x1, y1, x2, y2);
        command.execute();

        assertEquals(expected, actual.toString());
        
    }

    @Test
    public void Displays_error_when_drawing_rectangle_with_no_width() throws Exception {

        int x1 = 1;
        int y1 = 2;
        int x2 = 1;
        int y2 = 4;
        int height = 4;
        int width = 20;

        String expected = "Cannot draw rectangle with no width." + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        RectangleCommand command = new RectangleCommand(canvas, x1, y1, x2, y2);
        command.execute();

        assertEquals(expected, actual.toString());
        
    }

    @Test
    public void Displays_error_when_x1_is_outside_the_canvas() throws Exception {

        int x1 = 100;
        int y1 = 2;
        int x2 = 3;
        int y2 = 4;
        int height = 4;
        int width = 20;

        String expected = "Point (100,2) is outside the canvas boundary." + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        RectangleCommand command = new RectangleCommand(canvas, x1, y1, x2, y2);
        command.execute();

        assertEquals(expected, actual.toString());
        
    }

    @Test
    public void Displays_error_when_y1_is_outside_the_canvas() throws Exception {

        int x1 = 1;
        int y1 = 200;
        int x2 = 3;
        int y2 = 4;
        int height = 4;
        int width = 20;

        String expected = "Point (1,200) is outside the canvas boundary." + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        RectangleCommand command = new RectangleCommand(canvas, x1, y1, x2, y2);
        command.execute();

        assertEquals(expected, actual.toString());
        
    }

    @Test
    public void Displays_error_when_x2_is_outside_the_canvas() throws Exception {

        int x1 = 1;
        int y1 = 2;
        int x2 = 300;
        int y2 = 4;
        int height = 4;
        int width = 20;

        String expected = "Point (300,4) is outside the canvas boundary." + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        RectangleCommand command = new RectangleCommand(canvas, x1, y1, x2, y2);
        command.execute();

        assertEquals(expected, actual.toString());
        
    }

    @Test
    public void Displays_error_when_y2_is_outside_the_canvas() throws Exception {

        int x1 = 1;
        int y1 = 2;
        int x2 = 3;
        int y2 = 400;
        int height = 4;
        int width = 20;

        String expected = "Point (3,400) is outside the canvas boundary." + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        RectangleCommand command = new RectangleCommand(canvas, x1, y1, x2, y2);
        command.execute();

        assertEquals(expected, actual.toString());
        
    }

}