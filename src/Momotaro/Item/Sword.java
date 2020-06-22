package Momotaro.Item;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;
import java.util.List;
import java.util.Random;

public class Sword extends Weapon {

    public Sword() {
        this.name = "刀";
        this.att = 8;
        this.rarityRate = 0.3;
        this.skills.add(new Skill("虎狩", false, 1, 150, 3, "通常攻撃"));
        this.skills.add(new Skill("鬼斬り", false, 1, 210, 5, "単体中威力攻撃"));
        this.skills.add(new Skill("竜巻", true, 3, 40, 8, "範囲多段攻撃"));
        this.skills.add(new Busou("武装一文字", false, 1, 400, 10, "戦闘中一回のみ使用可能。相手の防御力を無視してダメージを与える", 1));

    }

}
