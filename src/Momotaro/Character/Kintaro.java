package Momotaro.Character;

import Momotaro.Item.OldBook;

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
        this.hitTimes = 2;
        this.isEnemy = false;
        this.weapon = new OldBook();
        count++;

    }

}
