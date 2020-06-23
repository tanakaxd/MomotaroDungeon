package Momotaro.Character;

public class Kappa extends Monster {

    public Kappa() {
        super();

        this.setName("河童" + count);
        this.id = count;
        this.maxHp = 30;
        this.hp = maxHp;
        this.maxMp = 15;
        this.mp = maxMp;
        this.agi = 10;
        this.att = 10;
        this.def = 5;
        this.mnd = 12;
        this.isEnemy = true;
        this.hitTimes = 1;

    }
}