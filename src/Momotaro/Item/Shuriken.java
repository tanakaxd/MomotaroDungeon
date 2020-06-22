package Momotaro.Item;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;

public class Shuriken extends Weapon {
    public Shuriken() {
        this.name = "手裏剣";
        this.att = 2;
        this.rarityRate = 0.2;

        this.skills.add(new Skill("投げる", false, 5, 50, 1, ""));
        this.skills.add(new Skill("かなり投げる", false, 8, 50, 3, ""));
        this.skills.add(new Skill("たくさん投げる", true, 10, 50, 5, ""));
        this.skills.add(new UltimateShuriken("超投げる", false, 1, 500, 9, "戦闘中一回まで使用可能", 1));

    }
}