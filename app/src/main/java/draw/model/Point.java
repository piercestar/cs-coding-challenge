package draw.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
public class Point {

    private char color;

    private static final char DEFAULT_COLOR = 'o';

    public Point() {
        this.color = DEFAULT_COLOR;
    }

    public Point(Point point) {
        this.color = point.getColor();
    }
}
