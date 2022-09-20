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
/**
 * Character.Attack
 * @return (int) Damage Power
 */
    public int Attack()
    {
        if(this.weapon!=null){
            return this.Damage+this.weapon.Damage;
        }
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
        System.out.println("Its seems like an you are in safe place");
        System.out.println("Your health is full again,be careful next time!");
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
        LineCreater.CreateLine(20,"=",true);
        System.out.println("|ID     :"+ID);
        System.out.println("|Name   :"+Name);
        System.out.println("|Health :"+Health);
        System.out.println("|Damage :"+Damage);
        System.out.println("|Money  :"+Money);
        LineCreater.CreateLine(20,"=",true);
    }
    public Armor GetArmor(){
        return (this.armor==null)?null:this.armor;
    }
}
