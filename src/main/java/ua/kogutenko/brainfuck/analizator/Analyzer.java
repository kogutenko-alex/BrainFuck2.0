package ua.kogutenko.brainfuck.analizator;

import ua.kogutenko.brainfuck.command.*;
import ua.kogutenko.brainfuck.executor.CommandExecutor;

import java.util.HashMap;
import java.util.Stack;

public class Analyzer {

    private final HashMap<Character, Command> commandMap;

    public Analyzer() {
        commandMap = new HashMap<>();
        commandMap.put('+', new AddCommand());
        commandMap.put('-', new SubtractCommand());
        commandMap.put('>', new NextCommand());
        commandMap.put('<', new PreviousCommand());
        commandMap.put(']', new LoopCommand());
        commandMap.put('[', new InnerLoopCommand());
        commandMap.put('.', new WriteCommand());
    }

    public CommandExecutor analyzer(String innerCode) {
        int pos = 0, countInnerLoop = 0;
        CommandExecutor retValue = new CommandExecutor();
        Stack<InnerLoopCommand> stackILC = new Stack<>();

        while (pos < innerCode.length()) {
            if (commandMap.containsKey(innerCode.charAt(pos))) {
                // show that there is a cycle
                if (innerCode.charAt(pos) == '[') {
                    stackILC.push(new InnerLoopCommand());
                    countInnerLoop++;
                }


                // remove cycle
                if (innerCode.charAt(pos) == ']') {
                    countInnerLoop--;
                    if (countInnerLoop == 0)
                        retValue.register(new LoopCommand(stackILC.pop()));
                    if (countInnerLoop > 0) {
                        InnerLoopCommand ILC = stackILC.pop();
                        stackILC.peek().addCommand(new LoopCommand(ILC));
                    }
                }

                // add commands to the main list of commands if it is not in a loop
                if (countInnerLoop == 0)
                    retValue.register(commandMap.get(innerCode.charAt(pos)));
                // add a command inside the loop command
                if (countInnerLoop > 0)
                    stackILC.peek().addCommand(commandMap.get(innerCode.charAt(pos)));
            }
            pos++;

        }
        return retValue;
    }
}

