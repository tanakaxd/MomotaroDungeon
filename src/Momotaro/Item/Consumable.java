package Momotaro.Item;

import java.util.List;
import java.util.Random;

import Momotaro.Character.FightingObject;

enum ItemCategory {
    DAMAGE, HEAL,

}

public class Consumable extends Item implements ICalcDamageable, Cloneable {

    private ItemCategory category;
    private boolean isAOE;
    private int power;

    public Consumable(String name, ItemCategory category, boolean isAOE, int power) {
        this.name = name;
        this.category = category;
        this.isAOE = isAOE;
        this.power = power;
    }

    @Override
    public boolean calcDamage(FightingObject attacker, List<FightingObject> enemies, List<FightingObject> friends,
            int skillOption) {
        System.out.println(attacker.getName() + "は『" + this.name + "』を使った");

        switch (this.category) {
            case DAMAGE:
                if (this.isAOE) {
                    for (FightingObject e : enemies) {
                        e.getDamage(this.power);
                    }
                } else {
                    FightingObject opponent = enemies.get(new Random().nextInt(enemies.size()));
                    opponent.getDamage(this.power);
                }
                break;
            case HEAL:
                if (this.isAOE) {
                    for (FightingObject f : friends) {
                        f.healHp(this.power);
                    }
                } else {

                    attacker.healHp(this.power);
                }
        }

        return true;
    }

    @Override
    public Consumable clone() {
        Consumable clone = new Consumable(this.name, this.category, this.isAOE, this.power);
        return clone;

    }

    // @Override
    // public String toDetailstring() {
    // TODO

    // }

}