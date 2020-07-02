package Momotaro.Character;

public class Nue extends Monster {

    public Nue() {
        super();

        this.setName("鵺" + count);
        this.id = count;
        this.maxHp = 30;
        this.hp = maxHp;
        this.maxMp = 30;
        this.mp = maxMp;
        this.agi = 12;
        this.att = 15;
        this.def = 8;
        this.isEnemy = true;
        this.hitTimes = 2;

    }
}