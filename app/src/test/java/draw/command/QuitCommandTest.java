package draw.command;

import java.util.Arrays;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import static org.junit.Assert.*;

import draw.command.QuitCommand;

public class QuitCommandTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void Exit_application() throws Exception {
        QuitCommand command = new QuitCommand();
        exit.expectSystemExitWithStatus(0);
        command.execute();
    }
}