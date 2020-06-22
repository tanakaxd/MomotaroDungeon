package Momotaro.Item;

import Momotaro.Skill.Skill;

public class Kusarigama extends Weapon {

    public Kusarigama() {
        this.name = "鎖鎌";
        this.att = 4;
        this.rarityRate = 0.3;
        this.skills.add(new Skill("連鎖", true, 3, 60, 3, ""));
        this.skills.add(new Skill("ダブル連鎖", true, 6, 60, 7, ""));
        this.skills.add(new Skill("頸射", false, 1, 300, 8, ""));
        // this.skills.add(new ("武装一文字", true, 1, 400, 10,
        // "戦闘中一回のみ使用可能。相手の防御力を無視してダメージを与える", 1));

    }

}