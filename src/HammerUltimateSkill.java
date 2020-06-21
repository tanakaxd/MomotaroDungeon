import java.util.List;
import java.util.Random;

public class HammerUltimateSkill extends UltimateSkill {

    public HammerUltimateSkill(String name, boolean isAOE, int times, int damageCoefficient, int mpConsumption,
            String description, int maxCharge) {
        super(name, isAOE, times, damageCoefficient, mpConsumption, description, maxCharge);
    }

    @Override
    protected boolean doUltimate(FightingObject attacker, List<FightingObject> targets, Weapon weapon) {
        // TODO Auto-generated method stub
        FightingObject opponent = targets.get(new Random().nextInt(targets.size()));
        int damage = (int) ((attacker.getAtt() + weapon.att + opponent.getDef())
                * ((double) getDamageCoefficient() / 100));
        damage = Math.max(1, damage);
        // System.out.println(opponent.getName() + "に" + damage + "ダメージ!");
        opponent.getDamage(damage);
        return true;
    }

}
