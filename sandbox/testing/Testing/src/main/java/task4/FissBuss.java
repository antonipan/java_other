package lesson3;

public class FissBuss {

    public String fizzBuss(int num) {

        if (num % 15 == 0) {
            return "FizzBuss";
        } else if (num % 5 == 0) {
            return "Buss";
        } else if (num % 3 == 0) {
            return "Fizz";
        }
        return String.valueOf(num);
    }


}
