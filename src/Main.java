import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("                                     # #  ( )");
        System.out.println("                                  ___#_#___|__");
        System.out.println("                              _  |____________|  _");
        System.out.println("                       _=====| | |            | | |==== _");
        System.out.println("                 =====| |.---------------------------. | |====");
        System.out.println("   <--------------------'   .  .  .  .  .  .  .  .   '--------------/");
        System.out.println("     \\                                                             /");
        System.out.println("      \\___________________________________________________________/");
        System.out.println("  wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        System.out.println();
        System.out.println("Willkommen bei Schiffe-Versenken!");
        System.out.println();
        System.out.print("Spiel mit ENTER beginnen oder die Regeln mit [R] anzeigen lassen > ");
        String s = scan.nextLine();
        while (true) {
            if (s.length() == 0) {
                break;
            } else if (s.toUpperCase().equals("R")) {
                Display.clear(0);
                System.out.print("Regeln:");
                System.out.println();
                System.out.println("- Ziel des Spiels ist es, die durch Felder in einem 10x10-Raster dargestellten Schiffe des Gegners zu versenken - bevor er die eigenen Schiffe versenkt hat.");
                System.out.println("- Die beiden Spieler sind immer abwechselnd am Zug: Spieler 1 sollte also nicht zuschauen, wenn Spieler 2 seine Schiffe auf dem Feld platziert.");
                System.out.println("- Um ein Schiff zu platzieren muss man die Orientation (horizontal, vertikal) und den Startpunkt angeben. Das Feld ist von links nach rechts mit den Zahlen von 1-100 durchnummeriert. Der Startpunkt ist immer der oberste (vertikal) oder der" + '\u00e4' + "ußerst linke Punkt (horizontal).");
                System.out.println("- Schiffe k" + '\u00f6' + "nnen nicht direkt nebeneinander platziert werden.");
                System.out.println("- In jedem Spielzug kann man das eigene und gegnerische Spielfeld sehen. Angegriffene Felder ohne Schiff werden mit einem Punkt markiert, Treffer mit einem X. Wenn ein Schiff ganz gesunken ist, wird es dem Spieler angezeigt und durch eine Linie markiert.");
                break;
            } else {
                System.out.print("Bitte entweder ENTER oder 'R' eingeben! > ");
                s = scan.nextLine();
            }

        }

        // Spieler werden erstellt
        System.out.println();
        System.out.print("Wie soll Spieler 1 hei" + '\u00df' + "en? > ");
        Spieler spieler1 = new Spieler(scan.next());
        while (spieler1.name.equals("")) {
            System.out.println("Die Eingabe ist ung" + '\u00fc'
                    + "ltig, weil sie leer ist. Der Spieler muss einen Namen zugewiesen bekommen.");
            System.out.print("Wie soll Spieler 1 hei" + '\u00df' + "en? > ");
            spieler1.name = scan.next();
            if (!spieler1.name.equals("")) {
                break;
            }
        }
        System.out.print("Wie soll Spieler 2 hei" + '\u00df' + "en? > ");
        Spieler spieler2 = new Spieler(scan.next());
        while (spieler2.name.equals("") || spieler2.name.equals(spieler1.name)) {
            System.out.println("Die Eingabe ist ung" + '\u00fc'
                    + "ltig, weil sie leer oder der Name schon vergeben ist. Der Spieler muss einen Namen zugewiesen bekommen.");
            System.out.print("Wie soll Spieler 2 hei" + '\u00df' + "en? > ");
            spieler2.name = scan.next();
            if (!spieler2.name.equals("") && !spieler2.name.equals(spieler1.name)) {
                break;
            }
        }

        Display.clear(2);

        System.out.println(spieler1.name + " beginnt damit, seine/ihre Schiffe zu platzieren!" + '\n');
        spieler1.feld.ausgeben();
        spieler1.feld.schiffPlatzieren(spieler1.schiff1);
        spieler1.feld.ausgeben();
        spieler1.feld.schiffPlatzieren(spieler1.schiff2);
        spieler1.feld.ausgeben();
        spieler1.feld.schiffPlatzieren(spieler1.schiff3);
        spieler1.feld.ausgeben();
        spieler1.feld.schiffPlatzieren(spieler1.schiff4);
        spieler1.feld.ausgeben();
        spieler1.feld.schiffPlatzieren(spieler1.schiff5);
        spieler1.feld.ausgeben();
        System.out.println();
        System.out.println("So sieht das Feld jetzt aus!");
        Display.clear(3);

        System.out.println("Jetzt ist " + spieler2.name + " mit dem Platzieren seiner/ihrer Schiffe dran." + '\n');
        spieler2.feld.ausgeben();
        spieler2.feld.schiffPlatzieren(spieler2.schiff1);
        spieler2.feld.ausgeben();
        spieler2.feld.schiffPlatzieren(spieler2.schiff2);
        spieler2.feld.ausgeben();
        spieler2.feld.schiffPlatzieren(spieler2.schiff3);
        spieler2.feld.ausgeben();
        spieler2.feld.schiffPlatzieren(spieler2.schiff4);
        spieler2.feld.ausgeben();
        spieler2.feld.schiffPlatzieren(spieler2.schiff5);
        spieler2.feld.ausgeben();
        System.out.println();
        System.out.println("So sieht das Feld jetzt aus!");
        Display.clear(3);

        boolean spielLaeuft = true;
        int b;

        while (spielLaeuft) {

            // Spieler 1 am Zug
            System.out.println("--- " + spieler1.name + " ist am Zug! ---");
            System.out.println();
            System.out.println("\tEigenes Spielfeld:");
            spieler1.feld.ausgeben();
            System.out.println();
            System.out.println("\tGegnerisches Spielfeld:");
            spieler2.feld.verdecktAusgeben();
            System.out.println();
            System.out.print("Welches Feld soll beschossen werden? > ");
            b = scan.nextInt() - 1;
            while (spieler2.feld.sichtbareGetroffeneFelder.contains(b)
                    || spieler2.feld.sichtbareLeereFelder.contains(b)) {
                System.out.println("Dieses Feld hast du schon attackiert!");
                System.out.print("Welches Feld soll beschossen werden? > ");
                b = scan.nextInt() - 1;
                if (!spieler2.feld.sichtbareGetroffeneFelder.contains(b)
                        && !spieler2.feld.sichtbareLeereFelder.contains(b)) {
                    break;
                }
            }
            if (spieler2.feld.angreifen(b)) {
                System.out.println("Treffer!");
                spieler2.feld.sichtbareGetroffeneFelder.add(b);
            } else {
                System.out.println("Hier ist leider nichts.");
                spieler2.feld.sichtbareLeereFelder.add(b);
            }
            System.out.print("Versunkene gegnerische Schiffe: ");
            spieler2.feld.istVersunken(spieler2.schiff1);
            spieler2.feld.istVersunken(spieler2.schiff2);
            spieler2.feld.istVersunken(spieler2.schiff3);
            spieler2.feld.istVersunken(spieler2.schiff4);
            spieler2.feld.istVersunken(spieler2.schiff5);
            System.out.print(Arrays.toString(spieler2.versunkeneSchiffe.toArray()).replace("[", "").replace("]", ""));
            if (spieler2.versunkeneSchiffe.isEmpty()) {
                System.out.print("keine");
            }

            if (spieler2.schiff1.versunken && spieler2.schiff2.versunken && spieler2.schiff3.versunken
                    && spieler2.schiff4.versunken && spieler2.schiff5.versunken) {
                System.out.println(spieler1.name + " hat gewonnen!");
                spielLaeuft = false;
                break;
            }

            Display.clear(3);

            // Spieler 2 am Zug
            System.out.println("--- " + spieler2.name + " ist am Zug! ---");
            System.out.println();
            System.out.println("\tEigenes Spielfeld:");
            spieler2.feld.ausgeben();
            System.out.println();
            System.out.println("\tGegnerisches Spielfeld:");
            spieler1.feld.verdecktAusgeben();
            System.out.println();
            System.out.print("Welches Feld soll beschossen werden? > ");
            b = scan.nextInt() - 1;
            while (spieler1.feld.sichtbareGetroffeneFelder.contains(b)
                    || spieler1.feld.sichtbareLeereFelder.contains(b)) {
                System.out.println("Dieses Feld hast du schon attackiert!");
                System.out.print("Welches Feld soll beschossen werden? > ");
                b = scan.nextInt() - 1;
                if (!spieler1.feld.sichtbareGetroffeneFelder.contains(b)
                        && !spieler1.feld.sichtbareLeereFelder.contains(b)) {
                    break;
                }
            }
            if (spieler1.feld.angreifen(b)) {
                System.out.println("Treffer!");
                spieler1.feld.sichtbareGetroffeneFelder.add(b);
            } else {
                System.out.println("Hier ist leider nichts.");
                spieler1.feld.sichtbareLeereFelder.add(b);
            }

            System.out.print("Versunkene gegnerische Schiffe: ");
            spieler1.feld.istVersunken(spieler1.schiff1);
            spieler1.feld.istVersunken(spieler1.schiff2);
            spieler1.feld.istVersunken(spieler1.schiff3);
            spieler1.feld.istVersunken(spieler1.schiff4);
            spieler1.feld.istVersunken(spieler1.schiff5);
            System.out.print(Arrays.toString(spieler1.versunkeneSchiffe.toArray()).replace("[", "").replace("]", ""));
            if (spieler1.versunkeneSchiffe.isEmpty()) {
                System.out.print("keine");
            }

            if (spieler1.schiff1.versunken && spieler1.schiff2.versunken && spieler1.schiff3.versunken
                    && spieler1.schiff4.versunken && spieler1.schiff5.versunken) {
                System.out.println(spieler1.name + " hat gewonnen und alle gegnerischen Schiffe gesunken!");
                spielLaeuft = false;
                break;
            }

            Display.clear(3);
        }
        scan.close();
    }
}
