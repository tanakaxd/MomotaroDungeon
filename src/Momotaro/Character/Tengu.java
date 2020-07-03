package Momotaro.Character;

public class Tengu extends Monster {

    public Tengu() {
        super();

        this.setName("天狗" + count);
        this.id = count;
        this.maxHp = 20;
        this.hp = maxHp;
        this.maxMp = 30;
        this.mp = maxMp;
        this.agi = 20;
        this.att = 4;
        this.def = 0;
        this.isEnemy = true;
        this.hitTimes = 3;

    }
}