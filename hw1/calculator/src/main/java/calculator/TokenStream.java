package calculator;

import java.util.Scanner;

public class TokenStream {
    public boolean full;
    public Token buffer;

    // Token buffer set null as default
    TokenStream() {
        this.full = false;
    }

    public void putback(Token t) {
        this.buffer = t;
        full = true;
    }

    public Token get() {
        if (this.full) {
            this.full = false;
            return buffer;
        }

        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        char ch = str.charAt(0);


        switch (ch){
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
            case '9':
            {
                double val;
                val=Double.parseDouble(str);
                return new Token(Calculate.NUMBER, val);
            }
            default:{
                throw new RuntimeException("Bad token");
            }
        }

    }

//    public static void main(String[] args) {
//        try {
//        Scanner scan = new Scanner(System.in);
//        System.out.println(scan.next());
//        String a = scan.next();
//        if (a == "qa") {
//            System.out.println(a);
//            System.exit(1);
//        }
//
//        System.out.println('a');
//        System.exit(2);
//                throw new RuntimeException("')'excepted");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        System.out.println(Calculate.NUMBER);
//    }

}
