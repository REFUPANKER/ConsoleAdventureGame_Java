package Characters;

import Managers.LineStringCreaters;
import Weapons.*;
import Armors.*;
import Locations.*;
public class Character {
    public int ID;
    public String Name;
    public int Damage;
    public int Health;
    public int Money;
    public Weapon weapon;
    public Armor armor;
    public boolean isFighting=false;
    public Location pLocation=null;

    private int DefaultHealth;
    
    public Character(int ID,String Name,int Damage,int Health,int Money) {
        this.DefaultHealth=Health;
        this.ID=ID;
        this.Name=Name;
        this.Damage=Damage;
        this.Health=Health;
        this.Money=Money;
    }

    public int Attack()
    {
        return this.Damage;
    }

    public void TakeDamage(int damage){
        if(armor!=null){
            armor.Blocking-=1;
            if(armor.Blocking<=0){
                System.out.println("Armor Broken!!");
                armor=null;
            }
        }else{
            this.Health-=damage;
        }
        
        isDead();
    }

    public void TakeHealth(int health){
        this.Health+=(this.Health+health<=21)?health:21-this.Health;
    }
    public void RegenHealth(){
        this.Health=DefaultHealth;
    }

    public boolean isDead(){
        if(this.Health<=0){
            return true;
        }
        return false;
    }

    LineStringCreaters LineCreater=new LineStringCreaters();
    public void ShowProperties(){
        LineCreater.CreateLine(15+Name.length(),"=",true);
        System.out.println("|ID\t:"+ID);
        System.out.println("|Name\t:"+Name);
        System.out.println("|Health\t:"+Health);
        System.out.println("|Damage\t:"+Damage);
        System.out.println("|Money\t:"+Money);
        LineCreater.CreateLine(15+Name.length(),"=",true);
    }
    public Armor GetArmor(){
        return (this.armor==null)?null:this.armor;
    }
}
