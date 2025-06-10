package de.bbq.zahlenraten;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Willkommen zum Zahlenraten-Spiel!\n");
        System.out.println("Spieler 1, bitte gib deinen Namen ein: ");
        String player1Name = scanner.nextLine().trim();
        System.out.println("Spieler 2, bitte gib deinen Namen ein: ");
        String player2Name = scanner.nextLine().trim();

        String currentGuesser = player2Name;
        String currentChooser = player1Name;

        while (true) {
            int minNumber;
            int maxNumber;

            while (true) {
                System.out.println("Bitte gebt die untere Grenze des Zahlenbereichs ein (ganze Zahl):");
                try {
                    String eingabe = scanner.nextLine();
                    minNumber = Integer.parseInt(eingabe.trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Das war keine gültige Zahl! Versuche es noch mal.\n");
                }
            }

            while (true) {
                System.out.println("Bitte gebt die obere Grenze des Zahlenbereichs ein (eine ganze Zahl größer als die untere Grenze):");
                try {
                    String eingabe = scanner.nextLine();
                    maxNumber = Integer.parseInt(eingabe.trim());
                    if (maxNumber <= minNumber) {
                        System.out.println("Die obere Grenze muss größer als die untere Grenze sein! Versuche es noch mal.\n");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Das war keine gültige Zahl! Versuche es noch mal.\n");
                }
            }

            int secretNumber = 0;
            while (true) {
                System.out.println(currentChooser + ", bitte denke an eine Zahl zwischen " + minNumber + " und " + maxNumber + " (inklusive) und drücke Enter, wenn du bereit bist.");
                System.out.println("Gib deine Zahl ein (keine Sorge, " + currentGuesser + " wird sie nicht sehen):");
                try {
                    String eingabe = scanner.nextLine();
                    secretNumber = Integer.parseInt(eingabe.trim());
                    if (secretNumber < minNumber || secretNumber > maxNumber) {
                        System.out.println("Die Zahl muss zwischen " + minNumber + " und " + maxNumber + " liegen! Versuche es noch mal.\n");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Das war keine gültige Zahl! Versuche es noch mal.\n");
                }
            }

            while (true) {

                System.out.println("\nGebe die Zahl ein und drücke die Enter-Taste\n");

                int spielerZahl;
                try {
                    String eingabe = scanner.nextLine();
                    spielerZahl = Integer.parseInt(eingabe.trim());


                    if (spielerZahl < minNumber || spielerZahl > maxNumber) {
                        System.out.println("Bitte gib eine Zahl zwischen " + minNumber + " und " + maxNumber + " ein!\n");
                        continue;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Das war keine gültige Zahl! Versuche es noch mal.\n");
                    continue;
                }


                if (spielerZahl == secretNumber) {
                    break;
                } else {
                    System.out.println("Falsch! Versuch es noch mal!\n");
                }
            }


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
