package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import model.ArrayMultiply;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayMultiplyTest {
    private ArrayMultiply arrayMultiply;
    private List <Integer> listTest;
    private int [] array;

    @BeforeEach
    void initTest () {
        arrayMultiply = new ArrayMultiply();
        listTest = new ArrayList<>();
        listTest.add(1); listTest.add(2); listTest.add(3); listTest.add(4);
        array = new int [] {1, 2, 3, 4};
        for (int i = 0; i < array.length; i++) {
            arrayMultiply.addNumberToArray(array[i]);
        }
//        listTest1 = new ArrayList<>();
//        listTest2 = new ArrayList<>();
//        listTest3 = new ArrayList<>();
//        listTest1.add(1); listTest1.add(2); listTest1.add(3); listTest1.add(4);
//        listTest2.add(5); listTest2.add(3); listTest2.add(1); listTest2.add(1);
//        listTest3.add(1); listTest3.add(3); listTest3.add(6);
    }

    @Test
    void addNumberToArrayTest () {
        int i = 0;
        for (int item : arrayMultiply.getList()
             ) {
            assertEquals(listTest.get(i), item);
            i++;
        }
    }

    @Test
    void getListTest () {
        assertEquals(ArrayList.class, arrayMultiply.getList().getClass());
    }

    @Test
    void middleArrayTest() {
        assertEquals(2.5, arrayMultiply.middleArray());
        arrayMultiply.getList().remove(3);
        assertEquals(2, arrayMultiply.middleArray());
    }
}
