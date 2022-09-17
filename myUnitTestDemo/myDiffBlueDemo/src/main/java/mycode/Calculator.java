package mycode;

public class Calculator {

    public static int greaterThan(int a, int b) {
        if (a < b)
            return a + b;
        else if (a >= b && b != 0)
            return a / b;
        else
            return a;
    }

}