package ro.ulbs.proiectaresoftware.lab4;

import java.util.*;

public class AppLab4 {

    public static void main(String[] args) {


        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan",    21);
        varste.put("Maria",   22);
        varste.put("Victor",  20);
        varste.put("Simina",  20);
        varste.put("Marius",  21);
        varste.put("Mihai",   21);
        varste.put("Daniela", 23);

        Map<String, String> adrese = Map.of(
                "Ioan",    "Sibiu",
                "Maria",   "Bucuresti",
                "Victor",  "Cluj",
                "Simina",  "Alba-Iulia",
                "Marius",  "Medias",
                "Mihai",   "Cisnadie",
                "Daniela", "Sibiu"
        );

        // ── a)
        System.out.println("=== a) Varste initiale ===");
        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        varste.put("Vlad",  19);
        varste.put("Iulia", 19);

        System.out.println("\nDupa adaugare Vlad si Iulia:");
        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // ── c)
        HashMap<String, Tanar> tineri = new HashMap<>();

        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            String nume    = entry.getKey();
            int varsta     = entry.getValue();
            // adresa din map-ul adrese, daca nu exista -> "Necunoscuta"
            String adresa  = adrese.getOrDefault(nume, "Necunoscuta");

            tineri.put(nume, new Tanar(nume, varsta, adresa));
        }

        // ── d)
        System.out.println("\n=== d) Continut tineri ===");
        for (Map.Entry<String, Tanar> entry : tineri.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}