package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayMultiply {
    private List<Integer> list;

    public ArrayMultiply () {
        list = new ArrayList<>();
    }

    public void addNumberToArray (int item) {
        list.add(item);
    }

    public List <Integer> getList () {
        return this.list;
    }

    public double middleArray ( ) {
        return list.stream()
                .mapToDouble(Integer::intValue).sum()/list.size();
    }




}
