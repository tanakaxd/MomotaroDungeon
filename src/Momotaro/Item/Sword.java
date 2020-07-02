package Momotaro.Item;

import Momotaro.Skill.Busou;
import Momotaro.Skill.Skill;

public class Sword extends Weapon {

    public Sword() {
        this.name = "刀";
        this.att = 8;
        this.rarityRate = 0.3;
        this.skills.add(new Skill("虎狩", false, 1, 70, 3, "通常攻撃"));
        this.skills.add(new Skill("鬼斬り", false, 1, 90, 5, "単体中威力攻撃"));
        this.skills.add(new Skill("竜巻", true, 3, 30, 10, "範囲多段攻撃"));
        this.skills.add(new Busou("武装一文字", false, 1, 200, 10, "戦闘中一回のみ使用可能。相手の防御力を無視してダメージを与える", 1));

    }

}
