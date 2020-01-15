package initiative;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;

/*
    chusmear cuando inserto otro que no sea y/n para que no te mande al principio

 */
public class Game implements Actions {

    public Game() {
    }

    private ArrayList<Character> SetPlayersHuman() {

        ArrayList<Character> Players = new ArrayList<Character>();
        Scanner sc = new Scanner(System.in);
        int PlayersHuman = 0;
        int Modifier = 0;
        char ControlModifier = 'x';
        boolean Ready = false;

        while (Ready == false) {

            try {

                if (PlayersHuman == 0) {
                    System.out.println("\nPlease determine the number of players (human):");
                    PlayersHuman = sc.nextInt();
                }

                /*
                if (ControlModifier == 'x') {
                    System.out.println("\nDo they have initiative modifiers? Y/N");
                    ControlModifier = sc.next().charAt(0);

                    if (ControlModifier != 'y' && ControlModifier != 'n') {
                        throw new YesOrNoAnswerException();
                    } 
                    else if (ControlModifier == 'y') {
                        
                        System.out.println("\nWhat is the value of the initiative modifier?:");
                        Modifier = sc.nextInt();
                    } 
                }
                 */
                System.out.println("\nPlease provide the information of every character.");
                for (int i = 0; i < PlayersHuman; i++) {

                    System.out.println("\nPlayer nº:" + i + "/" + PlayersHuman);

                    Character c = new Character();
                    System.out.println("\nNew character´s name: ");
                    c.setName(sc.next());

                    System.out.println("\nDoes " + c.getName() + " have initiative modifiers? Y/N");
                    ControlModifier = sc.next().charAt(0);

                    if (ControlModifier != 'y' && ControlModifier != 'n') {
                        throw new YesOrNoAnswerException();
                    } else if (ControlModifier == 'y') {

                        System.out.println("\nWhat is the value of the initiative modifier?:");
                        c.setModifier(sc.nextInt());
                    }

                    Players.add(c);
                    sc.nextLine();

                }
                Ready = true;
            } catch (InputMismatchException e) {
                System.out.println("\nError: The values inserted are not the"
                        + " values expected, please try again.");
                sc.nextLine();
            } catch (YesOrNoAnswerException e) {
                System.out.println("\nError: Please insert only Y or N.");
                ControlModifier = 'x';
                sc.nextLine();
            }
        }

        return Players;

    }

    private ArrayList<Character> SetPlayersNpc() {

        ArrayList<Character> Npcs = new ArrayList<Character>();
        Scanner sc = new Scanner(System.in);
        int PlayersNpc = 0;
        int Modifier = 0;

        char ControlModifier = 'x';
        boolean Ready = false;

        while (Ready == false) {

            try {

                if (PlayersNpc == 0) {
                    System.out.println("\nPlease determine the number of players (npc):");
                    PlayersNpc = sc.nextInt();
                }
                /*
                if (ControlModifier == 'x') {
                    System.out.println("\nDo they have initiative modifiers? Y/N");
                    ControlModifier = sc.next().charAt(0);

                    if (ControlModifier != 'y' && ControlModifier != 'n') {
                        throw new YesOrNoAnswerException();
                    } 
                    else if (ControlModifier == 'y') {
                        
                        System.out.println("\nWhat is the value of the initiative modifier?:");
                        Modifier = sc.nextInt();
                    } 
                }
                 */

                for (int i = 0; i < PlayersNpc; i++) {
                    Character c = new Character();

                    c.setName(i + "-npc");

                    System.out.println("\nDoes " + c.getName() + " have initiative modifiers? Y/N");
                    ControlModifier = sc.next().charAt(0);

                    if (ControlModifier != 'y' && ControlModifier != 'n') {
                        throw new YesOrNoAnswerException();
                    } else if (ControlModifier == 'y') {

                        System.out.println("\nWhat is the value of the initiative modifier?:");
                        c.setModifier(sc.nextInt());
                    }

                    Npcs.add(c);

                }
                Ready = true;
            } catch (InputMismatchException e) {
                System.out.println("\nError: The values inserted are not the "
                        + "values expected, please try again.");
                sc.nextLine();
            } catch (YesOrNoAnswerException e) {
                System.out.println("\nError: Please insert only Y or N.");
                ControlModifier = 'x';
                sc.nextLine();
            }

        }

        return Npcs;

    }

    private ArrayList<Character> SetPositionValues(ArrayList<Character> Players) {

        Random ran = new Random();

        for (Character c : Players) {
            c.setPosition((int) (ran.nextDouble() * 20 + 1));

            if (c.getModifier() != 0) {

                if (c.getPosition() + c.getModifier() >= 0) {

                    c.setPosition(c.getPosition() + c.getModifier());
                } else {
                    c.setPosition(1);
                }
            }
        }

        return Players;

    }

    @Override
    public ArrayList<Character> SetNewPlayers() {

        ArrayList<Character> AllPlayers = new ArrayList<Character>();

        AllPlayers.addAll(SetPlayersHuman());
        AllPlayers.addAll(SetPlayersNpc());

        AllPlayers = SetPositionValues(AllPlayers);

        Collections.sort(AllPlayers, new Comparator<Character>() {

            public int compare(Character c1, Character c2) {
                return Integer.valueOf(c2.getPosition()).compareTo(c1.getPosition());
            }

        });

        return AllPlayers;

    }

    private int GetIndexFromName(ArrayList<Character> Players) {
        int Index = -1;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nPlease enter the name of the player:");
        String Name = sc.next();

        while (Index == -1) {

            for (Character c : Players) {
                if (c.getName().equals(Name)) {

                    Index = Players.indexOf(c);
                }
            }
            if (Index == -1) {

                System.out.println("\nError: The name inserted was not found."
                        + "Please insert the name again:");
                Name = sc.next();
            }

        }

        return Index;
    }

    private void SetNewModifier(Character c) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nPlease insert the new value of " + c.getName() + "´s modifier:");
        c.setModifier(sc.nextInt());

    }

    private void ShowDeadPlayers(ArrayList<Character> Players) {

        System.out.println("\nList of dead players:\n");

        for (Character c : Players) {
            if (c.isAlive() == false) {
                System.out.println("\n[" + c.getName() + "]");
            }
        }

    }

    private void NewRound(ArrayList<Character> Players) {
        int pos = 1;
        Scanner sc = new Scanner(System.in);

        Players = SetPositionValues(Players);

        Collections.sort(Players, new Comparator<Character>() {

            public int compare(Character c1, Character c2) {
                return Integer.valueOf(c2.getPosition()).compareTo(c1.getPosition());
            }

        });

        for (Character c : Players) {
            if (c.isAlive() == true) {
                System.out.println("\nPos" + pos + "º: [" + c.getName() + "]");
                pos++;
            }
        }

        System.out.println("\nPress Any Key To Continue...");
        sc.nextLine();

    }

    public void Start() {
        Scanner sc = new Scanner(System.in);
        int Round = 0;
        boolean endGame = false;
        int Choice = -1;

        ArrayList<Character> Players = SetNewPlayers();

        while (endGame == false) {

            System.out.println("\nRound nº" + Round + ".");

            NewRound(Players);

            while (Choice != 1) {

                System.out.println("\nPlease select an option to continue:");
                System.out.println("\nInsert 1 to continue to the next round.");
                System.out.println("\nInsert 2 if a player died.");
                System.out.println("\nInsert 3 if a player was resurrected.");
                System.out.println("\nInsert 4 to change a modifier of a player.");
                System.out.println("\nInsert 5 to end the game.");
                Choice = sc.nextInt();
                sc.nextLine();

                switch (Choice) {

                    case 1:
                        Round++;
                        System.out.println("\nStarting a new round...");
                        System.out.println("\nPress Any Key To Continue...");
                        sc.nextLine();
                        break;
                    case 2:
                        Players.get(GetIndexFromName(Players)).setAlive(false);
                        System.out.println("\nPlayer set dead successfuly!");
                        System.out.println("\nPress Any Key To Continue...");
                        sc.nextLine();
                        break;
                    case 3:
                        ShowDeadPlayers(Players);
                        Players.get(GetIndexFromName(Players)).setAlive(true);
                        System.out.println("\nPlayer set alive  successfuly!");
                        System.out.println("\nPress Any Key To Continue...");
                        sc.nextLine();
                        break;
                    case 4:
                        SetNewModifier(Players.get(GetIndexFromName(Players)));
                        System.out.println("\nPlayer´s new modifier set succefully!");
                        System.out.println("\nPress Any Key To Continue...");
                        sc.nextLine();
                        break;
                    case 5:
                        endGame = true;
                        break;
                    default:
                        System.out.println("\nError: option inserted is not valid.Press any key to try again...");
                        sc.nextLine();
                }
            }

            Choice = -1;

        }

    }

    /*
    public ArrayList<Character> Game(ArrayList<Character> Players){
        
        
        
        
        
    }
     */
}
