package draw.model.parser;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import draw.parser.command.CommandParser;
import draw.parser.command.CanvasCommandParser;
import draw.parser.ParsedCommand;
import draw.parser.ParsedCommand.CommandType;

public class CanvasCommandParserTest {

    @Test 
    public void Parse_canvas_command_with_width_and_height() throws Exception {

        int width = 20;
        int height = 4;

        String input = width + " " + height;

        CommandParser parser = new CanvasCommandParser();
        ParsedCommand parsed = parser.parse(input);

        assertEquals(parsed.getType(), CommandType.CANVAS);
        assertEquals(parsed.getWidth(), width);
        assertEquals(parsed.getHeight(), height);
    }

    @Test(expected = NoSuchElementException.class)
    public void Canvas_command_with_width_only_is_invalid() throws Exception {

        int width = 20;
        int height = 4;

        String input = "" + width;

        CommandParser parser = new CanvasCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }

    @Test(expected = NoSuchElementException.class)
    public void Canvas_command_with_no_arguments_is_invalid() throws Exception {

        int width = 20;
        int height = 4;

        String input = "";

        CommandParser parser = new CanvasCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }

    @Test(expected = InputMismatchException.class)
    public void Canvas_command_with_character_instead_of_integer_is_invalid() throws Exception {

        String width = "aa";
        String height = "b";

        String input = width + " " + height;

        CommandParser parser = new CanvasCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }

    @Test(expected = InputMismatchException.class)
    public void Canvas_command_with_decimal_instead_of_integer_is_invalid() throws Exception {

        String width = "20.0";
        String height = "4.0";

        String input = width + " " + height;

        CommandParser parser = new CanvasCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }
}