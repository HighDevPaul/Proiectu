package ro.ulbs.proiectaresoftware.lab5.advance;

public class Lab5Adv {

    public static void main(String[] args) {

        // ── a) NewIntCalculator: (10 + 5 - 3) * 2 ────────────────────────
        NewIntCalculator calculator = new NewIntCalculator(10);
        int result = (Integer) calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("5.5.2 a) (10 + 5 - 3) * 2 = " + result); // 24

        // ── b) DoubleCalculator: (10 + 5 - 3.3) * 2.2 ───────────────────
        DoubleCalculator fCalculator = new DoubleCalculator(10);
        double result2 = (Double) fCalculator.add(5).subtract(3.3).multiply(2.2).result();
        System.out.println("5.5.2 b) (10 + 5 - 3.3) * 2.2 = " + result2); // 25.74
    }
}
