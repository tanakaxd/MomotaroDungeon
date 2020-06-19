import java.util.List;
import java.util.Random;

public abstract class Monster extends FightingObject {

    protected static int count = 0;
    protected int hitTimes;

    public Monster() {
        super();
        count++;
        this.setName(name + count);
    }

    @Override
    protected void doAttack(List<FightingObject> targets) {
        FightingObject opponent = targets.get(new Random().nextInt(targets.size()));
        int damage = (getAtt() - opponent.getDef());
        damage = Math.max(1, damage);
        for (int i = 0; i < hitTimes; i++) {
            displayAttack(opponent, damage);

        }

    }

    protected void displayAttack(FightingObject opponent, int damage) {
        System.out.println(opponent.getName() + "に" + damage + "ダメージ!");
        opponent.setHp(opponent.getHp() - damage);
    }

}