package Momotaro.Character;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;

public class Nue extends Monster {

    public Nue() {
        super();

        this.setName("鵺" + count);
        this.id = count;
        this.maxHp = 40;
        this.hp = maxHp;
        this.maxMp = 30;
        this.mp = maxMp;
        this.agi = 12;
        this.att = 15;
        this.def = 10;
        this.mnd = 10;
        this.isEnemy = true;
        this.hitTimes = 2;

    }
}