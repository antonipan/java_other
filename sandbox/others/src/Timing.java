package projectsByJava.sandbox;

public class Timing {

    public static void main(String[] args) throws InterruptedException {
        Func func = new Func();
        Timing timer = new Timing();
        System.out.println(timer.timing(func, 1000000) + " result");
    }

    public long timing(Func func, int b) throws InterruptedException {
        long start = System.currentTimeMillis();
        func.summ(b);
//        Thread.sleep(1000);
        long finish = System.currentTimeMillis();
        long result = finish - start;
        return result;
    }
}

class Func {
    public double summ(int b) {
        double summator = 0;
        for (double i = 0.1; i < b; i+=0.1) {
            System.out.print(i+" ");
        }
        return summator;
    }

}

