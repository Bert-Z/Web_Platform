package calculator;

public class Calculate {
    public static final char NUMBER = '8';
    public static final char PRINT = ';';
    public static final char QUIT = 'q';
    public static final char PROMPT = '>';
    public static final char RESULT = '=';

    private TokenStream ts;

    public double ansvalue = 0;

    private int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

//    private double basic(){
//
//    }

}
