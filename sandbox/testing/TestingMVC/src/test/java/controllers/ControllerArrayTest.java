package controllers;

import model.ArrayMultiply;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ControllerArrayTest {


    ControllerArray controllerArray;
    ArrayMultiply arrayMultiply;
    @BeforeEach
    void testInit() {
        controllerArray = new ControllerArray();
        arrayMultiply = new ArrayMultiply();
    }


    @Test
    void passNumberAndPullListTest () {
        controllerArray.passNumber(4);
        controllerArray.passNumber(7);
        assertEquals(4, controllerArray.pullList().get(0));
        assertEquals(7, controllerArray.pullList().get(1));
    }

    @Test
    void middleTest () {
        controllerArray.passNumber(1);
        controllerArray.passNumber(2);
        controllerArray.passNumber(3);
        controllerArray.passNumber(4);
        assertEquals(2.5, controllerArray.getSumArray());
    }

    @Test
    void compareArrayTest () {
        ControllerArray controllerArray1 = new ControllerArray();
        ControllerArray controllerArray2 = new ControllerArray();
        ControllerArray controllerArray3 = new ControllerArray();
        ControllerArray controllerArray4 = new ControllerArray();
        int [] array1 = new int [] {1, 2, 3, 4};
        int [] array2 = new int [] {5, 3, 1, 1};
        int [] array3 = new int [] {1, 2, 7};
        int [] array4 = new int [] {1, 2, 2, 3, 2};
        fillList(array1, controllerArray1);
        fillList(array2, controllerArray2);
        fillList(array3, controllerArray3);
        fillList(array4, controllerArray4);

        assertEquals(0, controllerArray.compareList(controllerArray1.getSumArray(),
                                                            controllerArray2.getSumArray()));
        assertEquals(-1, controllerArray.compareList(controllerArray1.getSumArray(),
                                                            controllerArray3.getSumArray()));
        assertEquals(1, controllerArray.compareList(controllerArray1.getSumArray(),
                                                            controllerArray4.getSumArray()));
        assertEquals(-1, controllerArray.compareList(controllerArray4.getSumArray(),
                                                            controllerArray3.getSumArray()));
    }

    private void fillList (int [] array, ControllerArray list) {
        for (int j : array) {
            list.passNumber(j);
        }
    }
 }
