package draw.model.shape;

import draw.model.Canvas;
import draw.exception.OutOfBoundsException;
import draw.exception.UninitializedCanvasException;

public interface Shape {

    public void draw(Canvas canvas) throws UninitializedCanvasException, OutOfBoundsException;
}
