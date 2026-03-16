package ro.ulbs.proiectaresoftware.lab1;

public class Application {

    public static void main(String[] args) {

        //b
        String alphabet = "";
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet += c;
        }
        System.out.println("Litere mici:  " + alphabet);
        System.out.println("Litere mari:  " + alphabet.toUpperCase());
        //c
        String vowels = "aeiou";


        int[] vowelPositions = new int[5];
        int idx = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            if (vowels.indexOf(alphabet.charAt(i)) != -1) {
                vowelPositions[idx++] = i;
            }
        }


        String[] segments = new String[5];
        for (int i = 0; i < vowelPositions.length; i++) {
            int start = vowelPositions[i];
            int end = (i + 1 < vowelPositions.length) ? vowelPositions[i + 1] : alphabet.length();
            segments[i] = alphabet.substring(start, end);
        }


        System.out.println("\nSegmente alfabetice:");
        for (int i = 0; i < segments.length; i++) {
            System.out.println("array[" + i + "] = \"" + segments[i] + "\"");
        }
    }
}
