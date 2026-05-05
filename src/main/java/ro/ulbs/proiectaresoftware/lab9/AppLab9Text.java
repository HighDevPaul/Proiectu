package ro.ulbs.proiectaresoftware.lab9;

import java.util.*;
import java.util.stream.*;

public class AppLab9Text {

    public static void main(String[] args) {

        String text = "Acesta este un program scris in java pentru expresii lambda";


        List<String> cuvinte = Arrays.asList(text.split(" "));
        System.out.println("Lista cuvinte: " + cuvinte);


        List<String> cuvinteLungi = cuvinte.stream()
                .filter(c -> c.length() >= 5)
                .collect(Collectors.toList());

        long numar = cuvinteLungi.stream().count();
        System.out.println("\na) Cuvinte cu lungime >= 5 (" + numar + "): "
                + cuvinteLungi);


        List<String> sortata = cuvinteLungi.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("b) Sortata: " + sortata);


        Optional<String> cuP = cuvinte.stream()
                .filter(c -> c.startsWith("p"))
                .findFirst();

        if (cuP.isPresent()) {
            System.out.println("c) Primul cuvant cu 'p': " + cuP.get());
        } else {
            System.out.println("c) Nu s-a gasit niciun cuvant cu 'p'");
        }
    }
}