package ua.kogutenko.brainfuck.analizator;

import org.junit.jupiter.api.Test;
import ua.kogutenko.brainfuck.command.*;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class CharEnumerationTest {
    private CharEnumeration charEnumeration;

    //+
    @Test
    public void getPlusName() {
        assertEquals('+', CharEnumeration.PLUS.getCharacter());
    }

    //+
    @Test
    public void getMinusName() {
        assertEquals('-', CharEnumeration.MINUS.getCharacter());
    }

    //+
    @Test
    public void getNextName() {
        assertEquals('>', CharEnumeration.NEXT.getCharacter());
    }

    //+
    @Test
    public void getPreviousName() {
        assertEquals('<', CharEnumeration.PREVIOUS.getCharacter());
    }

    //+
    @Test
    public void getCloseBracketName() {
        assertEquals(']', CharEnumeration.CLOSE_BRACKET.getCharacter());
    }

    //+
    @Test
    public void getOpenBracketName() {
        assertEquals('[', CharEnumeration.OPEN_BRACKET.getCharacter());
    }

    //+
    @Test
    public void getWriteName() {
        assertEquals('.', CharEnumeration.WRITE.getCharacter());
    }

    /////////////////////////////////////////////////
    //+
    @Test
    public void getAddCommand() {
        assertEquals(AddCommand.class, CharEnumeration.PLUS.getCommandClass());
    }

    @Test
    public void getMinusCommand() {
        assertEquals(SubtractCommand.class, CharEnumeration.MINUS.getCommandClass());
    }

    @Test
    public void getNextCommand() {
        assertEquals(NextCommand.class, CharEnumeration.NEXT.getCommandClass());
    }

    @Test
    public void getPreviousCommand() {
        assertEquals(PreviousCommand.class, CharEnumeration.PREVIOUS.getCommandClass());
    }

    @Test
    public void getCloseBracketCommand() {
        assertEquals(LoopCommand.class, CharEnumeration.CLOSE_BRACKET.getCommandClass());
    }

    @Test
    public void getOpenBracketCommand() {
        assertEquals(InnerLoopCommand.class, CharEnumeration.OPEN_BRACKET.getCommandClass());
    }

    @Test
    public void getWriteCommand() {
        assertEquals(WriteCommand.class, CharEnumeration.WRITE.getCommandClass());
    }

    @Test
    public void getCommandFromChar() throws Exception {
        assertEquals(CharEnumeration.PLUS, CharEnumeration.getCommandByChar('+'));
    }

    @Test
    public void isExistChar() {
        assertTrue(CharEnumeration.isExistChar('+'));
    }

    @Test
    public void isNotExistChar() {
        assertFalse(CharEnumeration.isExistChar('q'));
    }

}