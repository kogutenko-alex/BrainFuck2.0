package ua.kogutenko.brainfuck.memory;

public class Memory {

    private final int SIZE_ARRAY = 100;
    private int current_index = 50;
    private final int[] array = new int[SIZE_ARRAY];

    public int getSizeArray() {
        return SIZE_ARRAY;
    }
    public int getCurrentIndex() {
        return current_index;
    }

    public int getArrayCell() {
        return array[current_index];
    }

    public void changeCurrentCellTo(int num) {
        array[current_index] = num;
    }

    public void setCurrentIndex(int index) { current_index = index; }

}
