package de.bbq.zahlenraten;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            int minZahl = 0;
            int maxZahl = 0;
            while (true) {
                System.out.println("Gib die untere Grenze ein (eine ganze Zahl):");
                try {
                    String eingabe = scanner.nextLine();
                    minZahl = Integer.parseInt(eingabe.trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Das war keine gültige Zahl! Versuche es noch mal.");
                }
            }

            while (true) {
                System.out.println("Bitte gib die obere Grenze ein (eine ganze Zahl größer als die untere Grenze):");
                try {
                    String eingabe = scanner.nextLine();
                    maxZahl = Integer.parseInt(eingabe.trim());
                    if (maxZahl <= minZahl) {
                        System.out.println("Die obere Grenze muss größer als die untere Grenze sein! Versuche es noch mal.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Das war keine gültige Zahl! Versuche es noch mal.");
                }
            }

            int computerZahl = random.nextInt(11);
            System.out.println("Ich habe eine Zahl zwischen 0 und 10 ausgedacht. Rate sie!\n");


            while (true) {

                System.out.println("Gebe die Zahl ein und drücke die Enter-Taste");

                int spielerZahl;
                try {
                    String eingabe = scanner.nextLine();
                    spielerZahl = Integer.parseInt(eingabe.trim());


                    if (spielerZahl < 0 || spielerZahl > 10) {
                        System.out.println("Bitte gib eine Zahl zwischen 0 und 10 ein!");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Das war keine gültige Zahl! Versuche es noch mal.");
                    continue;
                }


                if (spielerZahl == computerZahl) {
                    break;
                } else {
                    System.out.println("Falsch! Versuch es noch mal!");
                }
            }

            System.out.println("Richtig!");
            System.out.println("Noch mal spielen? Wenn ja, tippe 1 (und Enter), sonst egal was (und Enter).");

            String eingabe = scanner.nextLine();
            if (!eingabe.equals("1")) {
                break;
            }
        }

        System.out.println("Tschüss! Bis zum nächsten Mal :-)");
        scanner.close();
    }
}
