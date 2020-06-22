package Momotaro.Character;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;
import java.util.List;
import java.util.stream.Collectors;

public class Kintaro extends Hero {
    private static int count = 1;

    public Kintaro() {
        super();
        this.setName("金太郎" + count);
        this.id = 1;
        this.maxHp = 80;
        this.hp = maxHp;
        this.maxMp = 50;
        this.mp = maxMp;
        this.agi = 7;
        this.att = 10;
        this.def = 11;
        this.mnd = 15;
        this.hitTimes = 2;
        this.isEnemy = false;
        this.weapon = new OldBook();
        count++;

    }

}
