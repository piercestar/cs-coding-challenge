package draw.command;

import java.util.Arrays;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import draw.model.Canvas;
import draw.model.shape.RectangleShape;
import draw.command.FillCommand;

public class FillCommandTest {

    private final ByteArrayOutputStream actual = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(actual));
    }

    @Test
    public void Fill_Line() throws Exception {

        int height = 4;
        int width = 20;

        String expected =   "----------------------" + System.getProperty("line.separator") +
                            "|oooooooooooooooooooo|" + System.getProperty("line.separator") +
                            "|                    |" + System.getProperty("line.separator") +
                            "|                    |" + System.getProperty("line.separator") +
                            "|                    |" + System.getProperty("line.separator") +
                            "----------------------" + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        for (int i=1; i<=width; i++) {
            canvas.colorPoint(i,1,'c');
        }
        FillCommand command = new FillCommand(canvas, 1, 1, 'o');
        command.execute();

        assertEquals(actual.toString(), expected);
        
    }

    @Test
    public void Fill_left_half_of_canvas() throws Exception {

        int height = 4;
        int width = 20;
        int x = 1;
        int y = 1;
        int color = 'o';

        String expected =   "----------------------" + System.getProperty("line.separator") +
                            "|ooooooooox          |" + System.getProperty("line.separator") +
                            "|ooooooooox          |" + System.getProperty("line.separator") +
                            "|ooooooooox          |" + System.getProperty("line.separator") +
                            "|ooooooooox          |" + System.getProperty("line.separator") +
                            "----------------------" + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        for (int i=1; i<=height; i++) {
            canvas.colorPoint(width/2,i,'x');
        }
        FillCommand command = new FillCommand(canvas,x,y,'o');
        command.execute();

        assertEquals(actual.toString(), expected);
        
    }

    @Test
    public void Fill_inner_rectangle() throws Exception {

        int height = 5;
        int width = 20;
        int x = 9;
        int y = 3;
        int color = 'o';

        String expected =   "----------------------" + System.getProperty("line.separator") +
                            "|                    |" + System.getProperty("line.separator") +
                            "|     xxxxxxxxxx     |" + System.getProperty("line.separator") +
                            "|     xoooooooox     |" + System.getProperty("line.separator") +
                            "|     xxxxxxxxxx     |" + System.getProperty("line.separator") + 
                            "|                    |" + System.getProperty("line.separator") +
                            "----------------------" + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        RectangleShape rect = new RectangleShape(6,2,15,4);
        canvas.drawShape(rect);
        FillCommand command = new FillCommand(canvas,x,y,'o');
        command.execute();

        assertEquals(actual.toString(), expected);
        
    }

     @Test
    public void Fill_outer_rectangle() throws Exception {

        int height = 5;
        int width = 20;
        int x = 1;
        int y = 1;
        int color = 'o';

        String expected =   "----------------------" + System.getProperty("line.separator") +
                            "|oooooooooooooooooooo|" + System.getProperty("line.separator") +
                            "|oooooxxxxxxxxxxooooo|" + System.getProperty("line.separator") +
                            "|ooooox        xooooo|" + System.getProperty("line.separator") +
                            "|oooooxxxxxxxxxxooooo|" + System.getProperty("line.separator") + 
                            "|oooooooooooooooooooo|" + System.getProperty("line.separator") +
                            "----------------------" + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        RectangleShape rect = new RectangleShape(6,2,15,4);
        canvas.drawShape(rect);
        FillCommand command = new FillCommand(canvas,x,y,'o');
        command.execute();

        assertEquals(actual.toString(), expected);
        
    }

    @Test
    public void Fill_blank_canvas() throws Exception {

        int height = 4;
        int width = 20;
        int x = 1;
        int y = 1;
        int color = 'o';

        String expected =   "----------------------" + System.getProperty("line.separator") +
                            "|oooooooooooooooooooo|" + System.getProperty("line.separator") +
                            "|oooooooooooooooooooo|" + System.getProperty("line.separator") +
                            "|oooooooooooooooooooo|" + System.getProperty("line.separator") +
                            "|oooooooooooooooooooo|" + System.getProperty("line.separator") +
                            "----------------------" + System.getProperty("line.separator");
                        
        Canvas canvas = new Canvas(width, height);
        FillCommand command = new FillCommand(canvas,x,y,'o');
        command.execute();

        assertEquals(actual.toString(), expected);
        
    }

}