package Momotaro.Item;

import Momotaro.Skill.*;

public class Hammer extends Weapon {
    public Hammer() {
        this.name = "大槌";
        this.att = 10;
        this.rarityRate = 0.1;

        this.skills.add(new Skill("微スウィング", false, 1, 120, 4, ""));
        this.skills.add(new Skill("スウィング", false, 1, 210, 7, ""));
        this.skills.add(new Skill("回転スウィング", true, 1, 100, 15, ""));
        this.skills.add(new HammerUltimateSkill("超振り下ろしスウィング", false, 1, 300, 20, "戦闘中一回のみ使用可能。相手の防御が高いほどダメージ上昇", 1));

    }
}