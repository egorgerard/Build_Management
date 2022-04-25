package de.hfu;
import java.util.Scanner;

public class small_to_big {

    public static void main(String[] args) {
        
        System.out.println("Geben Sie einen String ein.");

        Scanner scanner = new Scanner(System.in);
        String eingabe = scanner.next();

        System.out.println("Alte eingabe: "+ eingabe);

        eingabe = eingabe.toUpperCase();

        System.out.println("Neue eingabe: "+ eingabe);

    }
}


