package calculator;

import calculator.Calculate;
import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;


public class CalTest {
    private Calculate cal=new Calculate();

    @Test
    public void add() {
        String input="3+5;\r\n";
        String res="";
        try{
            res=cal.cal(input);
        }catch (Exception e){
            System.out.println(e);
        }

        assertEquals("=8.0",res);
    }

    @Test
    public void divide() {
        String input="5/2;\r\n";
        String res="";
        try{
            res=cal.cal(input);
        }catch (Exception e){
            System.out.println(e);
        }

        assertEquals("=2.5",res);
    }

    @Test
    public void mul() {
        String input="3*5;\r\n";
        String res="";
        try{
            res=cal.cal(input);
        }catch (Exception e){
            System.out.println(e);
        }

        assertEquals("=15.0",res);
    }

    @Test
    public void minus() {
        String input="5-8;\r\n";
        String res="";
        try{
            res=cal.cal(input);
        }catch (Exception e){
            System.out.println(e);
        }

        assertEquals("=-3.0",res);
    }

    @Test
    public void mod() {
        String input="5%8;\r\n";
        String res="";
        try{
            res=cal.cal(input);
        }catch (Exception e){
            System.out.println(e);
        }

        assertEquals("=5.0",res);
    }

    @Test
    public void factorial() {
        String input="3!;\r\n";
        String res="";
        try{
            res=cal.cal(input);
        }catch (Exception e){
            System.out.println(e);
        }

        assertEquals("=6.0",res);
    }


}
