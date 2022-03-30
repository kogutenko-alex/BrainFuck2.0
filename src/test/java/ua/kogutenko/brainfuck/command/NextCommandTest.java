package ua.kogutenko.brainfuck.command;

import org.junit.jupiter.api.Test;
import ua.kogutenko.brainfuck.memory.Memory;

import static org.junit.jupiter.api.Assertions.*;

class NextCommandTest {
    @Test
    public void next() {
        Memory memory = new Memory();
        new NextCommand().execute(memory);
        assertEquals(51, memory.getCurrentIndex());
    }
}