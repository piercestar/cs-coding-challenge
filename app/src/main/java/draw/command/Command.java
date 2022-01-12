package draw.command;

import draw.model.Canvas;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Command {

    public abstract void execute() throws Exception;
}