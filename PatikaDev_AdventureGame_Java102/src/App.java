import java.util.*;

import Characters.Character;
import Locations.Location;
import Locations.Shop;
import Managers.LineStringCreaters;
import Managers.ShortOutputCommands;

public class App extends ShortOutputCommands {
    static boolean isStarted = false;
    static boolean isPlayerSelected = false;
    static Character Player;
    static ArrayList<Location> pLocations = new ArrayList<Location>();
    static Shop pShop = new Shop();
    static String CurrentLocation = "SafeHouse";

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
        cw("Press Enter to start");
        
    }

    static void Start() {
        Scanner scanner = new Scanner(System.in);
        String StatusController = "playing";
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
                            break;
                        case "2":
                            Player = new Character(2, "Archer", 7, 18, 20);
                        case "3":
                            Player = new Character(3, "Knight", 8, 24, 5);
                            break;
                    }
                    isPlayerSelected = true;
                    TaskPrintLn("Character Selected", Player.Name);
                }

                if (Player != null) {
                    if (Player.isFighting == false) {
                        ListLocations();
                    }
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    ListCharacters();
                    RunProject();
                }

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
        cwl(LineCreater.CreateLine(5, "=", false) + "Characters" + LineCreater.CreateLine(5, "=", false));
        TaskPrintLn("ID: 1", "Samurai");
        TaskPrintLn("ID: 2", "Archer ");
        TaskPrintLn("ID: 3", "Knight ");
        cwl(LineCreater.CreateLine(10 + "Characters".length(), "=", false));
    }

    static void ListLocations() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        cwl(LineCreater.CreateLine(5, "=", false) + "Locations" + LineCreater.CreateLine(5, "=", false));
        for (int i = 0; i < pLocations.size(); i++) {
            TaskPrintLn("ID: " + pLocations.get(i).ID, pLocations.get(i).Name);
        }
        TaskPrintLn("ID: " + (pLocations.size() + 1), "Shop");
    }
    
    static void AddLocations() {
        pLocations.add(new Location(1, "SafeHouse"));
        pLocations.add(new Location(2, "Cave"));
        pLocations.add(new Location(3, "Forest"));
        pLocations.add(new Location(4, "River"));
    }
}
