package ro.ulbs.proiectaresoftware.lab5;

public class AdvancedCalculator extends IntCalculator {


    public AdvancedCalculator(int initialValue) {
        super(initialValue);
    }


    public AdvancedCalculator divide(int value) {
        this.state /= value;
        return this;
    }

    public AdvancedCalculator power(int exponent) {
        this.state = (int) Math.pow(this.state, exponent);
        return this;
    }

    public AdvancedCalculator root(int n) {
        this.state = (int) Math.pow(this.state, 1.0 / n);
        return this;
    }


    public AdvancedCalculator add(int value) {
        this.state += value;
        return this;
    }


    public AdvancedCalculator subtract(int value) {
        this.state -= value;
        return this;
    }


    public AdvancedCalculator multiply(int value) {
        this.state *= value;
        return this;
    }
}