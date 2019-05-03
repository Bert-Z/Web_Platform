package top.bertz.calculator;

import java.io.*;

public class TokenStream {
    public boolean full;
    public Token buffer;
    private BufferedReader br;
    public static double ansvalue = 0;

    // Token buffer set null as default
    TokenStream(String input) {
        this.full = false;
        InputStream is=new ByteArrayInputStream(input.getBytes());
        br= new BufferedReader(new InputStreamReader(is));
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
                br.mark(1000);
                ch = (char) (br.read());
                while ((ch >= '0' && ch <= '9') || ch == '.') {

                    sval += ch;
                    br.mark(1000);
                    ch = (char) (br.read());
                }
                br.reset(); // return to the mark position
                double val;
                val = Double.parseDouble(sval);
                return new Token(Calculate.NUMBER, val);
            }
            case 'A': {
                char n = (char) br.read();
                char s = (char) br.read();
                if (n == 'N' && s == 'S') {
                    return new Token(Calculate.NUMBER, ansvalue);
                }
            }
            default: {
                throw new RuntimeException("Bad token");
            }
        }

    }

}
