package Monsters;

import Characters.Character;
import Managers.LineStringCreaters;

public class Monster {
    public int ID;
    public String Name;
    public int Money;
    public int Damage;
    public int Health;
    public boolean isAlive = true;
    LineStringCreaters LineCreater = new LineStringCreaters();

    public Monster(int ID, String Name, int Money, int Damage, int Health) {
        this.ID = ID;
        this.Name = Name;
        this.Money = Money;
        this.Damage = Damage;
        this.Health = Health;
    }

    public void TakeDamage(int DamagePower) {
        if (isAlive) {
            LineCreater.CreateLine(20, "=", true);
            System.out.println("You Hit " + DamagePower + " Damage !!!");
            this.Health -= DamagePower;
            if (this.Health <= 0) {
                this.isAlive = false;
                System.out.println("[Dead ]> "+this.Name);
                LineCreater.CreateLine(20, "=", true);
            } else {
                System.out.println(this.Name + " IS DYING !!! [Health: " + this.Health + " ]");
            }
        }
    }
/**
 * Monster.Attack
 */
    public void Attack(Character player) {
        System.out.println(this.Name + " is Attacking!! |Damage: "+this.Damage);
        player.TakeDamage(this.Damage);
        System.out.println("Your |Health: " + player.Health 
        + " |Armor: "+ ((player.GetArmor() == null) ? "No Armor" : player.armor.Blocking));
        LineCreater.CreateLine(20, "=", true);
    }
}
