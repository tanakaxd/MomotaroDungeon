package Momotaro.Character;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;

public class Ochimusha extends Monster {

    public Ochimusha() {
        super();

        this.setName("落武者" + count);
        this.id = count;
        this.maxHp = 10;
        this.hp = maxHp;
        this.maxMp = 0;
        this.mp = maxMp;
        this.agi = 1;
        this.att = 20;
        this.def = 10;
        this.mnd = 2;
        this.isEnemy = true;
        this.hitTimes = 1;

    }
}