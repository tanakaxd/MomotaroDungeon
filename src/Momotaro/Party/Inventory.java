package Momotaro.Party;

import java.util.ArrayList;
import java.util.List;

import Momotaro.Item.Consumable;
import Momotaro.Item.Item;
import Momotaro.Item.Weapon;

public class Inventory {
    private List<Weapon> weapons = new ArrayList<>();
    private List<Consumable> consumables = new ArrayList<>();

    private int weaponsLimit;
    private int consumablesLimit;

    public Inventory() {
        weaponsLimit = 10;
        consumablesLimit = 5;
    }

    public void printWeapons() {
        for (int i = 0; i < weapons.size(); i++) {
            int num = i + 1;
            System.out.println(" " + num + " --> " + weapons.get(i).toDetailString());
        }
    }

    public void printConsumbales() {
        for (int i = 0; i < consumables.size(); i++) {
            int num = i + 1;
            System.out.println(" " + num + " --> " + consumables.get(i).toDetailString());
        }

    }

    public void addConsumable(Consumable c) {
        if (consumables.size() >= consumablesLimit) {
            System.out.println("これ以上持てない");
            return;
        }
        consumables.add(c);
    }

    public void addWeapon(Weapon weapon) {
        if (weapons.size() >= weaponsLimit) {
            System.out.println("これ以上持てない");
            return;
        }
        weapons.add(weapon);
    }

    public void addItem(Item item) {
        if (item instanceof Weapon) {
            addWeapon((Weapon) item);
        } else if (item instanceof Consumable) {
            addConsumable((Consumable) item);
        } else {

            System.out.println("invalid item class");
        }
    }

    public void removeWeapon(Weapon weapon) {
        weapons.remove(weapon);
    }

    public void removeConsumables(Consumable c) {
        consumables.remove(c);
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Consumable> getConsumables() {
        return consumables;
    }

    public void setConsumables(List<Consumable> consumables) {
        this.consumables = consumables;
    }

}