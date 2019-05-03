package top.bertz.calculator;

public class Main {

    public static void main(String[] args) {

        while (true) {
            try {
                Calculate cal = new Calculate();
                String input=cal.setInput();
                cal.calculate(input);
            } catch (Exception e) {
                System.out.println(e);
                System.exit(-1);
            }
        }

    }
}
