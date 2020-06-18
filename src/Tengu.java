import java.util.List;
import java.util.Random;

public class Tengu extends FightingObject {

    private static int count = 0;

    public Tengu(String name) {
        super();
        count++;

        this.setName(name + count);
        this.id = count;
        this.maxHp = 20;
        this.hp = maxHp;
        this.maxMp = 30;
        this.mp = maxMp;
        this.agi = 20;
        this.att = 7;
        this.def = 0;
        this.mnd = 10;
        this.isDead = false;
        this.isEnemy = true;
        this.isActive = true;
    }

    @Override
    protected void doAttack(List<FightingObject> targets) {
        FightingObject opponent = targets.get(new Random().nextInt(targets.size()));
        int damage = (getAtt() - opponent.getDef());
        displayAttack(opponent, damage);

    }

    protected void displayAttack(FightingObject opponent, int damage) {
        // 最低1ダメージ
        damage = Math.max(1, damage);
        System.out.println(opponent.getName() + "に" + damage + "ダメージ!");
        opponent.setHp(opponent.getHp() - damage);
    }
}