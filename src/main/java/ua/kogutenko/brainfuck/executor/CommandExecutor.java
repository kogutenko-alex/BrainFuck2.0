package ua.kogutenko.brainfuck.executor;

import ua.kogutenko.brainfuck.command.Command;
import ua.kogutenko.brainfuck.memory.Memory;

import java.util.*;
import java.util.ArrayList;

public class CommandExecutor {
    private final List<Command> commandList = new ArrayList<>();

    public void register(Command command) {
        commandList.add(command);
    }

    public void execute(Memory memory) {
        for (Command command : commandList) {
            command.execute(memory);
        }
    }
}
