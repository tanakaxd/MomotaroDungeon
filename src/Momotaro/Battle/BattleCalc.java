package Momotaro.Battle;

import Momotaro.Character.FightingObject;
import Momotaro.Skill.Skill;

public class BattleCalc {
    public static int calc(FightingObject attacker, FightingObject defender) {

        int attack = attacker.getModifiedAtt() * 4;

        int autoAttackModifier = 2;// スキル換算で威力50
        int damage = (attack - defender.getDef()) / autoAttackModifier;
        return damage;
    }

    public static int calc(FightingObject attacker, FightingObject defender, Skill skill) {

        int attack = attacker.getModifiedAtt() * 4;

        int damage = attack - defender.getDef();
        damage = (int) (damage * (double) skill.getDamageCoefficient() / 100);
        return damage;
    }

}