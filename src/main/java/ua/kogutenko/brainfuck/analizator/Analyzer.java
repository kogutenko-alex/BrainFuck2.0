package ua.kogutenko.brainfuck.analizator;

import ua.kogutenko.brainfuck.command.Command;
import ua.kogutenko.brainfuck.command.InnerLoopCommand;
import ua.kogutenko.brainfuck.command.LoopCommand;
import ua.kogutenko.brainfuck.executor.CommandExecutor;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public class Analyzer {
    private final CommandExecutor executor = new CommandExecutor();
    private final Stack<InnerLoopCommand> stackILC = new Stack<>();

    public CommandExecutor analyzer(String code) throws Exception {
        for (byte currentByte : code.getBytes()) {
            char currentChar = (char) currentByte;

            if (!CharEnumeration.isExistChar(currentChar)) {
                throw new Exception("is not exist char: " + currentChar);
            }

            putCommandToExecutor(CharEnumeration.getCommandByChar(currentChar).getCommandObject());
        }
        return executor;
    }

    private void putCommandToExecutor(Command currentCommand) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        // add a loop
        if (currentCommand instanceof InnerLoopCommand) {
            stackILC.push((InnerLoopCommand) currentCommand);
            return;
        }

        // remove cycle
        if (currentCommand instanceof LoopCommand) {
            putCommandToBacked(currentCommand);
            return;
        }


        // add commands to the main list of commands if it is not in a loop
        if (stackILC.isEmpty()) executor.register(currentCommand);
        // add a command inside the loop command
        else stackILC.peek().addCommand(currentCommand);
    }

    private void putCommandToBacked(Command currentCommand) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        InnerLoopCommand command = stackILC.pop();
        if (stackILC.isEmpty()) {
            executor.register(
                    currentCommand.getClass()
                            .getConstructor(InnerLoopCommand.class)
                            .newInstance(command));
        } else {
            stackILC.peek().addCommand(
                    currentCommand.getClass()
                            .getConstructor(InnerLoopCommand.class)
                            .newInstance(command));
        }
    }
}

