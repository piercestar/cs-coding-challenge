package draw.command;

import draw.model.Canvas;

public abstract class Command {
    public Canvas canvas;

    Command(Canvas canvas) {
        this.canvas = canvas;
    }

    void backup() {
        // backup = editor.textField.getText();
    }

    public void undo() {
        // editor.textField.setText(backup);
    }

    public abstract void execute();
}