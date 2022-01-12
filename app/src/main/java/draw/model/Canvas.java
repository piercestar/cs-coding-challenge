package draw.model;

import draw.model.Point;
import draw.model.shape.Shape;
import draw.exception.OutOfBoundsException;
import draw.exception.CanvasInitializationException;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Canvas {

    private int width;
    private int height;
    private Point[][] canvas;

    public Canvas(int width, int height) throws Exception {
        initialize(width, height);
    }

    public void initialize(int width, int height) throws Exception {

        if (width <= 0 || height <= 0) {
            throw new CanvasInitializationException("Canvas height and width should be greater than 0.");
        }

        this.width = width;
        this.height = height;

        Point[][] points = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                points[i][j] = new Point();
            }
        }

        this.canvas = points;

    }

    public void addShape(Shape shape) throws OutOfBoundsException {
        shape.draw(this.canvas);
    }

    public void fill(int x, int y, char color) {
        // to do
    }

    // returns a deep copy of the canvas
    public Point[][] getCanvas() {

        Point[][] copy = new Point[this.height][this.width];

        for (int i=0; i<this.height; i++) {
            for (int j=0; j<this.width; j++) {
                copy[i][j] = new Point(this.canvas[i][j]);
            }
        }

        return copy;

    }
}
