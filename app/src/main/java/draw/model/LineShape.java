package draw.model;

import draw.model.Point;
import draw.exception.InvalidShapeException;

import lombok.*;

public class LineShape implements Shape {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LineShape(int x1, int y1, int x2, int y2) throws InvalidShapeException {
        
        if (!isStraightLines(x1,y1,x2,y2)) {
            throw new InvalidShapeException("Diagonal Lines are not allowed.");
        }

        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        
    }

    private boolean isStraightLines(int x1, int y1, int x2, int y2) {
        return x1 == x2 || y1 == y2;
    }

    public Point[][] paint(Point[][] canvas) {
        
        for (int i = this.y1; i <= this.y2; i++) {
            for (int j = this.x1; j <= this.x2; j++) {
                canvas[i-1][j-1].setColor('x');
            }
        }

        return canvas;

    }
    
}
