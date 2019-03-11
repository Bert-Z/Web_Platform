package calculator;

import java.io.IOException;
import java.util.Scanner;

public class Calculate {
    public static final char NUMBER = '8';
    public static final char PRINT = ';';
    public static final char QUIT = 'q';
    public static final char PROMPT = '>';
    public static final char RESULT = '=';

    private TokenStream ts;

    private int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    private double basic() throws IOException {
        Token t = ts.get();
        switch (t.kind) {
            case ('('): {
                double d = expression();
                t = ts.get();
                if (t.kind != ')') {
                    throw new RuntimeException("')'excepted");
                }

                return d;
            }
            case NUMBER:
                return t.value;
            default:
                throw new RuntimeException("basic expected");
        }
    }

    private double primary() throws IOException {
        double left = basic();
        Token t = ts.get();
        if (t.kind == '!') {
            if ((int) (left) == left && left >= 0) {
                return factorial((int) left);
            } else {
                throw new RuntimeException("error");
            }

        } else {
            ts.putback(t);
        }

        return left;
    }


    private double mid() throws IOException {
        Token t = ts.get();
        switch (t.kind) {
            case '-':
                return -mid();
            case '+':
                return +mid();
            default:
                ts.putback(t);
                return primary();
        }
    }


    private double term() throws IOException {
        double left = mid();
        Token t = ts.get();

        while (true) {
            switch (t.kind) {
                case '*': {
                    left *= mid();
                    t = ts.get();
                    break;
                }
                case '/': {
                    double d = mid();
                    if (d == 0)
                        throw new RuntimeException("divide by zero");
                    left /= d;
                    t = ts.get();
                    break;
                }
                case '%': {
                    double d = mid();
                    int i1 = (int) left;
                    if (i1 != left)
                        throw new RuntimeException("error");
                    int i2 = (int) d;
                    if (i2 != d)
                        throw new RuntimeException("error");
                    if (d == 0)
                        throw new RuntimeException("%:divided by zero");
                    left = i1 % i2;
                    t = ts.get();
                    break;
                }
                default: {
                    ts.putback(t);
                    return left;
                }
            }
        }
    }


    private double expression() throws IOException {
        double left = term();
        Token t = ts.get();

        while (true) {
            switch (t.kind) {
                case '+': {
                    left += term();
                    t = ts.get();
                    break;
                }
                case '-': {
                    left -= term();
                    t = ts.get();
                    break;
                }
                default: {
                    ts.putback(t);
                    return left;
                }
            }
        }
    }

    public String setInput(){
        System.out.print(PROMPT);
        Scanner scanner= new Scanner(System.in);
        return scanner.next();
    }

    public void calculate(String input) throws IOException {
        ts = new TokenStream(input);
        Token t = ts.get();

        while (t.kind == PRINT)
            t = ts.get();

        if (t.kind == QUIT) {
            System.exit(0);
        }
        ts.putback(t);
        double ans = expression();

        System.out.println(RESULT + String.valueOf(ans));

        ts.ansvalue = ans;
    }

    // write for test
    public String cal(String input) throws IOException {
        ts = new TokenStream(input);
        Token t = ts.get();

        while (t.kind == PRINT)
            t = ts.get();

        if (t.kind == QUIT) {
            System.exit(0);
        }
        ts.putback(t);
        double ans = expression();

        return (RESULT + String.valueOf(ans));

    }


}
