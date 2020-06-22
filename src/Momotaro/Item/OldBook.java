package Momotaro.Item;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;

public class OldBook extends Weapon {

    public OldBook() {
        this.name = "古本";
        this.att = 1;
        this.rarityRate = 0.1;
        this.skills.add(new Skill("本殴り", false, 2, 120, 3, ""));
        this.skills.add(new Skill("本投げ", false, 2, 200, 8, ""));
        // this.skills.add(new Skill("竜巻", true, 3, 30, 8, "範囲多段攻撃"));
        this.skills.add(new Knowledge("英知", false, 1, 300, 20, "戦闘中一回のみ使用可能。仲間全員を回復する", 1));

    }

}