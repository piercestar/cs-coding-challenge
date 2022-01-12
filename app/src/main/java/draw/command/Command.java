package draw.command;

import draw.model.Canvas;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Command {

    void backup() {
        // backup = editor.textField.getText();
    }

    public void undo() {
        // editor.textField.setText(backup);
    }

    public abstract void execute() throws Exception;
}