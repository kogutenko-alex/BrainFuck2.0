package ua.kogutenko.brainfuck.command;

import ua.kogutenko.brainfuck.memory.Memory;

public class WriteCommand implements Command {

    @Override
    public void execute(Memory memory) {
        System.out.print((char) memory.getCurrentBox());
    }
}
