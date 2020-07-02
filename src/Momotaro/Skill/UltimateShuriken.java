package Momotaro.Skill;

import java.util.List;

import Momotaro.Battle.BattleCalc;
import Momotaro.Character.FightingObject;
import Momotaro.Item.Weapon;

public class UltimateShuriken extends UltimateSkill {

    public UltimateShuriken(String name, boolean isAOE, int times, int damageCoefficient, int mpConsumption,
            String description, int maxCharge) {
        super(name, isAOE, times, damageCoefficient, mpConsumption, description, maxCharge);
    }

    @Override
    public boolean doUltimate(FightingObject attacker, List<FightingObject> enemies, List<FightingObject> friends,
            Weapon weapon) {

        for (FightingObject opponent : enemies) {
            for (int i = 0; i < getTimes(); i++) {
                int damage = BattleCalc.calc(attacker, opponent);
                damage = (int) (damage * (double) this.getDamageCoefficient() / 100);
                damage = Math.max(1, damage);
                opponent.getDamage(damage);
            }
        }
        return true;
    }
}
