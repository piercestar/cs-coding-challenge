package draw.parser;

import java.util.Scanner;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

import draw.model.Canvas;
import draw.command.Command;
import draw.parser.ParsedCommand;
import static draw.parser.ParsedCommand.CommandType;
import draw.parser.command.*;
import draw.exception.ParserException;
import draw.exception.UnknownCommandTypeException;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Parser {

    private static HashMap<String, CommandType> keywordMap;
    private static HashMap<CommandType, String> usageMap;
    private static final CommandAttributes[] COMMAND_ATTRIBUTES = {
        new CommandAttributes(CommandType.CANVAS, new String[] {"C", "c"}, "C <height> <width>"),
        new CommandAttributes(CommandType.LINE, new String[] {"L", "l"}, "L <x1> <y1> <x2> <y2>"),
        new CommandAttributes(CommandType.RECT, new String[] {"R", "r"}, "R <x1> <y1> <x2> <y2>"),
        new CommandAttributes(CommandType.FILL, new String[] {"B", "b"}, "B <x> <y> <color>"),
        new CommandAttributes(CommandType.QUIT, new String[] {"Q", "q"}, "Q")
    };

    static {
        setupKeywordsMap();
        setupUsageMap();
    }

    public ParsedCommand parse() throws ParserException {
        
        CommandType type = null;
        String input = null;

        try {

            System.out.print("enter command: ");
            Scanner sc = new Scanner(System.in);
            type = getCommandType(sc.next());
            input = sc.nextLine();
            CommandParser parser;

            switch (type) {
                case CANVAS:
                    parser = new CanvasCommandParser();
                    break;
                case LINE:
                    parser = new LineCommandParser();
                    break;
                case RECT:
                    parser = new RectangleCommandParser();
                    break;
                case FILL:
                    parser = new FillCommandParser();
                    break;
                case QUIT:
                    parser = new QuitCommandParser();
                    break;
                default:
                    throw new UnknownCommandTypeException("Unknown Command.");
            }
            
            return parser.parse(input);

        } catch (InputMismatchException e) {
            String errorMsg = constructErrorMessage(type, "Wrong argument type.");
            throw new ParserException(errorMsg);
        } catch (NoSuchElementException e) {
            String errorMsg = constructErrorMessage(type, "Missing arguments.");
            throw new ParserException(errorMsg);
        } catch (Exception e) {
            throw new ParserException(e.getMessage());
        }
    }

    private static void setupKeywordsMap() {
		keywordMap = new HashMap<String, CommandType>();
		for (int i = 0; i < COMMAND_ATTRIBUTES.length; i++) {
		    String[] keywords = COMMAND_ATTRIBUTES[i].keywords;
		    CommandType type = COMMAND_ATTRIBUTES[i].commandType;
		    for (int j = 0; j < keywords.length; j++) {
		    	keywordMap.put(keywords[j], type);
		    }
		}
    }

    private static void setupUsageMap() {
		usageMap = new HashMap<CommandType, String>();
		for (int i = 0; i < COMMAND_ATTRIBUTES.length; i++) {
		    String usage = COMMAND_ATTRIBUTES[i].usage;
		    CommandType type = COMMAND_ATTRIBUTES[i].commandType;
            usageMap.put(type, usage);
		}
    }


    private CommandType getCommandType(String input) {
        CommandType type = keywordMap.get(input);
        if (type != null ) {
            return type;
        } else {
            return CommandType.INVALID;
        }
    }

    private String constructErrorMessage(CommandType type, String error) {
        
        String errorMsg =   System.getProperty("line.separator") +
                            "[Error] " + error + System.getProperty("line.separator") +
                            System.getProperty("line.separator") +
                            "Usage: " + System.getProperty("line.separator") +
                            usageMap.get(type) + 
                            System.getProperty("line.separator");

        return errorMsg;
    }

    public static class CommandAttributes {
		public String[] keywords;
		public CommandType commandType;
        public String usage;
		public CommandAttributes(CommandType type, String[] stringChoices, String usage) {
			this.keywords = stringChoices;
			this.commandType = type;
            this.usage = usage;
		}
	}


}
