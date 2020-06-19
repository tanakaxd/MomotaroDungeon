import java.util.List;
import java.util.Random;

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
        this.att = 7;
        this.def = 0;
        this.mnd = 10;
        this.isEnemy = true;
        this.hitTimes = 5;

    }
}