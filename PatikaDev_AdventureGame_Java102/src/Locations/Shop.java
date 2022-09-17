package Locations;
import java.util.ArrayList;

import Managers.LineStringCreaters;
import Managers.ShortOutputCommands;
import Weapons.Weapon;
import Armors.Armor;

public class Shop extends ShortOutputCommands{
    public ArrayList<Weapon> sWeapons=new ArrayList<Weapon>();
    public ArrayList<Armor> sArmors=new ArrayList<Armor>();
    public String Name="Shop";
    public Shop() {
        sWeapons.add(new Weapon(1, "Pistol", 2, 25));
        sWeapons.add(new Weapon(2, "Sword", 3, 35));
        sWeapons.add(new Weapon(3, "Riffle", 7,45));
        
        sArmors.add(new Armor(1, "Light", 15, 1));
        sArmors.add(new Armor(2, "Middle", 25, 3));
        sArmors.add(new Armor(3, "Heavy", 40, 5));
    }
    LineStringCreaters LineCreater =new LineStringCreaters();
    public void ListShopItems(){
        cwl("[Caution] Buying new item,removes old item");
        cwl(LineCreater.CreateLine(5, "=", false)+"Shop"+LineCreater.CreateLine(5, "=", false));
        ListWeapons();
        ListArmors();
    }
    public void ListWeapons(){
        cwl(LineCreater.CreateLine(3, "-", false)+"Weapons");
        for (int i = 0; i < sWeapons.size(); i++) {
            cwl("["+sWeapons.get(i).Name+"]> "+sWeapons.get(i).ID+" |Damage: "+sWeapons.get(i).Damage+" |Price: "+sWeapons.get(i).Price);
        }
    }
    public void ListArmors(){
        cwl(LineCreater.CreateLine(3, "-", false)+"Armors");
        for (int i = 0; i < sArmors.size(); i++) {
            cwl("["+sArmors.get(i).Name+"]> "+sArmors.get(i).ID+" |Blocking: "+sArmors.get(i).Blocking+" |Price: "+sArmors.get(i).Price);
        }
    }
}
