package draw.model.shape;

import draw.model.Point;
import draw.exception.OutOfBoundsException;

public interface Shape {

    public void draw(Point[][] canvas) throws OutOfBoundsException;
}
