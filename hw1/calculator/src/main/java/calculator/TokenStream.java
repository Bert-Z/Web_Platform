package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TokenStream {
    public boolean full;
    public Token buffer;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Token buffer set null as default
    TokenStream() {
        this.full = false;
    }

    public void putback(Token t) {
        this.buffer = t;
        full = true;
    }

    public Token get() throws IOException {
        if (this.full) {
            this.full = false;
            return buffer;
        }

        char ch = (char) (br.read());

        switch (ch) {
            case Calculate.PRINT:
            case Calculate.QUIT:
            case '(':
            case ')':
            case '+':
            case '-':
            case '*':
            case '%':
            case '/':
            case '!':
                return new Token(ch);
            case '.':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9': {
                String sval = ch + "";
                ch = (char) (br.read());
                while (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9' || ch == '.') {

                    sval += ch;
                    br.mark(1000);
                    ch = (char) (br.read());
                }
                br.reset();
                double val;
                val = Double.parseDouble(sval);
                return new Token(Calculate.NUMBER, val);
            }
            default: {
                throw new RuntimeException("Bad token");
            }
        }

    }

}
