package Momotaro.Item;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;

public class Pistol extends Weapon {

    public Pistol() {
        this.name = "ピストル";
        this.att = 10;
        this.rarityRate = 0.1;

        this.skills.add(new Skill("ショット", false, 1, 120, 2, ""));
        this.skills.add(new Skill("マルチショット", false, 1, 210, 4, ""));
        this.skills.add(new Skill("ブラインドショット", false, 1, 300, 6, ""));
        this.skills.add(new Skill("過激ショット", false, 1, 500, 9, ""));

    }
}