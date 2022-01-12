package draw.model.shape;

import draw.model.Canvas;
import draw.model.Coordinate;
import draw.exception.InvalidShapeException;
import draw.exception.OutOfBoundsException;
import draw.exception.UninitializedCanvasException;

public class LineShape implements Shape {

    private Coordinate point1;
    private Coordinate point2;

    public LineShape(int x1, int y1, int x2, int y2) throws InvalidShapeException {
        
        this.point1 = new Coordinate(x1, y1);
        this.point2 = new Coordinate(x2, y2);

        if (!this.point1.isHorizontalOrVerticalLine(this.point2)) {
            throw new InvalidShapeException("Only horizontal or vertical lines are allowed.");
        }
        
    }

    public void draw(Canvas canvas) throws OutOfBoundsException, UninitializedCanvasException {

        if (!canvas.isWithinCanvas(this.point1.getX()-1, this.point1.getY()-1)) {
            throw new OutOfBoundsException(this.point1.getX(), this.point1.getY());
        }

        if (!canvas.isWithinCanvas(this.point2.getX()-1, this.point2.getY()-1)) {
            throw new OutOfBoundsException(this.point2.getX(), this.point2.getY());
        }

        if (this.point1.isHorizontalLine(this.point2)) {
            int y = this.point1.getY();
            int start = Math.min(this.point1.getX(), this.point2.getX());
            int end = Math.max(this.point1.getX(), this.point2.getX());
            for (int x = start; x <= end; x++) {
                canvas.colorPoint(x, y, 'x');
            }
        }

        if (this.point1.isVerticalLine(this.point2)) {
            int x = this.point1.getX();
            int start = Math.min(this.point1.getY(), this.point2.getY());
            int end = Math.max(this.point1.getY(), this.point2.getY());
            for (int y = start; y <= end; y++) {
                canvas.colorPoint(x, y, 'x');
            }
        }

    }
    
}
