package ua.kogutenko.brainfuck.command;

import ua.kogutenko.brainfuck.memory.Memory;

import java.util.ArrayList;

public class InnerLoopCommand implements Command {

    protected ArrayList<Command> arrayCommand = new ArrayList<>();

    public void addCommand(Command command) {
        arrayCommand.add(command);
    }

    @Override
    public void execute(Memory memory) {
        Command command;
        for (Command value : arrayCommand) {
            command = value;
            command.execute(memory);
        }
    }
}
