package Momotaro.Item;

import Momotaro.Skill.Skill;

public class Sude extends Weapon {

    public Sude() {
        this.name = "素手";
        this.att = 0;
        this.rarityRate = 0.3;

        this.skills.add(new Skill("パンチ", false, 1, 50, 2));
        this.skills.add(new Skill("キック", false, 1, 80, 4));
        this.skills.add(new Skill("連撃", false, 5, 30, 8));

    }

}