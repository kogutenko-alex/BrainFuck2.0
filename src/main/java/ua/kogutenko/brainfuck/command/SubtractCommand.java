package ua.kogutenko.brainfuck.command;

import ua.kogutenko.brainfuck.memory.Memory;

public class SubtractCommand implements Command {
    @Override
    public void execute(Memory memory) {
        memory.minus();
    }
}
