package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class Student {
    private int numarMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public int getNumarMatricol() { return numarMatricol; }
    public String getPrenume()    { return prenume; }
    public String getNume()       { return nume; }
    public String getFormatieDeStudiu() { return formatieDeStudiu; }


    public String toString() {
        return String.format("%15d %10s %10s %10s",
                numarMatricol, prenume, nume, formatieDeStudiu);
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return Objects.equals(prenume, s.prenume)
                && Objects.equals(nume, s.nume)
                && Objects.equals(formatieDeStudiu, s.formatieDeStudiu);
    }


    public int hashCode() {
        return Objects.hash(prenume, nume, formatieDeStudiu);
    }
}