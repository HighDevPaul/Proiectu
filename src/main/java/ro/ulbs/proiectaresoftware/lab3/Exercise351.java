package ro.ulbs.proiectaresoftware.lab3;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Exercise351 {
    public  static void main(String[] args) throws IOException{
        List<String> lines=Files.readAllLines(Path.of("C:\\Users\\Paul\\IdeaProjects\\Proiectu\\src\\main\\java\\ro\\ulbs\\proiectaresoftware\\lab3\\in.txt"));
        //-a)
        System.out.println("A) Linia noua la sfarsit de linie");
        StringBuilder resultA=new StringBuilder();
        for(String line:lines){
            String modified=line+"\n";
            resultA.append(modified);
            System.out.print(modified);

        }
        //b)
        System.out.println("\n B) Linie noua la sfarsit de linie");
        StringBuilder resultB=new StringBuilder();
        for(String line :lines){
            String modifed=line.replace(".",".\n");
            resultB.append(modifed).append("\n");
            System.out.println(modifed);
        }
        //c) Fisieru out.txt
        StringBuilder outContent=new StringBuilder();
        outContent.append("A) linie noua la sfarsit de linie\n");
        outContent.append(resultA);
        outContent.append("B) linie noua la sfarsit de linie\n");
        outContent.append( resultB);
        Files.writeString(Path.of("C:\\Users\\Paul\\IdeaProjects\\Proiectu\\src\\main\\java\\ro\\ulbs\\proiectaresoftware\\lab3\\out.txt"),outContent.toString());
        System.out.println("\n Speram ca functioneaza ");



    }

}
