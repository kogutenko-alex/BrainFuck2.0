package ua.kogutenko.brainfuck.command;

import ua.kogutenko.brainfuck.memory.Memory;

public class LoopCommand implements Command {

    protected InnerLoopCommand innerLoopCommand;

    public LoopCommand(InnerLoopCommand innerLoopCommand) {
        this.innerLoopCommand = innerLoopCommand;
    }

    public LoopCommand() {
    }

    @Override
    public void execute(Memory memory) {
        while (memory.getCurrentBox() != 0) {
            innerLoopCommand.execute(memory);
        }
    }
}
