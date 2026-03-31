package ro.ulbs.proiectaresoftware.lab5;

public class AppLab5 {

    public static void main(String[] args) {


        IntCalculator calculator = new IntCalculator(10);
        int result = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("a) (10 + 5 - 3) * 2 = " + result); // 24


        AdvancedCalculator advancedCalculator = new AdvancedCalculator(10);
        int result2 = advancedCalculator.divide(4).power(2).root(2).result();
        System.out.println("b) (10 / 4)^2 radical 2 = " + result2); // 2
    }
}
