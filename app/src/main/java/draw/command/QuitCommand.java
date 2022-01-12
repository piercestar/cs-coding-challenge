package draw.command;

import draw.command.Command;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class QuitCommand extends Command {

    @Override
    public void execute() throws Exception {
        System.exit(0);
    }

}