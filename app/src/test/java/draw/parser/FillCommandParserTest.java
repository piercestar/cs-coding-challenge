package draw.model.parser;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import draw.parser.command.CommandParser;
import draw.parser.command.FillCommandParser;
import draw.parser.ParsedCommand;
import draw.parser.ParsedCommand.CommandType;

public class FillCommandParserTest {

    @Test 
    public void Parse_fill_command_with_a_point_and_a_color() throws Exception {

        int x1 = 20;
        int y1 = 4;
        char color = 'c';

        String input = x1 + " " + y1 + " " + color;

        CommandParser parser = new FillCommandParser();
        ParsedCommand parsed = parser.parse(input);

        assertEquals(parsed.getType(), CommandType.FILL);
        assertEquals(parsed.getX1(), x1);
        assertEquals(parsed.getY1(), y1);
        assertEquals(parsed.getColor(), color);
    }

    @Test(expected = NoSuchElementException.class)
    public void Fill_command_without_color_is_invalid() throws Exception {

        int x1 = 20;
        int y1 = 4;
        char color = 'c';

        String input = x1 + " " + y1;

        CommandParser parser = new FillCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }

    @Test(expected = NoSuchElementException.class)
    public void Fill_command_without_color_and_y_coordinate_is_invalid() throws Exception {

        int x1 = 20;
        int y1 = 4;
        char color = 'c';

        String input = "" + x1;

        CommandParser parser = new FillCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }

    @Test(expected = NoSuchElementException.class)
    public void Fill_command_with_no_arguments_is_invalid() throws Exception {

        String input = "";

        CommandParser parser = new FillCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }

    @Test(expected = InputMismatchException.class)
    public void Fill_command_with_character_instead_of_integer_is_invalid() throws Exception {

        String x1 = "aa";
        String y1 = "b";
        char color = 'c';

        String input = x1 + " " + y1 + " " + color;

        CommandParser parser = new FillCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }

    @Test(expected = InputMismatchException.class)
    public void Fill_command_with_decimal_instead_of_integer_is_invalid() throws Exception {

        double x1 = 20.0;
        double y1 = 4.0;
        char color = 'c';

        String input = x1 + " " + y1 + " " + color;

        CommandParser parser = new FillCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }

}