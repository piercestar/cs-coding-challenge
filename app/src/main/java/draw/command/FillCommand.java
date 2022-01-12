package draw.command;

import draw.parser.ParsedCommand;
import draw.cli.Printer;
import draw.model.Canvas;
import draw.model.shape.LineShape;
import draw.exception.OutOfBoundsException;

public class FillCommand extends Command {

    private Canvas canvas;
    private int x;
    private int y;
    private char color;

    public FillCommand(Canvas canvas, int x, int y, char color) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public FillCommand(Canvas canvas, ParsedCommand pc) {
        this(canvas, pc.getX1(), pc.getY1(), pc.getColor());
    }

    @Override
    public void execute() throws Exception {
        canvas.fill(this.x, this.y, this.color);
        Printer.print(canvas.getCanvas());
    }

}