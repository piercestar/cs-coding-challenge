package draw.model.shape;

import draw.model.Point;
import draw.model.Coordinate;
import draw.exception.InvalidShapeException;
import draw.exception.OutOfBoundsException;

public class LineShape implements Shape {

    private Coordinate point1;
    private Coordinate point2;

    public LineShape(int x1, int y1, int x2, int y2) throws InvalidShapeException {
        
        this.point1 = new Coordinate(x1, y1);
        this.point2 = new Coordinate(x2, y2);

        if (!this.point1.isHorizontalOrVerticalLine(this.point2)) {
            throw new InvalidShapeException("Only horizontal or vertical lines are allowed.");
        }

        // swap points if point1 is after point2
        if (this.point1.isHorizontalLine(this.point2) && (x2 < x1)) {
            this.point1.swap(this.point2);  
        } 
        if (this.point1.isVerticalLine(this.point2) && (y2 < y1)) {
            this.point1.swap(this.point2);  
        }
        
    }

    public Point[][] draw(Point[][] canvas) throws OutOfBoundsException {
        
        if (!isWithinCanvas(canvas)) {
            throw new OutOfBoundsException("Line exceeds the canvas boundary.");
        }

        for (int i = this.point1.getY(); i <= this.point2.getY(); i++) {
            for (int j = this.point1.getX(); j <= this.point2.getX(); j++) {
                canvas[i-1][j-1].setColor('x');
            }
        }

        return canvas;

    }

    private boolean isWithinCanvas(Point[][] canvas) {

        int height = canvas.length;
        int width = canvas[0].length;

        return this.point1.getX() > 0 && this.point1.getY() > 0 && this.point2.getX() > 0 && this.point2.getY() > 0 &&
                this.point1.getX() <= width && this.point2.getX() <= width && this.point1.getY() <= height && this.point2.getY() <= height;

    }
    
}
