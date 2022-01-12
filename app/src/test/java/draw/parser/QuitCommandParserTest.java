package draw.model.parser;

import java.util.Arrays;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import draw.parser.command.CommandParser;
import draw.parser.command.QuitCommandParser;
import draw.parser.ParsedCommand;
import draw.parser.ParsedCommand.CommandType;

public class QuitCommandParserTest {

    @Test 
    public void Parse_quit_command() throws Exception {

        String input = "" + System.getProperty("line.separator");

        CommandParser parser = new QuitCommandParser();
        ParsedCommand parsed = parser.parse(input);

        assertEquals(parsed.getType(), CommandType.QUIT);
    }

}