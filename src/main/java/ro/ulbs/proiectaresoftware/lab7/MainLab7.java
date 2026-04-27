package ro.ulbs.proiectaresoftware.lab7;

import ro.ulbs.proiectaresoftware.students.Student;

import java.util.*;

public class MainLab7 {

    public static void main(String[] args) {


        Set<Student> studenti = new HashSet<>();
        studenti.add(new Student(1024, "Ioan",     "Mihalcea", "ISM141/1"));
        studenti.add(new Student(1025, "Andrei",   "Popa",     "ISM141/2"));
        studenti.add(new Student(1026, "Anamaria", "Prodan",   "TI131/1"));
        studenti.add(new Student(1027, "Paul",     "Mohanu",   "TI132/1"));
        studenti.add(new Student(1028, "Mihai",    "Ionescu",  "TI132/2"));

        System.out.println("=== Studenti initiala ===");
        for (Student s : studenti) System.out.println(s);


        studenti = imparteInDouaFormatii(studenti, "TI211_1", "TI211_2");

        System.out.println("\n=== Dupa impartire in doua formatii ===");
        for (Student s : studenti) System.out.println(s);
    }



    static Set<Student> imparteInDouaFormatii(Set<Student> studenti,
                                              String formatia1,
                                              String formatia2) {
        Set<Student> rezultat = new HashSet<>();
        List<Student> lista   = new ArrayList<>(studenti);

        int jumatate = (lista.size() + 1) / 2;

        for (int i = 0; i < lista.size(); i++) {
            String formatie = (i < jumatate) ? formatia1 : formatia2;

            rezultat.add(schimbaFormatia(lista.get(i), formatie));
        }
        return rezultat;
    }


    static Student schimbaFormatia(Student st, String nouaFormatieDeStudiu) {
        return new Student(
                st.getNumarMatricol(),
                st.getPrenume(),
                st.getNume(),
                nouaFormatieDeStudiu,  // ← singura schimbare
                st.getNota()
        );
    }
}