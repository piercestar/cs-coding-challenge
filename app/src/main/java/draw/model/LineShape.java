package draw.model;

import draw.model.Point;

import lombok.*;

@AllArgsConstructor
public class LineShape extends Shape {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Point[][] paint(Point[][] canvas) {
        
        for (int i = this.y1; i <= this.y2; i++) {
            for (int j = this.x1; j <= this.x2; j++) {
                canvas[i-1][j-1].setColor('x');
            }
        }

        return canvas;

    }
    
}
