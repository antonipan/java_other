package controllers;

import model.ArrayMultiply;
import view.SubMenu;

import java.util.Arrays;
import java.util.List;

public class ControllerArray {
    private final ArrayMultiply arrayMultiply;

    public ControllerArray () {
        arrayMultiply = new ArrayMultiply();
    }

    public void passNumber(int item) {
        arrayMultiply.addNumberToArray(item);
    }

    public List <Integer> pullList() {
        return arrayMultiply.getList();
    }

    public double getSumArray () {
        return arrayMultiply.middleArray();
    }

    public int compareList (double a, double b) {
        return Double.compare(a, b);
    }

}
