package calculator;

public class TokenStream {
    public boolean full;
    public Token buffer;

    // Token buffer set null as default
    TokenStream() {
        this.full = false;
    }

    public void pushback(Token t) {
        this.buffer = t;
        full = true;
    }

//    public Token get() {
//        if (this.full) {
//            this.full = false;
//            return buffer;
//        }
//
//
//
//    }
}
