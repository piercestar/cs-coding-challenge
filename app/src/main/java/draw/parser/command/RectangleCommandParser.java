package draw.parser.command;

import java.util.Scanner;

import draw.parser.ParsedCommand;
import draw.parser.ParsedCommandBuilder;
import draw.parser.command.CommandParser;
import static draw.parser.ParsedCommand.CommandType;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RectangleCommandParser extends CommandParser {

    public ParsedCommand parse(String input) throws Exception {
        
        ParsedCommand command = new ParsedCommandBuilder(CommandType.RECT, input)
                                                .x1()
                                                .y1()
                                                .x2()
                                                .y2()
                                                .build();
                                                
        return command;
    }
}