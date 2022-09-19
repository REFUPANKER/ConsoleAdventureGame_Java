package Locations;
import Characters.Character;
import Managers.*;
public class Location {
    public int ID;
    public String Name;
    public Character Player;
    // TODO : Tool
    // TODO : Monster
    // TODO : Gift
    public Location(int ID,String Name) {
        this.ID=ID;
        this.Name=Name;
    }
    LineStringCreaters LineCreater=new LineStringCreaters();
    public void InAction(){
        System.out.print((LineCreater.CreateLine(5, "=", false))+this.Name+(LineCreater.CreateLine(5, "=", false)));
        
    }
}
