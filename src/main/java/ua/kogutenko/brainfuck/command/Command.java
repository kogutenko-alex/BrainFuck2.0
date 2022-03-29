package ua.kogutenko.brainfuck.command;

import ua.kogutenko.brainfuck.memory.Memory;

public interface Command {
    void execute(Memory memory);
}
