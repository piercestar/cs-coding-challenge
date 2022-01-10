package draw.model;

import draw.model.Point;
import draw.model.shape.Shape;
import draw.exception.OutOfBoundsException;

public class Canvas {

    private int width;
    private int height;
    private Point[][] canvas;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.canvas = initCanvas(width, height);
    }

    public Point[][] initCanvas(int width, int height) {

        Point[][] points = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                points[i][j] = new Point();
            }
        }

        return points;
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
