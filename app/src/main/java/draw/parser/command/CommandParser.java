package draw.parser.command;

import draw.parser.ParsedCommand;

public abstract class CommandParser {

    public abstract ParsedCommand parse(String input) throws Exception;
}