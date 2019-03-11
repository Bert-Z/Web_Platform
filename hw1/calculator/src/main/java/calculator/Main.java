package calculator;

public class Main {

    public static void main(String[] args) {

        while (true) {
            try {
                Calculate cal = new Calculate();
                cal.calculate();
            } catch (Exception e) {
                System.out.println(e);
                System.exit(-1);
            }
        }

    }
}
