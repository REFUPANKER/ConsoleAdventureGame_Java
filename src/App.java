import java.util.*;

import Characters.Character;
import Locations.Location;
import Locations.Shop;
import Managers.LineStringCreaters;
import Managers.ShortOutputCommands;
import Monsters.Monster;

public class App extends ShortOutputCommands {
    static boolean isStarted = false;
    static boolean isPlayerSelected = false;
    static Character Player;
    static ArrayList<Location> pLocations = new ArrayList<Location>();
    static Shop pShop;
    static Location CurrentLocation;
    static String StatusController = "playing";

    public static void main(String[] args) throws Exception {
        RunProject();

    }

    static void RunProject() {
        if (isStarted == false) {
            isStarted = true;
            Intro();
            AddLocations();
            Start();
            ListCharacters();
        }

    }

    static LineStringCreaters LineCreater = new LineStringCreaters();

    static void Intro() {
        cwl("Wellcome to AdventureGame 0.0.5");
        cwl("Press Enter to start");

    }

    static Scanner scanner = new Scanner(System.in);

    static void Start() {

        while (StatusController.startsWith("exit") == false) {
            StatusController = scanner.nextLine();
            if (StatusController.startsWith("exit")) {
                cwl("Closing game");
                scanner.close();
                break;
            } else {

                if (isPlayerSelected == false && StatusController.length() >= 1) {
                    switch (String.valueOf(StatusController.charAt(0))) {
                        case "1":
                            Player = new Character(1, "Samurai", 5, 21, 15);
                            isPlayerSelected = true;
                            break;
                        case "2":
                            Player = new Character(2, "Archer", 7, 18, 20);
                            isPlayerSelected = true;
                        case "3":
                            Player = new Character(3, "Knight", 8, 24, 5);
                            isPlayerSelected = true;
                            break;
                        default:
                            isPlayerSelected = false;
                            break;

                    }
                    if (isPlayerSelected) {
                        TaskPrintLn("Character Selected", Player.Name);
                        cwl("Press Enter to continue");
                    }
                } else if (Player == null) {
                    ListCharacters();
                } else {
                    if (Player.isFighting == false) {
                        LocationSelecting();
                    }
                }
            }

        } // End of Status Controlling Loop
        scanner.close();
    }// End of Void:Start

    static void LocationSelecting() {
        if (CurrentLocation == null) {
            ListLocations();
            if (StatusController.length() >= 1) {
                for (int i = 0; i < pLocations.size(); i++) {

                    if (StatusController.startsWith(String.valueOf(pLocations.get(i).ID))) {
                        SelectLocation(Integer.valueOf(StatusController));
                        TaskPrintLn("Traveling to", CurrentLocation.Name);
                        cwl("Press Enter to continue");
                        scanner.nextLine();
                        CurrentLocation.InAction();
                    }
                }
            }
        } else {
            if (StatusController.startsWith("0")) {
                CurrentLocation = null;
                ListLocations();
            } else if (StatusController.startsWith("1")) {
                if (CurrentLocation.LocalMonsters.size() > 0) {
                    CurrentLocation.AttackToMonster();
                }
            } else if (CurrentLocation.LocalMonsters.size() <= 0) {
                ListLocations();
            }
        }
    }

    static void TaskPrintLn(String Title, Object msg) {
        System.out.println("[" + Title + "]> " + msg);
    }

    static void ListCharacters() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        TaskPrintLn("Select", "Character");
        cwl(LineCreater.CreateLine(20, "=", false) + "Characters" + LineCreater.CreateLine(20, "=", false));
        TaskPrintLn("ID: 1", "Samurai" + " |Health: 21" + " |Damage: 5" + " |Money: 15");
        TaskPrintLn("ID: 2", "Archer " + " |Health: 18" + " |Damage: 7" + " |Money: 20");
        TaskPrintLn("ID: 3", "Knight " + " |Health: 24" + " |Damage: 8" + " |Money: 5");
        cwl(LineCreater.CreateLine(40 + "Characters".length(), "=", false));
    }

    static void ListLocations() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        cwl(LineCreater.CreateLine(5, "=", false) + "Locations" + LineCreater.CreateLine(5, "=", false));
        for (int i = 0; i < pLocations.size(); i++) {
            TaskPrintLn("ID: " + pLocations.get(i).ID, pLocations.get(i).Name);
        }
        cwl(LineCreater.CreateLine(19, "=", false));
    }

    static void AddLocations() {
        pLocations.add(new Location(1, "SafeHouse", null));
        pLocations.add(new Location(2, "Cave", new Monster(1, "Zombie", 4, 3, 10)));
        pLocations.add(new Location(3, "Forest", new Monster(2, "Vampire", 7, 4, 14)));
        pLocations.add(new Location(4, "River", new Monster(3, "Bear", 12, 7, 20)));
        pShop = new Shop(5, "Shop");
        pLocations.add(pShop);
    }

    static Location SelectLocation(int Lid) {
        try {
            for (int i = 0; i < pLocations.size(); i++) {
                if (Lid == pLocations.get(i).ID) {
                    CurrentLocation = pLocations.get(i);
                    CurrentLocation.Player = Player;
                    return CurrentLocation;
                }
            }
        } finally {
        }
        return null;
    }

}
