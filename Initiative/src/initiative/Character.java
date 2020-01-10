
package initiative;



public class Character {
    
    private String Name;
    
    private int Position;
    
    private boolean Alive;
    
    private int Modifier;

    public String getName() {
        return Name;
    }
    public int getPosition() {
        return Position;
    }
    public boolean isAlive() {
        return Alive;
    }
    public int getModifier() {
        return Modifier;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public void setPosition(int Position) {
        this.Position = Position;
    }
    public void setAlive(boolean Alive) {
        this.Alive = Alive;
    }
    public void setModifier(int Modifier) {
        this.Modifier = Modifier;
    }   
    

    public Character(String Name,int Modifier) {
        setName(Name);
        setModifier(Modifier);
        setAlive(true);
        setPosition(0);
    }
    public Character(){
        setName("Not Assigned");
        setModifier(0);
        setAlive(true);
        setPosition(0);
    }
    
    
    
    
    
}
