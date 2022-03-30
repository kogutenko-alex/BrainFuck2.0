package ua.kogutenko.brainfuck.command;

import org.junit.jupiter.api.Test;
import ua.kogutenko.brainfuck.memory.Memory;

import static org.junit.jupiter.api.Assertions.*;

class AddCommandTest {

    @Test
    void add() {
        Memory memory = new Memory();
        new AddCommand().execute(memory);
        assertEquals(1, memory.getCurrentBox());
    }
}