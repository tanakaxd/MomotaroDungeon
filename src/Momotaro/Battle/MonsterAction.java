package Momotaro.Battle;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;
import java.util.List;
import java.util.Random;

public class MonsterAction extends Action {

    @Override
    public void attemptAct(FightingObject self, List<FightingObject> enemies, List<FightingObject> friends) {
        // TODO Auto-generated method stub
        attack(self, enemies, friends, 0);// 0 は通常攻撃

    }

    @Override
    protected boolean doAttack(FightingObject self, List<FightingObject> enemies, List<FightingObject> friends,
            int option) {
        FightingObject opponent = enemies.get(new Random().nextInt(enemies.size()));
        int damage = (self.getAtt() - opponent.getDef());
        damage = Math.max(1, damage);
        for (int i = 0; i < self.getHitTimes(); i++) {
            // displayAttack(opponent, damage);
            opponent.getDamage(damage);
        }
        return true;
    }

}