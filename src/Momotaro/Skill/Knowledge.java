package Momotaro.Skill;

import java.util.List;

import Momotaro.Character.FightingObject;
import Momotaro.Item.Weapon;

public class Knowledge extends UltimateSkill {

    public Knowledge(String name, boolean isAOE, int times, int damageCoefficient, int mpConsumption,
            String description, int maxCharge) {
        super(name, isAOE, times, damageCoefficient, mpConsumption, description, maxCharge);
    }

    @Override
    public boolean doUltimate(FightingObject attacker, List<FightingObject> enemies, List<FightingObject> friends,
            Weapon weapon) {

        int heal = (int) ((attacker.getAtt() + weapon.getAtt()) * ((double) getDamageCoefficient() / 100));
        for (FightingObject f : friends) {
            f.healHp(heal);
        }

        return true;
    }
}
