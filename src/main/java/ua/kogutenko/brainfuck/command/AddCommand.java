package ua.kogutenko.brainfuck.command;

import ua.kogutenko.brainfuck.memory.Memory;

public class AddCommand implements Command {

    public AddCommand() {
    }

    @Override
    public void execute(Memory memory) {
        memory.plus();
    }

}
