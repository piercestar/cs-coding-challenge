package draw.model.shape;

import draw.model.Canvas;
import draw.model.Coordinate;
import draw.exception.InvalidShapeException;
import draw.exception.OutOfBoundsException;
import draw.exception.UninitializedCanvasException;

public class RectangleShape implements Shape {

    private Coordinate point1;
    private Coordinate point2;

    public RectangleShape(int x1, int y1, int x2, int y2) throws InvalidShapeException {

        // ensure point1 is always smaller than point2
        this.point1 = new Coordinate(x1, y1);
        this.point2 = new Coordinate(x2, y2);

        if (this.point1.equals(this.point2)) {
            throw new InvalidShapeException("Cannot draw rectangle with a single point.");
        }

        if (this.point1.getX() == this.point2.getX()) {
            throw new InvalidShapeException("Cannot draw rectangle with no width.");
        }

        if (this.point1.getY() == this.point2.getY()) {
            throw new InvalidShapeException("Cannot draw rectangle with no height.");
        }

        
    }

    public void draw(Canvas canvas) throws UninitializedCanvasException, OutOfBoundsException { 

        if (!canvas.isWithinCanvas(this.point1.getX()-1, this.point1.getY()-1) ) {
            throw new OutOfBoundsException(this.point1.getX(), this.point1.getY());
        }

        if (!canvas.isWithinCanvas(this.point2.getX()-1, this.point2.getY()-1) ) {
            throw new OutOfBoundsException(this.point2.getX(), this.point2.getY());
        }

        char color = 'x';

        int start = Math.min(this.point1.getX(), this.point2.getX());
        int end = Math.max(this.point1.getX(), this.point2.getX());
        
        for (int i = start; i <= end; i++) {
            canvas.colorPoint(i, this.point1.getY(), color);
            canvas.colorPoint(i, this.point2.getY(), color);
        }

        start = Math.min(this.point1.getY(), this.point2.getY());
        end = Math.max(this.point1.getY(), this.point2.getY());

        for (int i = start; i <= end; i++) {
            canvas.colorPoint(this.point1.getX(), i, color);
            canvas.colorPoint(this.point2.getX(), i, color);
        }
        
    }
    
}
