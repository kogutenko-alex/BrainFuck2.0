package ua.kogutenko.brainfuck.memory;

public class Memory {

    private final int SIZE_ARRAY = 1000;
    private int current_index = 50;
    private final int[] array = new int[SIZE_ARRAY];

    public void plus() {
        array[current_index]++;
    }

    public void minus() {
        array[current_index]--;
    }

    public boolean next() {
        if (current_index < SIZE_ARRAY - 1) {
            current_index++;
            return true;
        }
        return false;
    }

    public boolean previous() {
        if (current_index > 0) {
            current_index--;
            return true;
        }
        return false;
    }

    public int getSizeArray() {
        return SIZE_ARRAY;
    }

    public int getCurrentIndex() {
        return current_index;
    }

    public int getCurrentBox() {
        return array[current_index];
    }
}
