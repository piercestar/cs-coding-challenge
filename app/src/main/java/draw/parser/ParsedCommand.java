package draw.parser;

import draw.model.Canvas;
import draw.parser.ParsedCommandBuilder;

import lombok.Getter;

@Getter
public class ParsedCommand {

    public enum CommandType {
		CANVAS, LINE, RECT, FILL, QUIT, INVALID
	}

    private CommandType type;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private char color;
    private int height;
    private int width;

    public ParsedCommand(ParsedCommandBuilder builder) {
        this.type = builder.getType();
        this.x1 = builder.getX1();
        this.y1 = builder.getY1();
        this.x2 = builder.getX2();
        this.y2 = builder.getY2();
        this.color = builder.getColor();
        this.height = builder.getHeight();
        this.width = builder.getWidth();
    }
}