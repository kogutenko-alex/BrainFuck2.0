package ua.kogutenko.brainfuck.analizator;

import ua.kogutenko.brainfuck.command.*;

public enum CharEnumeration {
    PLUS('+', new AddCommand()),
    MINUS('-', new SubtractCommand()),
    NEXT('>', new NextCommand()),
    PREVIOUS('<', new PreviousCommand()),
    WRITE('.', new WriteCommand()),
    CLOSE_BRACKET(']', new LoopCommand()),
    OPEN_BRACKET('[', new InnerLoopCommand());

    private final char character;
    private final Command command;

    CharEnumeration(char character, Command command) {
        this.character = character;
        this.command = command;
    }

    public char getCharacter() {
        return character;
    }

    public Command getCommandObject() {
        return command;
    }

    public static CharEnumeration getCommandByChar(char ch) throws Exception {
        for (CharEnumeration type : CharEnumeration.values())
            if (type.getCharacter() == ch) return type;
        throw new Exception("Wrong input char");
    }

    public static boolean isExistChar(char ch) {
        for (CharEnumeration type : CharEnumeration.values())
            if (type.getCharacter() == ch) return true;
        return false;
    }

}
