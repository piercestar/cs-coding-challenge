package draw.command;

import draw.cli.Printer;
import draw.model.Canvas;
import draw.model.shape.LineShape;
import draw.exception.InvalidShapeException;
import draw.exception.OutOfBoundsException;

public class LineCommand extends Command {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LineCommand(Canvas canvas, int x1, int y1, int x2, int y2) {
        super(canvas);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void execute() {

        try {
            LineShape line = new LineShape(this.x1, this.y1, this.x2, this.y2);
            canvas.addShape(line);
            Printer.print(canvas.getCanvas());
        } catch (InvalidShapeException e) {
            System.out.println(e.getMessage());
        } catch (OutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

}