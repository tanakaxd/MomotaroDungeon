package Momotaro.Item;

import Momotaro.Skill.Skill;

public class Pistol extends Weapon {

    public Pistol() {
        this.name = "ピストル";
        this.att = 0;
        this.rarityRate = 0.1;

        this.skills.add(new Skill("ショット", false, 1, 80, 2, ""));
        this.skills.add(new Skill("マルチショット", false, 1, 100, 4, ""));
        this.skills.add(new Skill("ブラインドショット", false, 1, 120, 6, ""));
        this.skills.add(new Skill("過激ショット", false, 1, 300, 9, ""));

    }
}