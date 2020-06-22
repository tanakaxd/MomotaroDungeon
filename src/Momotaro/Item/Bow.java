package Momotaro.Item;

import Momotaro.Skill.BowUltimateSkill;
import Momotaro.Skill.Skill;

public class Bow extends Weapon {
    public Bow() {
        this.name = "弓";
        this.att = 6;
        this.rarityRate = 0.3;

        this.skills.add(new Skill("間引き", false, 1, 200, 5, ""));
        this.skills.add(new Skill("火矢", false, 1, 250, 8, ""));
        this.skills.add(new Skill("狙い撃ち", true, 1, 350, 12, ""));
        this.skills.add(new BowUltimateSkill("偏差射撃", false, 3, 200, 15, "戦闘中一回のみ使用可能。", 1));

    }
}