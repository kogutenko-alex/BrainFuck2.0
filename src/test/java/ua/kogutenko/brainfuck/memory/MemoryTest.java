package ua.kogutenko.brainfuck.memory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryTest {

    @Test
    void getSizeArrayTrue() {
        Memory memory = new Memory();
        assertEquals(1000, memory.getSizeArray());
    }

    @Test
    void nextBox() {
        Memory memory = new Memory();
        memory.next();
        assertEquals(51, memory.getCurrentIndex());
    }
    @Test
    void previousBox() {
        Memory memory = new Memory();
        memory.previous();
        assertEquals(49, memory.getCurrentIndex());
    }

    @Test
    void add() {
        Memory memory = new Memory();
        memory.plus();
        assertEquals(1, memory.getCurrentBox());
    }

    @Test
    void minus() {
        Memory memory = new Memory();
        memory.minus();
        assertEquals(-1, memory.getCurrentBox());
    }


}