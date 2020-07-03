package Momotaro.Item;

import Momotaro.Skill.BowUltimateSkill;
import Momotaro.Skill.Skill;

public class Bow extends Weapon {
    public Bow() {
        this.name = "弓";
        this.att = 2;
        this.rarityRate = 0.3;

        this.skills.add(new Skill("間引き", false, 1, 70, 3, ""));
        this.skills.add(new Skill("火矢", false, 1, 90, 5, ""));
        this.skills.add(new Skill("狙い撃ち", false, 1, 120, 7, ""));
        this.skills.add(new BowUltimateSkill("偏差射撃", false, 3, 90, 15, "戦闘中一回のみ使用可能。", 1));

    }
}