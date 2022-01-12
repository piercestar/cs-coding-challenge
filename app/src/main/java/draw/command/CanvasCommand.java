package draw.command;

import draw.parser.ParsedCommand;
import draw.cli.Printer;
import draw.model.Canvas;
import draw.model.shape.LineShape;
import draw.exception.OutOfBoundsException;

public class CanvasCommand extends Command {

    private Canvas canvas;
    private int width;
    private int height;

    public CanvasCommand(Canvas canvas, int width, int height) {
        this.canvas = canvas;
        this.width = width;
        this.height = height;
    }

    public CanvasCommand(Canvas canvas, ParsedCommand pc) {
        this(canvas, pc.getWidth(), pc.getHeight());
    }

    @Override
    public void execute() throws Exception {
        try {
            canvas.initialize(width, height);
            Printer.print(canvas.getCanvas());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}