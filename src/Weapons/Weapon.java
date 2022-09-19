package Weapons;
import Characters.Character;
public class Weapon {
    public int ID;
    public String Name;
    public int Damage;  
    public int Price;
    public Weapon(int ID,String Name,int Damage,int Price) {
        this.ID=ID;
        this.Name=Name;
        this.Damage=Damage;
        this.Price=Price;
    }
    public void Buy(Character player){
        if(player.Money>=Price){
            player.Money-=this.Price;
            player.weapon=this;
        }
    }
}