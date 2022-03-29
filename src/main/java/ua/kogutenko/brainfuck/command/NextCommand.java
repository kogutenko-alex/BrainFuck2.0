package ua.kogutenko.brainfuck.command;

import ua.kogutenko.brainfuck.memory.Memory;

public class NextCommand implements Command {

    @Override
    public void execute(Memory memory) {
        memory.setCurrentIndex(memory.getCurrentIndex() + 1);
    }

}
