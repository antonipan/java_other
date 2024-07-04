package lesson3;

public class SomeService {

    public int luckySum (int a, int b, int c) {
        int result = a + b + c;
        if (a == 13) result -=a;
        if (b == 13) result -=b;
        if (c == 13) result -=c;
        return result;
    }



}
