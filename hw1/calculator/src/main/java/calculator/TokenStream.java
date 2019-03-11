package calculator;

import java.io.*;
import java.util.Scanner;
import java.io.PushbackInputStream;
import java.io.ByteArrayInputStream;

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

    //unfinished
    public Token get() {
        if (this.full) {
            this.full = false;
            return buffer;
        }

        char ch = 'a';
        Scanner scan = new Scanner(System.in);

        Token a = new Token(ch);
        return a;
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
//    }

}
