package draw.model;

import java.util.Arrays;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import draw.model.Canvas;
import draw.model.shape.LineShape;
import draw.exception.CanvasInitializationException;
import draw.exception.UninitializedCanvasException;
import draw.exception.OutOfBoundsException;

public class CanvasTest {

    @Test
    public void Initialize_canvas_width_and_height() throws Exception {

        int height = 4;
        int width = 20;

        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                expected[i][j] = new Point();
            }
        }
                        
        Canvas canvas = new Canvas();
        canvas.initialize(width, height);

        assertEquals(canvas.getCanvas()[0].length, width);
        assertEquals(canvas.getCanvas().length, height);
        assertEquals(canvas.getCanvas(), expected);
        
    }

    @Test (expected = CanvasInitializationException.class)
    public void Initializing_canvas_with_negative_width_is_invalid() throws Exception {

        int height = 4;
        int width = -20;

        Canvas canvas = new Canvas();
        canvas.initialize(width, height);

    }

    @Test (expected = CanvasInitializationException.class)
    public void Initializing_canvas_with_negative_height_is_invalid() throws Exception {

        int height = -4;
        int width = 20;
                    
        Canvas canvas = new Canvas();
        canvas.initialize(width, height);

    }

    @Test (expected = CanvasInitializationException.class)
    public void Initializing_canvas_with_zero_width_and_height_is_invalid() throws Exception {

        int height = 0;
        int width = 0;

        Canvas canvas = new Canvas();
        canvas.initialize(width, height);
        
    }

    @Test (expected = CanvasInitializationException.class)
    public void Initializing_canvas_with_zero_width_is_invalid() throws Exception {

        int height = 4;
        int width = 0;

        Canvas canvas = new Canvas();
        canvas.initialize(width, height);
        
    }

    @Test (expected = CanvasInitializationException.class)
    public void Initializing_canvas_with_zero_height_is_invalid() throws Exception {

        int height = 0;
        int width = 20;

        Canvas canvas = new Canvas();
        canvas.initialize(width, height);
        
    }

    @Test 
    public void Fill_blank_canvas_with_character_a() throws Exception {

        int height = 4;
        int width = 20;
        int x = 1;
        int y = 1;
        char color = 'a';

        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                expected[i][j] = new Point();
                expected[i][j].setColor('a');
            }
        }

        Canvas canvas = new Canvas(width, height);
        canvas.fill(x,y,color);

        assertEquals(canvas.getCanvas(), expected);
        
    }

    @Test 
    public void Fill_blank_canvas_with_number_1() throws Exception {

        int height = 4;
        int width = 20;
        int x = 1;
        int y = 1;
        char color = '1';

        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                expected[i][j] = new Point();
                expected[i][j].setColor('1');
            }
        }

        Canvas canvas = new Canvas(width, height);
        canvas.fill(x,y,color);

        assertEquals(canvas.getCanvas(), expected);
        
    }

    @Test 
    public void Fill_blank_canvas_with_special_char_newline() throws Exception {

        int height = 4;
        int width = 20;
        int x = 1;
        int y = 1;
        char color = '\n';

        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                expected[i][j] = new Point();
                expected[i][j].setColor('\n');
            }
        }

        Canvas canvas = new Canvas(width, height);
        canvas.fill(x,y,color);

        assertEquals(canvas.getCanvas(), expected);
        
    }

    @Test 
    public void Fill_blank_canvas_with_same_char_whitespace() throws Exception {

        int height = 4;
        int width = 20;
        int x = 1;
        int y = 1;
        char color = ' ';

        Point[][] expected = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                expected[i][j] = new Point();
                expected[i][j].setColor(' ');
            }
        }

        Canvas canvas = new Canvas(width, height);
        canvas.fill(x,y,color);

        assertEquals(canvas.getCanvas(), expected);
        
    }

    @Test (expected = OutOfBoundsException.class)
    public void Filling_a_point_outside_the_canvas_is_invalid() throws Exception {

        int height = 4;
        int width = 20;
        int x = 100;
        int y = 200;
        char color = ' ';

        Canvas canvas = new Canvas(width, height);
        canvas.fill(x,y,color);
        
    }

    @Test (expected = UninitializedCanvasException.class)
    public void Filling_without_initializing_the_canvas_is_invalid() throws Exception {

        int height = 4;
        int width = 20;
        int x = 100;
        int y = 200;
        char color = ' ';

        Canvas canvas = new Canvas();
        canvas.fill(x,y,color);
        
    }

    @Test (expected = UninitializedCanvasException.class)
    public void Getting_the_canvas_without_initializing_it_is_invalid() throws Exception {

        Canvas canvas = new Canvas();
        canvas.getCanvas();
    }

    @Test (expected = UninitializedCanvasException.class)
    public void Coloring_a_point_without_initializing_the_canvas_is_invalid() throws Exception {

        int x = 100;
        int y = 200;
        char color = ' ';

        Canvas canvas = new Canvas();
        canvas.colorPoint(x,y,color);
    }

    @Test (expected = UninitializedCanvasException.class)
    public void Drawing_a_shape_without_initializing_the_canvas_is_invalid() throws Exception {

        int x = 100;
        int y = 200;
        char color = ' ';

        Canvas canvas = new Canvas();
        LineShape line = new LineShape(1,1,1,1);
        canvas.drawShape(line);
    }
}