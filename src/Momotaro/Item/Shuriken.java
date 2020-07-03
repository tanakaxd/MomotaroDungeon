package Momotaro.Item;

import Momotaro.Skill.Skill;
import Momotaro.Skill.UltimateShuriken;

public class Shuriken extends Weapon {
    public Shuriken() {
        this.name = "手裏剣";
        this.att = 1;
        this.rarityRate = 0.2;

        this.skills.add(new Skill("投げる", false, 5, 10, 1, ""));
        this.skills.add(new Skill("かなり投げる", false, 8, 10, 3, ""));
        this.skills.add(new Skill("たくさん投げる", true, 3, 10, 6, ""));
        this.skills.add(new UltimateShuriken("超投げる", false, 3, 120, 9, "戦闘中一回まで使用可能", 1));

    }
}