package ro.ulbs.proiectaresoftware.lab9;

import java.util.*;
import java.util.stream.*;

public class AppLab9 {

    public static void main(String[] args) {


        Random random = new Random();
        List<Integer> numere = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21))  // [5..25]
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista initiala: " + numere);


        int suma = numere.stream()
                .reduce(0, Integer::sum);
        System.out.println("\na) Suma: " + suma);


        int max = numere.stream()
                .max(Comparator.naturalOrder())
                .get();
        int min = numere.stream()
                .min(Comparator.naturalOrder())
                .get();
        System.out.println("b) Max: " + max + "  Min: " + min);


        List<Integer> filtrata = numere.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("c) Elemente in [10..20]: " + filtrata);


        List<Double> listaDouble = numere.stream()
                .map(n -> n.doubleValue())
                .collect(Collectors.toList());
        System.out.println("d) Lista Double: " + listaDouble);


        boolean contine12 = numere.stream()
                .anyMatch(n -> n == 12);
        System.out.println("e) Contine valoarea 12: " + contine12);
    }
}
