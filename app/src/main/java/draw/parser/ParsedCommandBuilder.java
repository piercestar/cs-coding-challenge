package draw.parser;

import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import draw.parser.ParsedCommand.CommandType;
import draw.model.Canvas;

import lombok.Getter;

@Getter
public class ParsedCommandBuilder {

    private CommandType type;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private char color;
    private int height;
    private int width;
    private Scanner scanner;

    public ParsedCommandBuilder(CommandType type, String input) throws Exception  {
        this.type = type;
        this.scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
    }

    public ParsedCommandBuilder x1() throws Exception {
        this.x1 = scanner.nextInt();
        return this;
    }

    public ParsedCommandBuilder y1() throws Exception  {
        this.y1 = scanner.nextInt();
        return this;
    }

    public ParsedCommandBuilder x2() throws Exception  {
        this.x2 = scanner.nextInt();
        return this;
    }

    public ParsedCommandBuilder y2() throws Exception  {
        this.y2 = scanner.nextInt();
        return this;
    }

    public ParsedCommandBuilder color() throws Exception  {
        this.color = scanner.next().charAt(0);
        return this;
    }

    public ParsedCommandBuilder height() throws Exception {
        this.height = scanner.nextInt();
        return this;
    }

    public ParsedCommandBuilder width() throws Exception  {
        this.width = scanner.nextInt();
        return this;
    }

    public ParsedCommand build() throws Exception  {
        return new ParsedCommand(this);
    }
    
}