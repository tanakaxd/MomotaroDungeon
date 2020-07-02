package Momotaro.Battle;

import java.util.List;
import java.util.Random;

import Momotaro.Character.FightingObject;
import Momotaro.Party.Party;

public class MonsterAction extends Action {

    @Override
    public void attemptAct(FightingObject self, List<FightingObject> enemies, List<FightingObject> friends, Party p) {
        attack(self, enemies, friends, p, 0);// 0 は通常攻撃

    }

    @Override
    protected boolean doAttack(FightingObject self, List<FightingObject> enemies, List<FightingObject> friends, Party p,
            int option) {
        FightingObject opponent = enemies.get(new Random().nextInt(enemies.size()));
        int damage = BattleCalc.calc(self, opponent);
        damage = Math.max(1, damage);
        for (int i = 0; i < self.getHitTimes(); i++) {
            // displayAttack(opponent, damage);
            opponent.getDamage(damage);
        }
        return true;
    }

}