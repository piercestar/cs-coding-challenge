package draw.model.shape;

import draw.model.Point;
import draw.exception.OutOfBoundsException;

public interface Shape {

    public Point[][] draw(Point[][] canvas) throws OutOfBoundsException;
}
