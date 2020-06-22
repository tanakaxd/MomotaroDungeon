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

public class Sude extends Weapon {

    public Sude() {
        this.name = "素手";
        this.att = 0;
        this.rarityRate = 0.3;

        this.skills.add(new Skill("パンチ", false, 1, 110, 2));
        this.skills.add(new Skill("キック", false, 1, 210, 4));
        this.skills.add(new Skill("連撃", false, 5, 60, 7));

    }

}