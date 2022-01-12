package draw.model;

import draw.model.Point;
import draw.model.shape.Shape;
import draw.exception.OutOfBoundsException;
import draw.exception.CanvasInitializationException;
import draw.exception.UninitializedCanvasException;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Canvas {

    private Point[][] canvas;

    public Canvas(int width, int height) throws CanvasInitializationException{
        initialize(width, height);
    }

    public void initialize(int width, int height) throws CanvasInitializationException {

        if (width <= 0 || height <= 0) {
            throw new CanvasInitializationException("Canvas height and width should be greater than 0.");
        }

        Point[][] points = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                points[i][j] = new Point();
            }
        }

        this.canvas = points;
    }

    public void drawShape(Shape shape) throws UninitializedCanvasException, OutOfBoundsException {
        
        checkCanvasIsInitialized();

        shape.draw(this);
    }

    private void checkCanvasIsInitialized() throws UninitializedCanvasException {
        if (this.canvas == null) {
            throw new UninitializedCanvasException("No canvas to draw on.");
        }
    }

    public void colorPoint(int c, int r, char color) throws UninitializedCanvasException {
        
        checkCanvasIsInitialized();

        this.canvas[r-1][c-1].setColor(color);
    }

    public void fill(int c, int r, char newColor) throws OutOfBoundsException, UninitializedCanvasException{
        
        checkCanvasIsInitialized();

        if (!isWithinCanvas(c-1,r-1)) {
            throw new OutOfBoundsException(c,r);
        }

        char originalColor = this.canvas[r-1][c-1].getColor();

        if (newColor == originalColor) return;

        fill(c-1,r-1,newColor,originalColor);
    }

    private void fill(int c, int r, char newColor, char originalColor) {

        if (isWithinCanvas(c,r)) {
            
            if (this.canvas[r][c].getColor() == originalColor) {
                this.canvas[r][c].setColor(newColor);

                fill(c,r-1,newColor,originalColor);
                fill(c,r+1,newColor,originalColor);
                fill(c-1,r,newColor,originalColor);
                fill(c+1,r,newColor,originalColor);
            }
        }
    }

    public boolean isWithinCanvas(int col, int row) {

        int width = this.canvas[0].length;
        int height = this.canvas.length;

        return col >= 0 && row >= 0 && row < height && col < width;

    }

    // returns a deep copy of the canvas
    public Point[][] getCanvas() throws UninitializedCanvasException {

        checkCanvasIsInitialized();

        int width = this.canvas[0].length;
        int height = this.canvas.length;
        Point[][] copy = new Point[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                copy[i][j] = new Point(this.canvas[i][j]);
            }
        }

        return copy;

    }
}
