package Momotaro.Skill;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;
import java.util.List;
import java.util.Random;

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
                int damage = (int) ((attacker.getAtt() + weapon.getAtt() - opponent.getDef())
                        * ((double) getDamageCoefficient() / 100));
                damage = Math.max(1, damage);
                opponent.getDamage(damage);
            }
        }
        return true;
    }
}
