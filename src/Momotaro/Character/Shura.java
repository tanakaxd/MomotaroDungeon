package Momotaro.Character;

public class Shura extends Boss {

    public Shura() {
        super();

        this.setName("修羅");
        this.maxHp = 150;
        this.hp = maxHp;
        this.maxMp = 30;
        this.mp = maxMp;
        this.agi = 30;
        this.att = 13;
        this.def = 5;
        this.isEnemy = true;
        this.hitTimes = 10;

    }
}