package Momotaro.Character;

public class Nue extends Monster {

    public Nue() {
        super();

        this.setName("鵺" + count);
        this.id = count;
        this.maxHp = 50;
        this.hp = maxHp;
        this.maxMp = 30;
        this.mp = maxMp;
        this.agi = 12;
        this.att = 10;
        this.def = 10;
        this.isEnemy = true;
        this.hitTimes = 1;

    }
}