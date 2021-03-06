package ua.kogutenko.brainfuck;

import ua.kogutenko.brainfuck.analizator.Analyzer;
import ua.kogutenko.brainfuck.executor.CommandExecutor;
import ua.kogutenko.brainfuck.memory.Memory;

public class BrainFuckStart {
    public static void main(String[] args) {
        try {
            String str = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
            Memory memory = new Memory();
            CommandExecutor commandExecutor = new Analyzer().analyzer(str);
            commandExecutor.execute(memory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
