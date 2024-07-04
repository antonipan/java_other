import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.*;

public class Exm01 {

    public static final int FROM_NUMBER_FIRST_THREAD = 1;
    public static final int TO_NUMBER_FIRST_THREAD = 5000;
    public static final int FROM_NUMBER_SECOND_THREAD = 5001;
    public static final int TO_NUMBER_SECOND_THREAD = 10000;
    public static String nameCurrentThreadAndResult = "%s : %d\n";

    public static final int pause = 5;

    public static void main(String[] args) throws InterruptedException {
        TaskSummingNumbers firstTask = taskSummingNumbers(FROM_NUMBER_FIRST_THREAD, TO_NUMBER_FIRST_THREAD);
        TaskSummingNumbers secondTask = taskSummingNumbers(FROM_NUMBER_SECOND_THREAD, TO_NUMBER_SECOND_THREAD);
        waitingOfThreadFinished();
        int totalResult = firstTask.getResult() + secondTask.getResult();
        printThreadAndNumber(totalResult);
    }

    private static void waitingOfThreadFinished (Thread... threads) throws InterruptedException {
        for (Thread thread : threads
              ) {
            thread.join();
        }
    }


    private static TaskSummingNumbers taskSummingNumbers (int fromNumber, int toNumber) {
        TaskSummingNumbers subTask = new TaskSummingNumbers(fromNumber, toNumber);
        Thread thread = new Thread(subTask);
        thread.start();
        return subTask;
    }

    private static void printThreadAndNumber (int nubmer) {
        System.out.printf(nameCurrentThreadAndResult, Thread.currentThread().getName(), nubmer);
    }


    private static class TaskSummingNumbers implements Runnable {
        private static final int INITIAL_VALUE_RESULT_NUMBER = 0;
        private int fromNumber;
        private int toNumber;
        private int result;

        public TaskSummingNumbers (int fromNumber, int toNumber) {
            this.fromNumber = fromNumber;
            this.toNumber = toNumber;
            this.result = INITIAL_VALUE_RESULT_NUMBER;
        }

        @Override
        public void run() {
            rangeClosed(this.fromNumber,
                    this.toNumber).forEach(i -> this.result += i);
            printThreadAndNumber(this.result);
        }

        public int getResult () {
            return this.result;
        }
    }
}
