package draw.parser.command;

import java.util.Scanner;

import draw.parser.ParsedCommand;
import draw.parser.ParsedCommandBuilder;
import draw.parser.command.CommandParser;
import static draw.parser.ParsedCommand.CommandType;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class QuitCommandParser extends CommandParser {

    public ParsedCommand parse(String input) throws Exception {
        
        ParsedCommand command = new ParsedCommandBuilder(CommandType.QUIT, input)
                                                .build();
                                                
        return command;
    }
}