package java_tasks.level_4;

import java.util.Arrays;

public class MyRelais {
    private int [] array;
    private int size;

    MyRelais(int capacity){
    array = new int [capacity];
    }

    int size() {
        return size;
    }

    boolean empty() {
        return size == 0;
    }

    void push (int element) {
        if (array.length <=size){
            int [] array_2 = new int [array.length*2];
            System.arraycopy(array, 0, array_2, 0, array.length);
            array = array_2;
        }
        array[size] = element;
        size++;

    }

    int peek () {
        return array[size-1];
    }

    int pop () {
        int val = array[size-1];
        size--;
        return val;
    }

    public String toString() {
        return Arrays.toString(array);
    }
}
