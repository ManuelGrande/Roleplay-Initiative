
package initiative;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


public class Game implements Actions{
    
    
    @Override
    public ArrayList<Character> SetNewPlayers(){
        
        ArrayList<Character> Players = new ArrayList<Character>();       
        Scanner sc = new Scanner(System.in);
        int PlayersHuman = 0;
        int PlayersNpc = 0;
        char Control = 'x';        
        
        
        System.out.println("\nPlease determine the number of players (human):");
        PlayersHuman = sc.nextInt();
        System.out.println("\nDo they have modifiers? Y/N");
        while(Control == 'y' ){
            
        }
        
        
        
        
        
        
        
        
        
        System.out.println("\nPlease determine the number of npcs:");
        PlayersNpc = sc.nextInt();
        
        System.out.println("\nPlease insert the Name and modifiers of each player (human).");
        for(int i = 0 ; i<PlayersHuman ; i++){
            Character Char = new Character();
            
            System.out.println("\nName of the Player: ");
            Char.setName(sc.next());
            System.out.println("\nM");
            
            
            
        }
        
        
    }
    
    

    
    
    
    /*
    @Override
    public ArrayList<Character> OrderPlayers(ArrayList<Character> Players){
        
        Random ran = new Random();
        
        
        
        
        
    }*/
     
    
}
