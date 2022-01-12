package draw.model.parser;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import draw.parser.command.CommandParser;
import draw.parser.command.LineCommandParser;
import draw.parser.ParsedCommand;
import draw.parser.ParsedCommand.CommandType;

public class LineCommandParserTest {

    @Test 
    public void Parse_line_command_with_two_points() throws Exception {

        int x1 = 20;
        int y1 = 4;
        int x2 = 10;
        int y2 = 10;

        String input = x1 + " " + y1 + " " + x2 + " " +  y2;

        CommandParser parser = new LineCommandParser();
        ParsedCommand parsed = parser.parse(input);

        assertEquals(parsed.getType(), CommandType.LINE);
        assertEquals(parsed.getX1(), x1);
        assertEquals(parsed.getY1(), y1);
        assertEquals(parsed.getX2(), x2);
        assertEquals(parsed.getY2(), y2);
    }

    @Test(expected = NoSuchElementException.class)
    public void Line_command_without_y2_is_invalid() throws Exception {

        int x1 = 20;
        int y1 = 4;
        int x2 = 10;
        int y2 = 10;

        String input = x1 + " " + y1 + " " + x2;

        CommandParser parser = new LineCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }

    @Test(expected = NoSuchElementException.class)
    public void Line_command_without_x2_and_y2_is_invalid() throws Exception {

        int x1 = 20;
        int y1 = 4;
        int x2 = 10;
        int y2 = 10;

        String input = x1 + " " + y1;

        CommandParser parser = new LineCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }

    @Test(expected = NoSuchElementException.class)
    public void Line_command_without_y1_x2_and_y2_is_invalid() throws Exception {

        int x1 = 20;
        int y1 = 4;
        int x2 = 10;
        int y2 = 10;

        String input = "" + x1;

        CommandParser parser = new LineCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }

    @Test(expected = NoSuchElementException.class)
    public void Line_command_without_arguments_is_invalid() throws Exception {

        int x1 = 20;
        int y1 = 4;
        int x2 = 10;
        int y2 = 10;

        String input = "";

        CommandParser parser = new LineCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }

    @Test(expected = InputMismatchException.class)
    public void Line_command_with_character_instead_of_integer_is_invalid() throws Exception {

        String x1 = "aa";
        String y1 = "b";
        String x2 = "cc";
        String y2 = "ddd";

        String input = x1 + " " + y1 + " " + x2 + " " + y2;

        CommandParser parser = new LineCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }

    @Test(expected = InputMismatchException.class)
    public void Line_command_with_decimal_instead_of_integer_is_invalid() throws Exception {

        double x1 = 20.0;
        double y1 = 4.0;
        double x2 = 10.0;
        double y2 = 10.0;

        String input = x1 + " " + y1 + " " + x2 + " " + y2;

        CommandParser parser = new LineCommandParser();
        ParsedCommand parsed = parser.parse(input);
    }
}