package draw.command;

import draw.cli.Printer;
import draw.parser.ParsedCommand;
import draw.model.Canvas;
import draw.model.shape.RectangleShape;
import draw.exception.InvalidShapeException;
import draw.exception.OutOfBoundsException;

public class RectangleCommand extends Command {

    private Canvas canvas;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public RectangleCommand(Canvas canvas, int x1, int y1, int x2, int y2) {
        this.canvas = canvas;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public RectangleCommand(Canvas canvas, ParsedCommand pc) {
        this(canvas, pc.getX1(), pc.getY1(), pc.getX2(), pc.getY2());
    }

    @Override
    public void execute() throws Exception {
        try {
            RectangleShape rect = new RectangleShape(this.x1, this.y1, this.x2, this.y2);
            canvas.drawShape(rect);
            Printer.print(canvas.getCanvas());
        } catch (InvalidShapeException e) {
            System.out.println(e.getMessage());
        } catch (OutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

}