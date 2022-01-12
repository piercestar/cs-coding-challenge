package draw.command;

import java.util.Arrays;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import draw.model.Canvas;
import draw.command.LineCommand;

public class LineCommandTest {

    private final ByteArrayOutputStream actual = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(actual));
    }

    @Test
    public void Draws_line_on_canvas() throws Exception {

        int x1 = 1;
        int y1 = 2;
        int x2 = 1;
        int y2 = 3;
        int height = 4;
        int width = 20;

        String expected =   "                    " + System.getProperty("line.separator") +
                            "x                   " + System.getProperty("line.separator") +
                            "x                   " + System.getProperty("line.separator") +
                            "                    " + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        LineCommand command = new LineCommand(canvas, x1, y1, x2, y2);
        command.execute();

        assertEquals(actual.toString(), expected);
        
    }

    @Test
    public void Displays_error_when_drawing_diagonal_lines() throws Exception {

        int x1 = 1;
        int y1 = 2;
        int x2 = 3;
        int y2 = 4;
        int height = 4;
        int width = 20;

        String expected = "Only horizontal or vertical lines are allowed." + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        LineCommand command = new LineCommand(canvas, x1, y1, x2, y2);
        command.execute();

        assertEquals(expected, actual.toString());
        
    }

    @Test
    public void Displays_error_when_drawing_outside_the_canvas() throws Exception {

        int x1 = 100;
        int y1 = 200;
        int x2 = 100;
        int y2 = 400;
        int height = 4;
        int width = 20;

        String expected = "Line exceeds the canvas boundary." + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        LineCommand command = new LineCommand(canvas, x1, y1, x2, y2);
        command.execute();

        assertEquals(expected, actual.toString());
        
    }

}