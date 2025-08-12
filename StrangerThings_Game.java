import java.util.*;

public class StrangerThings_Game {
    public static void main(String[] args) {

        System.out.println("------- STRANGER THINGS -------");

        Player you = new Player();
        Mode modes = new Mode();
        Start go = new Start();
        you.Name();
        modes.GameMode();

        System.out.println("\nWelcome to STRANGER THINGS, " + you.getName() + "!");
        System.out.println("They are waiting for you..");
            go.ForStart();
    }
}

interface PlayerInfo {
    public void Name();
}

interface GameModes {
    public void GameMode();
}

interface GameStart {
    public void ForStart();
}

class Player implements PlayerInfo {
    String name;
    
    public  String getName() {
        return name;
    }

    public void SetName(String n) {
        this.name = n;
    }

    public void Name() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your name: ");
        name = sc.nextLine();
        SetName(name);
    }
}

class Mode implements GameModes {
    Scanner sc = new Scanner(System.in);
    public void GameMode() {
        System.out.println("\n1 - HARD");
        System.out.println("2 - NIGHTMARE");
        System.out.print("SELECT GAME MODE: ");
        int GameMode = sc.nextInt();

        if (GameMode == 1) {
            System.out.println("-------------------------------");
            System.out.println("HARD MODE");
            System.out.println("\nYOU WILL GO TO THE UPSIDE DOWN");
            System.out.println("TO SAVE YOUR FRIEND AND ESCAPE!");
            System.out.println("-------------------------------");
        } else if (GameMode == 2) {
            System.out.println("-------------------------------");
            System.out.println("NIGHTMARE MODE");
            System.out.println("\nYOU WILL GO TO THE UPSIDE DOWN");
            System.out.println("TO KILL ALL THE MONSTERS!");
            System.out.println("-------------------------------");
        }
    }
}

class Start implements GameStart {
    Scanner sc = new Scanner(System.in);
    public void ForStart() {
        System.out.println("\nP - START");
        System.out.println("X - EXIT");
        System.out.print("ENTER: ");
        String play = sc.nextLine();

        if (play.equalsIgnoreCase("P")) {
            System.out.println("-------------------------------");
            System.out.println("GAME STARTED, GOODLUCK!");
            System.out.println("-------------------------------");
        } else if (play.equalsIgnoreCase("X")) {
            System.out.println("-------------------------------");
            System.out.println("GAME EXIT.");
            System.out.println("-------------------------------");
        }
    }
}