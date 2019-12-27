package initiative;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

/*
    1-chusmear scanner si hay que resetearlo
    2-que solo se pueda insertar Y/N con un try catch i guess
 */
public class Game implements Actions {

    public Game() {
    }

    @Override
    public ArrayList<Character> SetNewPlayers() {

        ArrayList<Character> Players = new ArrayList<Character>();
        Scanner sc = new Scanner(System.in);
        int PlayersHuman = 0;
        int Modifier = 0;
        int PlayersNpc = 0;
        char ControlModifier = 'x';
        boolean Ready = false;

        while (Ready == false) {

            try {

                if (PlayersHuman == 0) {
                    System.out.println("\nPlease determine the number of players (human):");
                    PlayersHuman = sc.nextInt();
                }

                if (ControlModifier == 'x') {
                    System.out.println("\nDo they have initiative modifiers? Y/N");
                    ControlModifier = sc.next().charAt(0);

                    if (ControlModifier != 'y' && ControlModifier != 'n') {
                        throw new YesOrNoAnswerException();
                    } 
                    else if (ControlModifier == 'y') {
                        System.out.println("\ninserto y");
                    } 
                    else {
                        System.out.println("\ninserto n");
                    }
                }
                
                System.out.println("\nPlease provide the information of every character.");
                for(int i = 0 ; i < PlayersHuman ; i++){
                    sc.nextLine();
                    Character c = new Character();
                    System.out.println("\nNew character´s name: ");
                    c.setName(sc.next());
                    System.out.println("\nNew character´s initiative modifier");
                    
                    
                    
                }
                
                
                

            } 
            catch (InputMismatchException e) {
                System.out.println("\nError: The values inserted are not the"
                        + "values expected, please try again.");
                sc.nextLine();
            } 
            catch (YesOrNoAnswerException e) {
                System.out.println("\nError: Please insert only Y or N.");
                ControlModifier = 'x';
                sc.nextLine();
            }

        }

        return Players;

    }

}
/*
    @Override
    public ArrayList<Character> OrderPlayers(ArrayList<Character> Players){
        
        Random ran = new Random();
        
        
        
        
        
    }*/
