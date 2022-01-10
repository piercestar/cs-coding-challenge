package draw.command;

import draw.cli.Printer;
import draw.model.Canvas;
import draw.model.shape.RectangleShape;
import draw.exception.InvalidShapeException;
import draw.exception.OutOfBoundsException;

public class RectangleCommand extends Command {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public RectangleCommand(Canvas canvas, int x1, int y1, int x2, int y2) {
        super(canvas);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void execute() {
        try {
            RectangleShape rect = new RectangleShape(this.x1, this.y1, this.x2, this.y2);
            canvas.addShape(rect);
            Printer.print(canvas.getCanvas());
        } catch (InvalidShapeException e) {
            System.out.println(e.getMessage());
        } catch (OutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

}