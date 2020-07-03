package Momotaro.Character;

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
        this.att = 13;
        this.def = 20;
        this.isEnemy = true;
        this.hitTimes = 1;

    }
}