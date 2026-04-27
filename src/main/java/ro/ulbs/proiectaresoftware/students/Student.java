package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;


public final class Student {


    private final int numarMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;
    private final float nota;


    public Student(int numarMatricol, String prenume,
                   String nume, String formatieDeStudiu) {
        this.numarMatricol    = numarMatricol;
        this.prenume          = prenume;
        this.nume             = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota             = 0.0f;
    }


    public Student(int numarMatricol, String prenume,
                   String nume, String formatieDeStudiu, float nota) {
        this.numarMatricol    = numarMatricol;
        this.prenume          = prenume;
        this.nume             = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota             = nota;
    }


    public int    getNumarMatricol()    { return numarMatricol; }
    public String getPrenume()          { return prenume; }
    public String getNume()             { return nume; }
    public String getFormatieDeStudiu() { return formatieDeStudiu; }
    public float  getNota()             { return nota; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return Objects.equals(prenume, s.prenume)
                && Objects.equals(nume, s.nume)
                && Objects.equals(formatieDeStudiu, s.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenume, nume, formatieDeStudiu);
    }

    @Override
    public String toString() {
        return String.format("%6d %10s %12s %10s  nota: %.2f",
                numarMatricol, prenume, nume, formatieDeStudiu, nota);
    }
}