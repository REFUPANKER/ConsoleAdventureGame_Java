package Locations;

import java.util.*;

import Characters.Character;
import Managers.*;
import Monsters.*;
/**
* in Constructor : sets variables
<br></br>
* for Activating [RUN] : "InAction" Method
*/
public class Location {
    public int ID;
    public String Name;
    public Character Player;
    // TODO : Tool
    public Monster MonsterType;
    public ArrayList<Monster> LocalMonsters=new ArrayList<Monster>();
    private int MonsterCount=0;

    // TODO : Gift
    public Location(int ID, String Name, Monster MonsterType) {
        this.ID = ID;
        this.Name = Name;
        this.MonsterType=MonsterType;
    }

    public void GenerateMonsters() {
        if (MonsterType == null) {
            System.out.println("[Info]> No Monsters Here o_o ");
        } else {
            Random rnd1 = new Random();
            MonsterCount=rnd1.nextInt(3)+1;

            if(MonsterCount!=0){
                System.out.println("[Bad News]> There are "+MonsterCount+" Monsters");
                System.out.println("--> "+MonsterType.Name+" > "+"|Damage: "+MonsterType.Damage+" |Health: "+MonsterType.Health+" |Money: "+MonsterType.Money);
            }else{
                System.out.println("[Good News]> I can't see any Monster here");
            }
            
            for (int index = 0; index < MonsterCount; index++) {
                LocalMonsters.add(new Monster(
                    MonsterType.ID,
                    MonsterType.Name,
                    MonsterType.Money,
                    MonsterType.Damage,
                    MonsterType.Health
                ));
            }
        }
    }
    public void AttackToMonster(){
        CheckMonsters();
        Reminders();
        System.out.println("[Alive Monsters]> "+LocalMonsters.size());
        if(LocalMonsters.size()>0){
            LocalMonsters.get(0).TakeDamage(Player.Damage);
            LocalMonsters.get(0).Attack(Player);
        }else{
            Player.Money+=MonsterType.Money;
            System.out.println("You Killed All Monsters And Earn "+MonsterType.Money+" Money");
            System.out.println("");
        }
    }
    void CheckMonsters()
    {
        for (int i = 0; i < LocalMonsters.size(); i++) {
            if(LocalMonsters.get(i).isAlive==false){
                LocalMonsters.remove(i);
            }
        }
        
    }
    void Reminders(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("[Attack ]> ID: 1");
        System.out.println("[Escape ]> ID: 0");
    }

    LineStringCreaters LineCreater = new LineStringCreaters();

    public void InAction() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println((LineCreater.CreateLine(5, "=", false)) + this.Name + (LineCreater.CreateLine(5, "=", false)));
        GenerateMonsters();
        System.out.println("[Escape ]> ID: 0");
    }
}
