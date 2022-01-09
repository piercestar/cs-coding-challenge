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

    private void addShape(Shape shape) throws OutOfBoundsException {
        this.canvas = shape.draw(this.canvas);
    }

    public void print() {
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                char color = this.canvas[i][j].getColor();

                System.out.print(color);
            }
            System.out.print('\n');
        }
    }
}
