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
            int versuche = 1;

            while (true) {
                System.out.println("Gib die untere Grenze ein (eine ganze Zahl):");
                try {
                    String eingabe = scanner.nextLine();
                    minZahl = Integer.parseInt(eingabe.trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Das war keine gültige Zahl! Versuche es noch mal.\n");
                }
            }

            while (true) {
                System.out.println("Bitte gib die obere Grenze ein (eine ganze Zahl größer als die untere Grenze):");
                try {
                    String eingabe = scanner.nextLine();
                    maxZahl = Integer.parseInt(eingabe.trim());
                    if (maxZahl <= minZahl) {
                        System.out.println("Die obere Grenze muss größer als die untere Grenze sein! Versuche es noch mal.\n");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Das war keine gültige Zahl! Versuche es noch mal.\n");
                }
            }

            int computerZahl = random.nextInt(maxZahl - minZahl + 1) + minZahl;
            System.out.println("Ich habe eine Zahl zwischen " + minZahl + " und " + maxZahl + " ausgewählt. Versuche sie zu erraten!\n");

            while (true) {

                System.out.println("\nGebe die Zahl ein und drücke die Enter-Taste\n");
                System.out.println("Versuch: " + versuche);

                int spielerZahl;
                try {
                    String eingabe = scanner.nextLine();
                    spielerZahl = Integer.parseInt(eingabe.trim());


                    if (spielerZahl < minZahl || spielerZahl > maxZahl) {
                        System.out.println("Bitte gib eine Zahl zwischen " + minZahl + " und " + maxZahl + " ein!\n");
                        continue;
                    }

                    versuche++;

                } catch (NumberFormatException e) {
                    System.out.println("Das war keine gültige Zahl! Versuche es noch mal.\n");
                    continue;
                }


                if (spielerZahl == computerZahl) {
                    break;
                } else {
                    System.out.println("Falsch! Versuch es noch mal!\n");
                }
            }

            System.out.println("Richtig! Du hast " + (versuche - 1) + " Versuche gebraucht\n");
            System.out.println("Noch mal spielen? Wenn ja, tippe 1 (und Enter), sonst egal was (und Enter).\n");

            String eingabe = scanner.nextLine();
            if (!eingabe.equals("1")) {
                break;
            }
        }

        System.out.println("Tschüss! Bis zum nächsten Mal :-)\n");
        scanner.close();
    }
}
