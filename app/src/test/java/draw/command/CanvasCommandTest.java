package draw.command;

import java.util.Arrays;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import draw.model.Canvas;
import draw.command.LineCommand;

public class CanvasCommandTest {

    private final ByteArrayOutputStream actual = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(actual));
    }

    @Test
    public void Initialize_canvas_width_and_height() throws Exception {

        int height = 4;
        int width = 20;
                        
        Canvas canvas = new Canvas();
        CanvasCommand command = new CanvasCommand(canvas, width, height);
        command.execute();

        assertEquals(canvas.getCanvas()[0].length, width);
        assertEquals(canvas.getCanvas().length, height);
        
    }

    @Test
    public void Displays_error_when_initializing_canvas_with_negative_width() throws Exception {

        int height = 4;
        int width = -20;

        String expected = "Canvas height and width should be greater than 0." + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas();
        CanvasCommand command = new CanvasCommand(canvas, width, height);
        command.execute();

        assertEquals(expected, actual.toString());

    }

    @Test
    public void Displays_error_when_initializing_canvas_with_negative_height() throws Exception {

        int height = -4;
        int width = 20;
                        
        String expected = "Canvas height and width should be greater than 0." + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas();
        CanvasCommand command = new CanvasCommand(canvas, width, height);
        command.execute();

        assertEquals(expected, actual.toString());

    }

    @Test
    public void Displays_error_when_initializing_canvas_with_zero_width_and_height() throws Exception {

        int height = 0;
        int width = 0;
                        
        String expected = "Canvas height and width should be greater than 0." + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas();
        CanvasCommand command = new CanvasCommand(canvas, width, height);
        command.execute();

        assertEquals(expected, actual.toString());
        
    }
}