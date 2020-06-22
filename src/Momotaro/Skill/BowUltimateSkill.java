package Momotaro.Skill;

import java.util.List;
import java.util.Random;

import Momotaro.Character.FightingObject;
import Momotaro.Item.Weapon;

public class BowUltimateSkill extends UltimateSkill {

    public BowUltimateSkill(String name, boolean isAOE, int times, int damageCoefficient, int mpConsumption,
            String description, int maxCharge) {
        super(name, isAOE, times, damageCoefficient, mpConsumption, description, maxCharge);
    }

    @Override
    protected boolean doUltimate(FightingObject attacker, List<FightingObject> enemies, List<FightingObject> friends,
            Weapon weapon) {
        FightingObject opponent = enemies.get(new Random().nextInt(enemies.size()));
        int damage = (int) ((attacker.getAtt() + weapon.getAtt() - opponent.getDef())
                * ((double) getDamageCoefficient() / 100));
        damage = Math.max(1, damage);
        for (int i = 0; i < this.getTimes(); i++) {
            opponent.getDamage(damage);
        }
        return true;
    }

}
