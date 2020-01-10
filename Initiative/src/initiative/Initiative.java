
package initiative;

import java.util.ArrayList;


public class Initiative {

   /*
    posición = iniciativa
   
    los modificadores pueden o no estar en cada turno
    
    combate es hasta que uno de los dos equipos muera completo
    
    cuando termina un turno preguntar quien murió y si hay nuevos modificadores
    
    
    */
    public static void main(String[] args) {
        
       
        
        
        System.out.println("Welcome to the ROLEPLAY-INITIATIVE-ENFORCER Deluxe Edition.");
       
        ArrayList<Character> CurrentParty = new ArrayList<Character>();
                
        Game game = new Game();
        
   
        
        for(Character c : game.SetNewPlayers()){
            System.out.println("\nNombre:"+c.getName()+"\nModificador: "+c.getModifier()+"\nPosición:"+c.getPosition()+"\n");
            
        }
        
        
            
            
            
        
        
        
    }
    
}
