package ua.kogutenko.brainfuck.command;

import org.junit.jupiter.api.Test;
import ua.kogutenko.brainfuck.memory.Memory;

import static org.junit.jupiter.api.Assertions.*;

class SubtractCommandTest {
    @Test
    void add() {
        Memory memory = new Memory();
        new SubtractCommand().execute(memory);
        assertEquals(-1, memory.getCurrentBox());
    }
}