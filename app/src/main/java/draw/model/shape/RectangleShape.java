package draw.model.shape;

import draw.model.Point;
import draw.model.Coordinate;
import draw.exception.InvalidShapeException;
import draw.exception.OutOfBoundsException;

public class RectangleShape implements Shape {

    private Coordinate point1;
    private Coordinate point2;

    public RectangleShape(int x1, int y1, int x2, int y2) throws InvalidShapeException {

        // ensure point1 is always smaller than point2
        this.point1 = new Coordinate(
                Math.min(x1,x2),
                Math.min(y1,y2)
            );
        this.point2 = new Coordinate(
                Math.max(x1,x2),
                Math.max(y1,y2)
            );

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

    public void draw(Point[][] canvas) throws OutOfBoundsException {

        if (!isWithinCanvas(canvas)) {
            throw new OutOfBoundsException("Rectangle exceeds the canvas boundary.");
        }

        char color = 'x';
        
        for (int i = this.point1.getX(); i <= this.point2.getX(); i++) {
            canvas[this.point1.getY()-1][i-1].setColor(color);
            canvas[this.point2.getY()-1][i-1].setColor(color);
        }

        for (int i = this.point1.getY(); i <= this.point2.getY(); i++) {
            canvas[i-1][this.point1.getX()-1].setColor(color);
            canvas[i-1][this.point2.getX()-1].setColor(color);
        }
        
    }

    private boolean isWithinCanvas(Point[][] canvas) {

        int height = canvas.length;
        int width = canvas[0].length;

        return this.point1.getX() > 0 && this.point1.getY() > 0 && this.point2.getX() > 0 && this.point2.getY() > 0 &&
                this.point1.getX() <= width && this.point2.getX() <= width && this.point1.getY() <= height && this.point2.getY() <= height;

    }
    
}
