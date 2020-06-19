import java.util.List;
import java.util.Random;

public class Busou extends UltimateSkill {

    public Busou(String name, boolean isAOE, int times, int damageCoefficient, int mpConsumption, String description,
            int maxCharge) {
        super(name, isAOE, times, damageCoefficient, mpConsumption, description, maxCharge);
    }

    @Override
    public boolean doUltimate(FightingObject attacker, List<FightingObject> targets, Weapon weapon) {

        FightingObject opponent = targets.get(new Random().nextInt(targets.size()));
        int damage = (int) ((attacker.getAtt() + weapon.att) * ((double) getDamageCoefficient() / 100));
        damage = Math.max(1, damage);
        System.out.println(opponent.getName() + "に" + damage + "ダメージ!");
        opponent.setHp(opponent.getHp() - damage);
        return true;
    }
}
