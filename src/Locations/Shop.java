package Locations;
import java.util.ArrayList;

import Managers.LineStringCreaters;
import Weapons.Weapon;
import Armors.Armor;

public class Shop extends Location{
    
	public ArrayList<Weapon> sWeapons=new ArrayList<Weapon>();
    public ArrayList<Armor> sArmors=new ArrayList<Armor>();
    public String Name="Shop";
    public int ID=0;
    public boolean isInShop=false;

    public Shop(int ID, String Name) {
        super(ID,Name,null);
		this.ID=ID;
        this.Name=Name;
        
        sWeapons.add(new Weapon(1, "Pistol", 2, 25));
        sWeapons.add(new Weapon(2, "Sword ", 3, 35));
        sWeapons.add(new Weapon(3, "Riffle", 7,45));
        
        sArmors.add(new Armor(4, "Light ", 15, 1));
        sArmors.add(new Armor(5, "Middle", 25, 3));
        sArmors.add(new Armor(6, "Heavy ", 40, 5));
	}
    @Override
    public void InAction() {
        ListShopItems();
        
    }

    LineStringCreaters LineCreater =new LineStringCreaters();
    public void ListShopItems(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        isInShop=true;
        System.out.println(LineCreater.CreateLine(20, "=", false)+"Shop"+LineCreater.CreateLine(20, "=", false));
        System.out.println("[Caution]> Buying new item,removes old item");
        ListWeapons();
        ListArmors();
        LineCreater.CreateLine(44, "=", true);
        System.out.println("[EXIT  ]> ID: 0");
    }
    public void ListWeapons(){
        System.out.println(LineCreater.CreateLine(3, "-", false)+"Weapons");
        for (int i = 0; i < sWeapons.size(); i++) {
            System.out.println("["+sWeapons.get(i).Name+"]> "+"ID: "+sWeapons.get(i).ID+" |Damage   :"+sWeapons.get(i).Damage+" |Price: "+sWeapons.get(i).Price);
        }
    }
    public void ListArmors(){
        System.out.println(LineCreater.CreateLine(3, "-", false)+"Armors");
        for (int i = 0; i < sArmors.size(); i++) {
            System.out.println("["+sArmors.get(i).Name+"]> "+"ID: "+sArmors.get(i).ID+" |Blocking: "+sArmors.get(i).Blocking+" |Price: "+sArmors.get(i).Price);
        }
    }
}
