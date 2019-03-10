package calculator;

public class Token {
    public char kind;
    public double value;

    Token(char ch) {
        this.kind = ch;
        this.value = 0;
    }

    Token(char ch, double val) {
        this.kind = ch;
        this.value = val;
    }
}
