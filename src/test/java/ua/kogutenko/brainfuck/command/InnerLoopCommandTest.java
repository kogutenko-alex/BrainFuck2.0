package ua.kogutenko.brainfuck.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InnerLoopCommandTest {
    private ArrayList<Command> commands = new ArrayList<>();

    @BeforeEach
    void setUp() {
        commands = preparing();
    }

    @Test
    void quantityWhenAddedCorrect() {
        InnerLoopCommand innerLoopCommand = new InnerLoopCommand();
        preparingILC(innerLoopCommand);
        assertEquals(commands.size(), innerLoopCommand.getCommands().size());
    }

    private void preparingILC(InnerLoopCommand innerLoopCommand) {
        innerLoopCommand.addCommand(new AddCommand());
        innerLoopCommand.addCommand(new SubtractCommand());
        innerLoopCommand.addCommand(new PreviousCommand());
    }

    private ArrayList<Command> preparing() {
        return (ArrayList<Command>) Stream.of(new AddCommand(), new SubtractCommand(), new PreviousCommand()).collect(Collectors.toList());
    }
}