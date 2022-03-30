package ua.kogutenko.brainfuck.command;

import org.junit.jupiter.api.Test;
import ua.kogutenko.brainfuck.memory.Memory;

import static org.junit.jupiter.api.Assertions.*;

class PreviousCommandTest {

    @Test
    public void next() {
        Memory memory = new Memory();
        new PreviousCommand().execute(memory);
        assertEquals(49, memory.getCurrentIndex());
    }
}