import java.util.List;
import java.util.Random;

public class Busou extends UltimateSkill {

    public Busou(String name, boolean isAOE, int times, int damageCoefficient, int mpConsumption, String description) {
        super(name, isAOE, times, damageCoefficient, mpConsumption, description);
        this.maxCharge = 1;
        // this.charge = this.maxCharge;
        super.refill();
        System.out.println("Busou Constructor");
        System.out.println(charge);

        // なぜ使えないのかわからない
    }

    @Override
    public boolean doUltimate(FightingObject attacker, List<FightingObject> targets, Weapon weapon) {
        if (this.charge <= 0) {

            System.out.println("charge <=0");

            return false;
        }

        FightingObject opponent = targets.get(new Random().nextInt(targets.size()));
        int damage = (int) ((attacker.getAtt() + weapon.att) * ((double) getDamageCoefficient() / 100));
        damage = Math.max(1, damage);
        System.out.println(opponent.getName() + "に" + damage + "ダメージ!");
        opponent.setHp(opponent.getHp() - damage);
        return true;
    }
}
