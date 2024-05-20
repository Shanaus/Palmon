import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Festlegung der Datenpfade in Strings
        String pathpalmon = "src/palmon.csv";
        String pathmoves = "src/moves.csv";
        String pathpalmon_move = "src/palmon_move.csv";
        String patheffectivity = "src/effectivity.csv";

        // Erstellung von Array-Listen, um de Daten aus den CSV-Dateien speicheren zu können
        ArrayList<Palmon> palmondata = new ArrayList<>();
        ArrayList<Moves> palmonmoves = new ArrayList<>();
        ArrayList<Palmon_move> palmon_move = new ArrayList<>();
        ArrayList<Effectivity> palmoneffectivity = new ArrayList<>();

        // Erstellung von Array-Listen, um die vom User und vom Gegner ausgewählten Palmons zwischenspeichern zu können
        ArrayList<Palmon> palmonuser = new ArrayList<>();
        ArrayList<Palmon> palmongegner = new ArrayList<>();

        // Try-Catch-Block, um ein falsches Laden der CSV-Dateien bzw. um Errors beim Laden der CSV-Dateien abzufangen
        try {
            // Buffered-Reader zum Einlesen der vier CSV-Dateien
            BufferedReader br = new BufferedReader(new FileReader(pathpalmon));
            BufferedReader br2 = new BufferedReader(new FileReader(pathmoves));
            BufferedReader br3 = new BufferedReader(new FileReader(pathpalmon_move));
            BufferedReader br4 = new BufferedReader(new FileReader(patheffectivity));
            // Benötigte Loop-Variablen
            boolean darfnochlesen = true;
            boolean darfnochlesen2 = true;
            boolean darfnochlesen3 = true;
            boolean darfnochlesen4 = true;
            // Solange es noch Zeilen gibt, mache die Schleife (sobald in einer Zeile nichts mehr steht, ist die line "null", setze dann die Loop-Variablen auf false und stoppe damit die Schleife)
            while (darfnochlesen) {
                String line = br.readLine();
                if (line == null) {
                    darfnochlesen = false;
                } else {
                    // Splitte die CSV-Dateien zeilenweise in Strings auf und speichere die Einzelteile in der oben angelegten Array-List
                    String[] palmondetails = line.split(";");
                    Palmon p1 = new Palmon(palmondetails[0], palmondetails[1], palmondetails[2], palmondetails[3], palmondetails[4], palmondetails[5], palmondetails[6], palmondetails[7], palmondetails[8], palmondetails[9]);
                    palmondata.add(p1);
                }
            }
            // Solange es noch Zeilen gibt, mache die Schleife (sobald in einer Zeile nichts mehr steht, ist die line "null", setze dann die Loop-Variablen auf false und stoppe damit die Schleife)
            while (darfnochlesen2) {
                String line2 = br2.readLine();
                if (line2 == null) {
                    darfnochlesen2 = false;
                } else {
                    // Splitte die CSV-Dateien zeilenweise in Strings auf und speichere die Einzelteile in der oben angelegten Array-List
                    String[] movedetails = line2.split(";");
                    Moves m1 = new Moves(movedetails[0], movedetails[1], movedetails[2], movedetails[3], movedetails[4], movedetails[5]);
                    palmonmoves.add(m1);
                }

            }
            // Solange es noch Zeilen gibt, mache die Schleife (sobald in einer Zeile nichts mehr steht, ist die line "null", setze dann die Loop-Variablen auf false und stoppe damit die Schleife)
            while (darfnochlesen3) {
                String line3 = br3.readLine();
                if (line3 == null) {
                    darfnochlesen3 = false;
                } else {
                    // Splitte die CSV-Dateien zeilenweise in Strings auf und speichere die Einzelteile in der oben angelegten Array-List
                    String[] palmon_movedetails = line3.split(";");
                    Palmon_move p_m1 = new Palmon_move(palmon_movedetails[0], palmon_movedetails[1], palmon_movedetails[2]);
                    palmon_move.add(p_m1);
                }
            }
            // Solange es noch Zeilen gibt, mache die Schleife (sobald in einer Zeile nichts mehr steht, ist die line "null", setze dann die Loop-Variablen auf false)
            while (darfnochlesen4) {
                String line4 = br4.readLine();
                if (line4 == null) {
                    darfnochlesen4 = false;
                } else {
                    // Splitte die CSV-Dateien zeilenweise in Strings auf und speichere die Einzelteile in der oben angelegten Array-List
                    String[] effectivitydetails = line4.split(";");
                    Effectivity e1 = new Effectivity(effectivitydetails[0], effectivitydetails[1], effectivitydetails[2]);
                    palmoneffectivity.add(e1);
                }

            }
            // Schließen des BufferedReaders, um Speicherplatz freizugeben
            br.close();
            br2.close();
            br3.close();
            br4.close();

            // Catch-Block, um eine Exception zu verhindern, falls die Datei nicht gefunden oder nicht eingelesen werden konnte.
        } catch (FileNotFoundException e) {
            System.out.println("Die Datei wurde nicht gefunden");
        } catch (IOException e) {
            System.out.println("Die Datei konnte nicht eingelesen werden");
        }


        // Einführen eines Scanners, damit der Benutzer mit der Konsole kommunizieren kann
        Scanner scan = new Scanner(System.in);
        System.out.println("Herzlich Willkommen lieber Spieler! \n\nBitte gib die Anzahl der Palmons an, mit der du spielen möchtest!");

        // Solange der Spieler keine Ganzzahl eingibt, soll er darauf hingewiesen werden, eine Ganzzahl einzugeben.
        while (!scan.hasNextInt()) {
            System.out.println("Das war leider keine ganze Zahl! Um weiterzuspielen, gib bitte eine Ganzzahl ein.");
            scan.next();
        }
        // Wenn Ganzzahl eingegeben wurde, setze die Eingabe als eine Variable für die Anzahl der Palmons fest
        int AnzahlPalmons = scan.nextInt();

        // Solange die eingegebene Ganzzahl größer als die Gesamtzahl der Palmons ist, gib dem User an, dass er maximal die Gesamtzahl der Palmons eingeben kann.
        // Definiere die Variable AnzahlPalmons mit der nächsten Eingabe neu
        while (AnzahlPalmons > palmondata.size()) {
            System.out.println("Es gibt leider nur " + palmondata.size() + " Palmons. Um weiterzuspielen, wähle maximal " + palmondata.size() + " Palmons aus!");
            AnzahlPalmons = scan.nextInt();
        }
        // Sobald die eingegebene Ganzzahl kleine als die Gesamtzahl der Palmons ist, gib dem User aus, dass er mit der eingegebenen Anzahl an Palmons spielen möchte und fahre fort
        if (AnzahlPalmons < palmondata.size()) {
            System.out.println("Du möchstest mit " + AnzahlPalmons + " Palmons spielen! \n");
        }

        System.out.println("Wie möchtest du dein Team aus " + AnzahlPalmons + " Palmons zusammenstellen? Du kannst Palmons nach der ID oder dem Typ auswählen oder sie zufällig generieren lassen.\nGebe hierfür \"ID\", \"Random\" oder \"Typ\" an.");

        // Der User soll in der nächsten Eingabe angeben, we er sein Team zusammenstellen möchte
        // Hierzu soll die Eingabe in einer Variable "team" gespeichert werden, die entweder ID, Random oder Typ sein kann.
        // Solange der User nicht das Wort ID, Random oder Typ eingibt, wird er darauf hingewiesen, dass er ID, Random oder Typ eingeben soll. Anschließend wird die Variable team mit der nächsten Eingabe neu definiert.
        String team = scan.next();
        while (!team.equals("ID") && !team.equals("Random") && !team.equals("Typ")) {
            System.out.println("Das war leider keine gültige Eingabe. Gib bitte \"ID\", \"Random\" oder \"Typ\" an.");
            team = scan.next();
        }
        // Switch-case, da genaue Eingaben vom User erwartet werden
        switch (team) {
            // Ist die Eingabe ID, soll der User insgesamt so viele IDs eingeben, wie er als AnzahlPalmons, mt denen er spielen möchte, festgelegt hat
            case "ID":
                System.out.println("Du hast ID ausgewählt! Bitte gebe insgesamt " + AnzahlPalmons + " ID`s der Palmons an, die du haben möchtest. Dir stehen " + palmondata.size() + " ID's zur Verfügung.");
                // Schleife für die Anzahl der Palmons, die der User vorher festgelegt hat und die er nun jeweils über eine ID auswählen soll
                for (int i = 0; i < AnzahlPalmons; i++) {
                    // Variable, um überprüfen zu können, ob eine gültige ID gefunden wurde
                    boolean idgefunden = false;
                    // (i + 1) kann gesetzt werden, da i bereits bei 0 beginnt und 1 vor der AnzahlPalmons aufhört
                    System.out.println("Bitte gib die ID " + (i + 1) + " ein: ");
                    // Solange der User keine Ganzzahl eingibt, die für die ID benötigt wird, soll er darauf hingewiesen werden, eine Ganzzahl anzugeben.
                    while (!scan.hasNextInt()) {
                        System.out.println("Das war leider keine ganze Zahl! Um weiterzuspielen, gib bitte eine Ganzzahl ein.");
                        scan.next();
                    }
                    // Die nächste Eingabe soll die erste ID sein. String, da die ArrayList palmondata aus einzelnen Strings besteht
                    String ID = scan.next();
                    // Schaffe das Hilfsobjekt palmonid, das über die gesamten Palmons in palmondata iteriert
                    for (Palmon palmonid : palmondata) {
                        // Schaffe einen String palmonids, der die ID aller Palmons beinhaltet
                        String palmonids = palmonid.getId();
                        // Wenn die vom User eingegebene ID mit einer der im String palmonids enthalteten ID übereinstimmt, füge den Palmon mit dieser ID in die Liste mit den Palmons, mit denen der User spielen will, hinzu
                        if (palmonids.equals(ID)) {
                            // Füge die Palmons der Liste palmonuser hinzu
                            palmonuser.add(palmonid);
                            // Setze die Variable auf true, um anzuzeigen, dass eine ID gefunden wurde
                            idgefunden = true;
                            // Beende die Schleife, da eine Übereinstimmung der eingegebenen ID mit der eines Palmons gefunden wurde
                            break;
                        }
                    }
                    // Wenn keine gültige ID gefunden wurde, informiere den Benutzer und wiederhole die Eingabe für die aktuelle Iteration
                    if (!idgefunden) {
                        System.out.println("Diese ID existiert nicht, bitte gib eine andere ID ein.");
                        // Setze den Zähler i um eins nach unten, um die Eingabe für die aktuelle Iteration wiederholen zu können
                        i--;
                    }
                }
                // Break, da der User nur entweder nach ID, Random oder Typ auswählen soll
                break;

            case "Random":
                // Initialisierung von Random
                Random random = new Random();
                System.out.println("Für dich wurden zufällig folgende Palmons ausgewählt: ");
                // Schleife für die Anzahl der Palmons, die der User vorher festgelegt hat
                for (int i = 0; i < AnzahlPalmons; i++) {
                    // Festlegung einer Variable, die eine Zufallszahl innerhalb der Liste palmondata angibt
                    int randomIndex = random.nextInt(palmondata.size());
                    // Auswählen eines zufälligen Palmons aus palmondata, der dem Index der vorher ermittelten Zufallszahl entspricht
                    Palmon randomPalmons = palmondata.get(randomIndex);
                    // ausgeben der jeweiligen Namen der Palmons
                    System.out.println(randomPalmons.getName());
                    // Füge die Palmons der Liste palmonuser hinzu
                    palmonuser.add(randomPalmons);
                }
                break;

            case "Typ":
                System.out.println("Bitte gib insgesamt " + AnzahlPalmons + " Typen für deine Palmons ein. Es gibt folgende Typen: \n\"normal\", \"fighting\", \"flying\", \"poison\", \"ground\", \"rock\", \"bug\", \"ghost\", \"steel\", \"fire\", \"water\", \"grass\", \"electric\", \"psychic\", \"ice\", \"dragon\", \"dark\" und \"fairy\"!");
                for (int i = 0; i < AnzahlPalmons; i++) {
                    String typ = scan.next();
                    while (!typ.equals("normal") && !typ.equals("fighting") && !typ.equals("flying") && !typ.equals("poison") && !typ.equals("ground") && !typ.equals("rock") && !typ.equals("bug") && !typ.equals("ghost") && !typ.equals("steel") && !typ.equals("fire") && !typ.equals("water") && !typ.equals("grass") && !typ.equals("electric") && !typ.equals("psychic") && !typ.equals("ice") && !typ.equals("dragon") && !typ.equals("dark") && !typ.equals("fairy")) {
                        System.out.println("Das war leider keine gültige Eingabe. Gib bitte \"normal\", \"fighting\", \"flying\", \"poison\", \"ground\", \"rock\", \"bug\", \"ghost\", \"steel\", \"fire\", \"water\", \"grass\", \"electric\", \"psychic\", \"ice\", \"dragon\", \"dark\" oder \"fairy\"!");
                        typ = scan.next();
                    }
                    switch (typ) {
                        case "normal":
                            ArrayList<Palmon> palmonnormal = new ArrayList<>();
                            for (Palmon normal : palmondata) {
                                if (normal.getType1().equals("normal") || normal.getType2().equals("normal")) {
                                    palmonnormal.add(normal);
                                }
                            }
                            Random random1 = new Random();
                            int randomnormal = random1.nextInt(palmonnormal.size());
                            Palmon randomnamenormal = palmonnormal.get(randomnormal);
                            palmonuser.add(randomnamenormal);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnamenormal.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "fighting":
                            ArrayList<Palmon> palmonfighting = new ArrayList<>();
                            for (Palmon fighting : palmondata) {
                                if (fighting.getType1().equals("fighting") || fighting.getType2().equals("fighting")) {
                                    palmonfighting.add(fighting);
                                }
                            }
                            Random random2 = new Random();
                            int randomfighting = random2.nextInt(palmonfighting.size());
                            Palmon randomnamefighting = palmonfighting.get(randomfighting);
                            palmonuser.add(randomnamefighting);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnamefighting.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "flying":
                            ArrayList<Palmon> palmonflying = new ArrayList<>();
                            for (Palmon flying : palmondata) {
                                if (flying.getType1().equals("flying") || flying.getType2().equals("flying")) {
                                    palmonflying.add(flying);
                                }
                            }
                            Random random3 = new Random();
                            int randomflying = random3.nextInt(palmonflying.size());
                            Palmon randomnameflying = palmonflying.get(randomflying);
                            palmonuser.add(randomnameflying);
                            System.out.println(randomnameflying.getName());
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnameflying.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "poison":
                            ArrayList<Palmon> palmonpoison = new ArrayList<>();
                            for (Palmon poison : palmondata) {
                                if (poison.getType1().equals("poison") || poison.getType2().equals("poison")) {
                                    palmonpoison.add(poison);
                                }
                            }
                            Random random4 = new Random();
                            int randompoison = random4.nextInt(palmonpoison.size());
                            Palmon randomnamepoison = palmonpoison.get(randompoison);
                            palmonuser.add(randomnamepoison);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnamepoison.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "ground":
                            ArrayList<Palmon> palmonground = new ArrayList<>();
                            for (Palmon ground : palmondata) {
                                if (ground.getType1().equals("ground") || ground.getType2().equals("ground")) {
                                    palmonground.add(ground);
                                }
                            }
                            Random random5 = new Random();
                            int randomground = random5.nextInt(palmonground.size());
                            Palmon randomnameground = palmonground.get(randomground);
                            palmonuser.add(randomnameground);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnameground.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "rock":
                            ArrayList<Palmon> palmonrock = new ArrayList<>();
                            for (Palmon rock : palmondata) {
                                if (rock.getType1().equals("rock") || rock.getType2().equals("rock")) {
                                    palmonrock.add(rock);
                                }
                            }
                            Random random6 = new Random();
                            int randomrock = random6.nextInt(palmonrock.size());
                            Palmon randomnamerock = palmonrock.get(randomrock);
                            palmonuser.add(randomnamerock);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnamerock.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "bug":
                            ArrayList<Palmon> palmonbug = new ArrayList<>();
                            for (Palmon bug : palmondata) {
                                if (bug.getType1().equals("bug") || bug.getType2().equals("bug")) {
                                    palmonbug.add(bug);
                                }
                            }
                            Random random7 = new Random();
                            int randombug = random7.nextInt(palmonbug.size());
                            Palmon randomnamebug = palmonbug.get(randombug);
                            palmonuser.add(randomnamebug);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnamebug.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "ghost":
                            ArrayList<Palmon> palmonghost = new ArrayList<>();
                            for (Palmon ghost : palmondata) {
                                if (ghost.getType1().equals("ghost") || ghost.getType2().equals("ghost")) {
                                    palmonghost.add(ghost);
                                }
                            }
                            Random random8 = new Random();
                            int randomghost = random8.nextInt(palmonghost.size());
                            Palmon randomnameghost = palmonghost.get(randomghost);
                            palmonuser.add(randomnameghost);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnameghost.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "steel":
                            ArrayList<Palmon> palmonsteel = new ArrayList<>();
                            for (Palmon steel : palmondata) {
                                if (steel.getType1().equals("steel") || steel.getType2().equals("steel")) {
                                    palmonsteel.add(steel);
                                }
                            }
                            Random random9 = new Random();
                            int randomsteel = random9.nextInt(palmonsteel.size());
                            Palmon randomnamesteel = palmonsteel.get(randomsteel);
                            palmonuser.add(randomnamesteel);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnamesteel.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "fire":
                            ArrayList<Palmon> palmonfire = new ArrayList<>();
                            for (Palmon fire : palmondata) {
                                if (fire.getType1().equals("fire") || fire.getType2().equals("fire")) {
                                    palmonfire.add(fire);
                                }
                            }
                            Random random10 = new Random();
                            int randomfire = random10.nextInt(palmonfire.size());
                            Palmon randomnamefire = palmonfire.get(randomfire);
                            palmonuser.add(randomnamefire);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnamefire.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "water":
                            ArrayList<Palmon> palmonwater = new ArrayList<>();
                            for (Palmon water : palmondata) {
                                if (water.getType1().equals("water") || water.getType2().equals("water")) {
                                    palmonwater.add(water);
                                }
                            }
                            Random random11 = new Random();
                            int randomwater = random11.nextInt(palmonwater.size());
                            Palmon randomnamewater = palmonwater.get(randomwater);
                            palmonuser.add(randomnamewater);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnamewater.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "grass":
                            ArrayList<Palmon> palmongrass = new ArrayList<>();
                            for (Palmon grass : palmondata) {
                                if (grass.getType1().equals("grass") || grass.getType2().equals("grass")) {
                                    palmongrass.add(grass);
                                }
                            }
                            Random random12 = new Random();
                            int randomgrass = random12.nextInt(palmongrass.size());
                            Palmon randomnamegrass = palmongrass.get(randomgrass);
                            palmonuser.add(randomnamegrass);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnamegrass.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "electric":
                            ArrayList<Palmon> palmonelectric = new ArrayList<>();
                            for (Palmon electric : palmondata) {
                                if (electric.getType1().equals("electric") || electric.getType2().equals("electric")) {
                                    palmonelectric.add(electric);
                                }
                            }
                            Random random13 = new Random();
                            int randomelectric = random13.nextInt(palmonelectric.size());
                            Palmon randomnameelectric = palmonelectric.get(randomelectric);
                            palmonuser.add(randomnameelectric);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnameelectric.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "psychic":
                            ArrayList<Palmon> palmonpsychic = new ArrayList<>();
                            for (Palmon psychic : palmondata) {
                                if (psychic.getType1().equals("psychic") || psychic.getType2().equals("psychic")) {
                                    palmonpsychic.add(psychic);
                                }
                            }
                            Random random14 = new Random();
                            int randompsychic = random14.nextInt(palmonpsychic.size());
                            Palmon randomnamepsychic = palmonpsychic.get(randompsychic);
                            palmonuser.add(randomnamepsychic);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnamepsychic.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "ice":
                            ArrayList<Palmon> palmonice = new ArrayList<>();
                            for (Palmon ice : palmondata) {
                                if (ice.getType1().equals("ice") || ice.getType2().equals("ice")) {
                                    palmonice.add(ice);
                                }
                            }
                            Random random15 = new Random();
                            int randomice = random15.nextInt(palmonice.size());
                            Palmon randomnameice = palmonice.get(randomice);
                            palmonuser.add(randomnameice);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnameice.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "dragon":
                            ArrayList<Palmon> palmondragon = new ArrayList<>();
                            for (Palmon dragon : palmondata) {
                                if (dragon.getType1().equals("dragon") || dragon.getType2().equals("dragon")) {
                                    palmondragon.add(dragon);
                                }
                            }
                            Random random16 = new Random();
                            int randomdragon = random16.nextInt(palmondragon.size());
                            Palmon randomnamedragon = palmondragon.get(randomdragon);
                            palmonuser.add(randomnamedragon);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnamedragon.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "dark":
                            ArrayList<Palmon> palmondark = new ArrayList<>();
                            for (Palmon dark : palmondata) {
                                if (dark.getType1().equals("dark") || dark.getType2().equals("dark")) {
                                    palmondark.add(dark);
                                }
                            }
                            Random random17 = new Random();
                            int randomdark = random17.nextInt(palmondark.size());
                            Palmon randomnamedark = palmondark.get(randomdark);
                            palmonuser.add(randomnamedark);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnamedark.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;

                        case "fairy":
                            ArrayList<Palmon> palmonfairy = new ArrayList<>();
                            for (Palmon fairy : palmondata) {
                                if (fairy.getType1().equals("fairy") || fairy.getType2().equals("fairy")) {
                                    palmonfairy.add(fairy);
                                }
                            }
                            Random random18 = new Random();
                            int randomfairy = random18.nextInt(palmonfairy.size());
                            Palmon randomnamefairy = palmonfairy.get(randomfairy);
                            palmonuser.add(randomnamefairy);
                            System.out.println("Für dich wurde zufällig folgender Palmon ausgewählt: " + randomnamefairy.getName() + "\n\nBitte gib einen weiteren Typen ein.");
                            break;
                    }
                }
        }

        // Benachrichtigung des Users, mit welchen Palmons er spielt
        System.out.println("\n\nDu spielst mit folgenden Palmons: \n");
        // Ausgabe der Namen aller Palmons, mit denen der User spielt.
        // Iteriere über alle Einträge der ArrayList palmonuser und die Namen der Palmons aus aus
        for (int k = 0; k < palmonuser.size(); k++) {
            System.out.println(palmonuser.get(k).getName());
        }
        // Nachfrage, wie viele Palmons der Gegner haben soll
        System.out.println("\nDein Team ist fertig erstellt. Erstelle jetzt das Team des Gegners. \n\nWie viele Palmons soll dein Gegner haben? Du kannst die Anzahl selbst festlegen oder sie zufällig bestimmen lassen. \nWähle hierzu \"Zahl\" aus, um selbst zu bestimmen oder \"Random\", um die Anzahl zufällig bestimmen zu lassen.");

        // In der nächsten Eingabe soll User bestimmen, ob er die Anzahl der Palmons des Gegners selbst bestimmt oder random bestimmen lassen will
        String teamgegner = scan.next();

        // Solange die nächste Eingabe nicht genau Zahl oder Random entspricht, weise den User auf die falsche Eingabe hin und ermögliche eine erneute Eingabe
        while (!teamgegner.equals("Zahl") && !teamgegner.equals("Random")) {
            System.out.println("Das war leider keine gültige Eingabe. Gib bitte \"Zahl\", \"Random\" an.");
            teamgegner = scan.next();
        }

        // Switch-case, da vom User die genauen Eingaben Zahl oder Random erwartet werden
        switch (teamgegner) {
            case "Zahl":
                // Wenn Zahl eingegeben wurde, Hinweis, dass der User eine Zahl eingeben soll
                System.out.println("Gib die Anzahl der Palmons an, die dein Gegner haben soll");
                // Solange User keine Ganzzahl eingibt, Hinweis dass er eine Ganzzahl eingeben soll und ermögliche eine erneute Eingabe
                while (!scan.hasNextInt()) {
                    System.out.println("Das war leider keine ganze Zahl! Um weiterzuspielen, gib bitte eine Ganzzahl ein.");
                    scan.next();
                }
                // Setze die eingegebene Ganzzahl als Variable für die Anzahl der Palmons des Gegners fest
                int AnzahlPalmonsGegner = scan.nextInt();
                // Solange die eingegebene Ganzzahl größer als die maximale Zahl der Palmons ist, weise den User auf die maximale Anzahl der Palmons hin und ermögliche eine neue Eingabe
                while (AnzahlPalmonsGegner > palmondata.size()) {
                    System.out.println("Es gibt leider nur " + palmondata.size() + " Palmons. Um weiterzuspielen, wähle maximal " + palmondata.size() + " Palmons für deinen Gegner aus!");
                    AnzahlPalmonsGegner = scan.nextInt();
                }
                // Sobald die eingegebene Ganzzahl kleiner als die maximale Zahl der Palmons ist, gebe dem User aus, mit wie vielen Palmons der Gegner spielt
                if (AnzahlPalmonsGegner < palmondata.size()) {
                    System.out.println("Der Gegner spielt mit " + AnzahlPalmonsGegner + " Palmons! \n");
                    // Initialisierung von Random
                    Random randomgegnerzahl = new Random();
                    System.out.println("Für den Gegner wurden zufällig die folgenden Palmons ausgewählt: \n");
                    // Schleife für die Anzahl Palmons des Gegners, die der User vorher festgelegt hat
                    for (int i = 0; i < AnzahlPalmonsGegner; i++) {
                        // Festlegung einer Variable, die eine Zufallszahl innerhalb der Liste palmondata angibt
                        int randomIndex = randomgegnerzahl.nextInt(palmondata.size());
                        // Auswählen eines zufälligen Palmons aus palmondata, der dem Index der vorher ermittelten Zufallszahl entspricht
                        Palmon RandomPalmonsGegner = (palmondata.get(randomIndex));
                        // ausgeben der jeweiligen Namen der Palmons
                        System.out.println(RandomPalmonsGegner.getName());
                        // Füge die Palmons der Liste palmongegner hinzu
                        palmongegner.add(RandomPalmonsGegner);
                    }
                }
                // Break, da der User die Anzahl der Palmons des Gegners entweder nach Zahl oder nach Random auswählen kann
                break;

            case "Random":
                Random randomgegnerrandom = new Random();
                System.out.println("Für den Gegner wurden zufällig die folgenden Palmons ausgewählt: \n");
                for (int i = 0; i < palmondata.size(); i++) {
                    // Festlegung einer Variable, die eine Zufallszahl innerhalb der Liste palmondata angibt
                    int randomIndex = randomgegnerrandom.nextInt(palmondata.size());
                    // Auswählen eines zufälligen Palmons aus palmondata, der dem Index der vorher ermittelten Zufallszahl entspricht
                    Palmon RandomPalmonsGegner = (palmondata.get(randomIndex));
                    // ausgeben der jeweiligen Namen der Palmons
                    System.out.println(RandomPalmonsGegner.getName());
                    // Füge die Palmons der Liste palmongegner hinzu
                    palmongegner.add(RandomPalmonsGegner);
                }
                break;
        }

        System.out.println("\nDie Teams sind fertig erstellt. Welche Level-Range möchtest du für das Spiel haben? Gib eine Level-Range an. ");
        int levelrange = scan.nextInt();
        System.out.println("Die Level-Range für alle Palmons beträgt " + levelrange + "! \n\nDen Palmons werden nun ihre Moves in Abhängigkeit ihrer Level-Range zugeordnet.");

        HashMap<Palmon, List<Palmon_move>> initialpalmonmovesuser = new HashMap<>();
        for (Palmon palmon : palmonuser) {
            String palmonID = palmon.getId();
            ArrayList<Palmon_move> movesForPalmonUser = new ArrayList<>();
            for (Palmon_move move : palmon_move) {
                if (move.getPalmon_ID().equals(palmonID)) {
                    int level = Integer.parseInt(move.getLearned_On_Level());
                    if (level <= levelrange) {
                        movesForPalmonUser.add(move);
                    }
                }
            }
            initialpalmonmovesuser.put(palmon, movesForPalmonUser);
        }

        HashMap<Palmon, List<Moves>> finalpalmonmovesuser = new HashMap<>();
        for (Palmon palmon : initialpalmonmovesuser.keySet()) {
            List<Palmon_move> palmonMoves = initialpalmonmovesuser.get(palmon);
            List<Moves> FinalMovesForPalmonUser = new ArrayList<>();
            for (Palmon_move palmonMove : palmonMoves) {
                String moveId = palmonMove.getMove_id();
                for (Moves move : palmonmoves) {
                    if (move.getID().equals(moveId)) {
                        FinalMovesForPalmonUser.add(move);
                    }
                }
            }
            finalpalmonmovesuser.put(palmon, FinalMovesForPalmonUser);
        }


        HashMap<Palmon, List<Palmon_move>> initialpalmonmovesgegner = new HashMap<>();
        for (Palmon palmon : palmongegner) {
            String palmonID = palmon.getId();
            ArrayList<Palmon_move> movesForPalmonGegner = new ArrayList<>();
            for (Palmon_move move : palmon_move) {
                if (move.getPalmon_ID().equals(palmonID)) {
                    int level = Integer.parseInt(move.getLearned_On_Level());
                    if (level <= levelrange) {
                        movesForPalmonGegner.add(move);
                    }
                }
            }
            initialpalmonmovesgegner.put(palmon, movesForPalmonGegner);
        }
        for (Palmon palmon : finalpalmonmovesuser.keySet()) {
            List<Moves> moves = finalpalmonmovesuser.get(palmon);
            System.out.println("\nHier sind die Moves für deinen Palmon " + palmon.getName() + ":");
            for (Moves move : moves) {
                System.out.println("Der Move " + move.getName() + " hat folgende Damage: " + move.getDamage());
            }
        }

        HashMap<Palmon, List<Moves>> finalpalmonmovesgegner = new HashMap<>();
        for (Palmon palmon : initialpalmonmovesgegner.keySet()) {
            List<Palmon_move> palmonMoves = initialpalmonmovesgegner.get(palmon);
            List<Moves> finalMovesForPalmonGegner = new ArrayList<>();
            for (Palmon_move palmonMove : palmonMoves) {
                String moveId = palmonMove.getMove_id();
                for (Moves move : palmonmoves) {
                    if (move.getID().equals(moveId)) {
                        finalMovesForPalmonGegner.add(move);
                    }
                }
            }
            finalpalmonmovesgegner.put(palmon, finalMovesForPalmonGegner);
        }
        for (Palmon palmon : finalpalmonmovesgegner.keySet()) {
            List<Moves> moves = finalpalmonmovesgegner.get(palmon);
            System.out.println("\nMoves für den gegnerischen Palmon " + palmon.getName() + ":");
            for (Moves move : moves) {
                System.out.println("Der Move " + move.getName() + " hat folgende Damage: " + move.getDamage());
            }
        }
        System.out.println("\nAlle Palmons und ihre zugehörigen Moves sind geladen.");

        for (Palmon palmon: finalpalmonmovesuser.keySet())
        {
            List<Moves> moves = finalpalmonmovesuser.get(palmon);
            for (Moves move: moves)
            {
                System.out.println("Du startest mit Palmon" + palmonuser.get(0).getName());
            }
        {
// Vorgehensweise: Move abfragen, schauen ob Move den Palmon gehört. Wenn der Move dem Palmon gehört und du es nicht über die HashMap schaffst, dann über die palmonmoves-Liste die Berechnung durchführen


        }

        }
    }

}

