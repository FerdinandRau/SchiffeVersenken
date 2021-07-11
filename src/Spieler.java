import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Spieler {

    String name;
    Scanner scan = new Scanner(System.in);
    LinkedList<String> versunkeneSchiffe = new LinkedList<String>();

    Spieler(String n) {
        name = n;
    }

    class Schiff {
        int startposition;
        int laenge;
        boolean vertikal;
        String name;
        boolean versunken = false;

        Schiff(int p, int l, boolean v, String n) {
            startposition = p;
            laenge = l;
            vertikal = v;
            name = n;
        }
    }

    class Spielfeld {
        char[] raster = new char[100];
        char[] verdecktesRaster = new char[100];
        boolean moeglich = true;
        LinkedList<Integer> sichtbareGetroffeneFelder = new LinkedList<Integer>();
        LinkedList<Integer> sichtbareLeereFelder = new LinkedList<Integer>();

        Spielfeld() {
            Arrays.fill(raster, '~');
        }

        public boolean angreifen(int f) {
            if (raster[f] == 'x' || raster[f] == 'o') {
                raster[f] = '~';
                return true;
            } else {
                return false;
            }
        }

        public void verdecktAusgeben() {
            int num = 1;
            System.out.print(num + "\t");
            for (int i = 0; i < raster.length; i++) {
                if (sichtbareGetroffeneFelder.contains(i)) {
                    verdecktesRaster[i] = 'X';
                } else if (sichtbareLeereFelder.contains(i)) {
                    verdecktesRaster[i] = '.';
                } else {
                    verdecktesRaster[i] = '~';
                }
                if (schiff1.versunken) {
                    if (schiff1.vertikal) {
                        verdecktesRaster[schiff1.startposition] = '-';
                        for (int a = (schiff1.laenge - 1); a > 0; a--) {
                            verdecktesRaster[schiff1.startposition + a * 10] = '-';
                        }
                    } else {
                        verdecktesRaster[schiff1.startposition] = '-';
                        for (int j = (schiff1.laenge - 1); j > 0; j--) {
                            verdecktesRaster[schiff1.startposition + j] = '-';
                        }
                    }
                } else if (schiff2.versunken) {
                    if (schiff2.vertikal) {
                        verdecktesRaster[schiff2.startposition] = '-';
                        for (int a = (schiff2.laenge - 1); a > 0; a--) {
                            verdecktesRaster[schiff2.startposition + a * 10] = '-';
                        }
                    } else {
                        verdecktesRaster[schiff2.startposition] = '-';
                        for (int j = (schiff2.laenge - 1); j > 0; j--) {
                            verdecktesRaster[schiff2.startposition + j] = '-';
                        }
                    }
                } else if (schiff3.versunken) {
                    if (schiff3.vertikal) {
                        verdecktesRaster[schiff3.startposition] = '-';
                        for (int a = (schiff3.laenge - 1); a > 0; a--) {
                            verdecktesRaster[schiff3.startposition + a * 10] = '-';
                        }
                    } else {
                        verdecktesRaster[schiff3.startposition] = '-';
                        for (int j = (schiff3.laenge - 1); j > 0; j--) {
                            verdecktesRaster[schiff3.startposition + j] = '-';
                        }
                    }
                } else if (schiff4.versunken) {
                    if (schiff4.vertikal) {
                        verdecktesRaster[schiff4.startposition] = '-';
                        for (int a = (schiff4.laenge - 1); a > 0; a--) {
                            verdecktesRaster[schiff4.startposition + a * 10] = '-';
                        }
                    } else {
                        verdecktesRaster[schiff4.startposition] = '-';
                        for (int j = (schiff4.laenge - 1); j > 0; j--) {
                            verdecktesRaster[schiff4.startposition + j] = '-';
                        }
                    }
                } else if (schiff5.versunken) {
                    if (schiff5.vertikal) {
                        verdecktesRaster[schiff5.startposition] = '-';
                        for (int a = (schiff5.laenge - 1); a > 0; a--) {
                            verdecktesRaster[schiff5.startposition + a * 10] = '-';
                        }
                    } else {
                        verdecktesRaster[schiff5.startposition] = '-';
                        for (int j = (schiff5.laenge - 1); j > 0; j--) {
                            verdecktesRaster[schiff5.startposition + j] = '-';
                        }
                    }
                }
                System.out.print(verdecktesRaster[i] + " ");
                if ((i + 1) % 10 == 0 && i != 99) {
                    num = num + 10;
                    System.out.println();
                    System.out.print(num + "\t");
                }
            }

            System.out.println();
        }

        public void ausgeben() {
            int num = 1;
            System.out.print(num + "\t");
            for (int i = 0; i < raster.length; i++) {
                System.out.print(raster[i] + " ");
                if ((i + 1) % 10 == 0 && i != 99) {
                    num = num + 10;
                    System.out.println();
                    System.out.print(num + "\t");
                }
            }
            System.out.println();
        }


        public void istVersunken(Schiff s) {
            boolean v = true;
            if (s.vertikal) {
                for (int i = 0; i <= s.laenge - 1; i++) {
                    if (raster[s.startposition + 10 * i] == 'o' || raster[s.startposition + 10 * 1] == 'x') {
                        v = false;
                        break;
                    }
                }
            } else {
                for (int i = 0; i <= s.laenge - 1; i++) {
                    if (raster[s.startposition + i] == 'o' || raster[s.startposition + i] == 'x') {
                        v = false;
                        break;
                    }
                }
            }
            if (v) {
                if (!versunkeneSchiffe.contains(s.name)) {
                    versunkeneSchiffe.add(s.name);
                    s.versunken = true;
                }
            }
        }

        public void schiffPlatzieren(Schiff s) {
            // Eingabeueberpruefung
            System.out.print('\n' + "Soll " + s.name + " horizontal [1] oder vertikal [2] platziert werden? > ");
            int v = scan.nextInt();
            while (true) {
                if (v == 1) {
                    s.vertikal = false;
                    break;
                } else if (v == 2) {
                    s.vertikal = true;
                    break;
                } else {
                    System.out.print("Falsche Eingabe. Soll " + s.name
                            + " horizontal [1] oder vertikal [2] platziert werden? > ");
                    v = scan.nextInt();
                }
            }

            while (true) {
                boolean moeglich = true;

                System.out.print(
                        "Bitte die Startposition des Schiffes eingeben (L" + '\u00e4' + "nge = " + s.laenge + ") > ");
                s.startposition = scan.nextInt() - 1;
                while (s.startposition < 0 || s.startposition > 99) {
                    System.out.print(
                            "Es muss ein Zahl zwischen 1 und 100 eingegeben werden. Bitte die Startposition des Schiffes eingeben > ");
                    s.startposition = scan.nextInt() - 1;
                    if (s.startposition >= 0 || s.startposition < 100) {
                        break;
                    }
                }

                // Schiff ist vertikal ausgerichtet
                if (s.vertikal) {
                    // Ist das Schiff laenger als der Platz in der Spalte?
                    if (10 - s.startposition / 10 < s.laenge) {
                        moeglich = false;
                        System.out.print("Das Schiff ist zu lang. ");
                    }
                    // Ist ein Feld bereits belegt?
                    if (moeglich) {
                        for (int i = 0; i < s.laenge - 1; i++) {
                            if (raster[s.startposition + 10 * i] != '~') {
                                moeglich = false;
                                System.out.print("Eines der Felder ist bereits belegt. ");
                                break;
                            }
                        }
                    }
                    // Ist oben und unten vom Schiff genug Platz?
                    if (moeglich) {
                        // oben
                        if (s.startposition > 9) {
                            if (raster[s.startposition - 10] != '~') {
                                moeglich = false;
                                System.out.print("Das Schiff darf nicht direkt an ein anderes grenzen. ");
                            }
                        }
                        // unten
                        if (s.startposition + 10 * (s.laenge - 1) < 90) {
                            if (raster[s.startposition + 10 * (s.laenge - 1) + 10] != '~') {
                                moeglich = false;
                                System.out.print("Das Schiff darf nicht direkt an ein anderes grenzen. ");
                            }
                        }
                    }
                    // Ist das Schiff an einem des Raender?
                    if (moeglich) {
                        // Schiff am linken Rand
                        if (s.startposition % 10 == 0) {
                            System.out.println("ups");
                            for (int i = 0; i <= s.laenge - 1; i++) {
                                if (raster[s.startposition + 10 * i + 1] != '~') {
                                    moeglich = false;
                                    System.out.print("Das Schiff darf nicht direkt an ein anderes grenzen. ");
                                    break;
                                }
                            }
                        }
                        // Schiff am rechten Rand
                        else if (s.startposition % 10 == 9) {
                            for (int i = 0; i <= s.laenge - 1; i++) {
                                if (raster[s.startposition + 10 * i - 1] != '~') {
                                    moeglich = false;
                                    System.out.print("Das Schiff darf nicht direkt an ein anderes grenzen. ");
                                    break;
                                }
                            }
                        }
                        // Schiff an keinem der Raender
                        else {
                            for (int i = 0; i <= s.laenge - 1; i++) {
                                System.out.print(i);
                                if (raster[s.startposition + 10 * i + 1] != '~') {
                                    moeglich = false;
                                    System.out.print("Das Schiff darf nicht direkt an ein anderes grenzen. ");
                                    break;
                                }
                                if (raster[s.startposition + 10 * i - 1] != '~') {
                                    moeglich = false;
                                    System.out.print("Das Schiff darf nicht direkt an ein anderes grenzen. ");
                                    break;
                                }
                            }
                        }
                    }

                }

                // Schiff ist horizontal ausgerichtet
                else {
                    // Ist das Schiff laenger als der Platz in der Zeile?
                    if (10 - s.startposition % 10 < s.laenge) {
                        moeglich = false;
                        System.out.print("Das Schiff ist zu lang. ");
                    }
                    // Ist ein Feld bereits belegt?
                    if (moeglich) {
                        for (int i = 0; i < s.laenge - 1; i++) {
                            if (raster[s.startposition + i] != '~') {
                                moeglich = false;
                                System.out.print("Eines des Felder ist bereits belegt. ");
                                break;
                            }
                        }
                    }
                    // Ist links und rechts vom Schiff genug Platz?
                    if (moeglich) {
                        // links
                        if (s.startposition % 10 > 0) {
                            if (raster[s.startposition - 1] != '~') {
                                moeglich = false;
                                System.out.print("Das Schiff darf nicht direkt an ein anderes grenzen. ");
                            }
                        }
                        // rechts
                        if (10 - (s.startposition + s.laenge - 1) % 10 == 9 && s.startposition < 100) {
                            if (raster[s.startposition + s.laenge] != '~') {
                                moeglich = false;
                                System.out.print("Das Schiff darf nicht direkt an ein anderes grenzen. ");
                            }
                        }
                    }
                    // Ist das Schiff an einem der Raender?
                    if (moeglich) {
                        // Schiff ist am oberen Rand
                        if (s.startposition < 10) {
                            for (int i = 0; i <= s.laenge - 1; i++) {
                                if (raster[s.startposition + i + 10] != '~') {
                                    moeglich = false;
                                    System.out.print("Das Schiff darf nicht direkt an ein anderes grenzen. ");
                                    break;
                                }
                            }
                        }
                        // Schiff ist am unteren Rand
                        else if (s.startposition > 89) {
                            for (int i = 0; i <= s.laenge - 1; i++) {
                                if (raster[s.startposition + i - 10] != '~') {
                                    moeglich = false;
                                    System.out.print("Das Schiff darf nicht direkt an ein anderes grenzen. ");
                                    break;
                                }
                            }
                        }
                        // Schiff an keinem der Raender
                        else {
                            for (int i = 0; i <= s.laenge - 1; i++) {
                                if (raster[s.startposition + i - 10] != '~') {
                                    moeglich = false;
                                    System.out.print("Das Schiff darf nicht direkt an ein anderes grenzen. ");
                                    break;
                                } else if (raster[s.startposition + i + 10] != '~') {
                                    moeglich = false;
                                    System.out.print("Das Schiff darf nicht direkt an ein anderes grenzen. ");
                                    break;
                                }
                            }
                        }
                    }
                }
                if (moeglich) {
                    break;
                }
            }
            // Platzierung der Schiffe
            if (s.vertikal) {
                raster[s.startposition] = 'o';
                for (int a = (s.laenge - 1); a > 0; a--) {
                    raster[s.startposition + a * 10] = 'x';
                }
            } else {
                raster[s.startposition] = 'o';
                for (int i = (s.laenge - 1); i > 0; i--) {
                    raster[s.startposition + i] = 'x';
                }
            }
            Display.clear(0);
        }

        public void schiffPlatzierungsTest(Schiff s) {
            if (s.vertikal) {
                raster[s.startposition] = 'o';
                for (int i = 0; i < s.laenge; i++) {
                    raster[s.startposition + i * 10] = 'x';
                }
            } else {
                raster[s.startposition] = 'o';
                for (int i = (s.laenge - 1); i > 0; i--) {
                    raster[s.startposition + i] = 'x';
                }
            }
        }
    }

    Spielfeld feld = new Spielfeld();

    Schiff schiff1 = new Schiff(0, 5, false, "Flugzeugtr" + '\u00e4' + "ger");
    Schiff schiff2 = new Schiff(0, 4, false, "Zerst" + '\u00f6' + "rer");
    Schiff schiff3 = new Schiff(0, 4, false, "Fregatte");
    Schiff schiff4 = new Schiff(0, 3, false, "Versorgungsschiff");
    Schiff schiff5 = new Schiff(0, 3, false, "Zerst" + '\u00f6' + "rer");

}
