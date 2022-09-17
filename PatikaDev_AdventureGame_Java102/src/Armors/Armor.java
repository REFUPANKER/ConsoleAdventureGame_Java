package Armors;
import Characters.Character;
public class Armor {
    public int ID;
    public String Name;
    public int Price;
    public int Blocking;
    public Armor(int ID,String Name,int Price,int Blocking) {
        this.ID=ID;
        this.Name=Name;
        this.Price=Price;
        this.Blocking=Blocking;
    }
    public void Buy(Character player){
        if(player.Money>=Price){
            player.Money-=this.Price;
            player.armor=this;
        }
    }
}
