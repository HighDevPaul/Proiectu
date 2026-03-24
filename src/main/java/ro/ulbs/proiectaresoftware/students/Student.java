package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class Student {
    private int numarMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;
    private float nota;  // ← câmp nou

    public Student(int numarMatricol, String prenume,
                   String nume, String formatieDeStudiu) {
        this.numarMatricol    = numarMatricol;
        this.prenume          = prenume;
        this.nume             = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota             = 0.0f;
    }


    public int    getNumarMatricol()    { return numarMatricol; }
    public String getPrenume()          { return prenume; }
    public String getNume()             { return nume; }
    public String getFormatieDeStudiu() { return formatieDeStudiu; }
    public float  getNota()             { return nota; }


    public void setNota(float nota)     { this.nota = nota; }



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

    // ── toString cu nota inclusa ──────────────────────────────────────────

    public String toString() {
        return String.format("%6d %10s %12s %10s  nota: %.2f",
                numarMatricol, prenume, nume, formatieDeStudiu, nota);
    }
}