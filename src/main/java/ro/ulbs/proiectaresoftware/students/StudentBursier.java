package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class StudentBursier extends Student {

    private double cuantumBursa;


    public StudentBursier(int numarMatricol, String prenume,
                          String nume, String formatieDeStudiu,
                          double nota, double cuantumBursa) {



        super(numarMatricol, prenume, nume, formatieDeStudiu);
        this.setNota((float) nota);
        this.cuantumBursa = cuantumBursa;
    }

    public double getCuantumBursa() {
        return cuantumBursa;
    }


    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        StudentBursier sb = (StudentBursier) o;
        return Double.compare(cuantumBursa, sb.cuantumBursa) == 0;
    }


    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }


    public String toString() {
        return super.toString()
                + String.format("  bursa: %.2f lei", cuantumBursa);
    }
}