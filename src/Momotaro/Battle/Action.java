package Momotaro.Battle;

import java.util.List;

import Momotaro.Character.FightingObject;
import Momotaro.Party.Party;

public abstract class Action {

    // hero にも monsterにも共通する処理
    // 攻撃処理
    public abstract void attemptAct(FightingObject self, List<FightingObject> enemies, List<FightingObject> friends,
            Party p);

    // template pattern
    public final boolean attack(FightingObject self, List<FightingObject> enemies, List<FightingObject> friends,
            Party p, int option) {
        // 攻撃前、誰もが行う処理
        if (enemies.size() == 0)
            return true;

        // クラスごとに独自の攻撃メソッド
        boolean isAttackSuccess = doAttack(self, enemies, friends, p, option);

        // 攻撃後、誰もが行う処理
        return isAttackSuccess;
    };

    protected abstract boolean doAttack(FightingObject self, List<FightingObject> enemies, List<FightingObject> friends,
            Party p, int option);

    // protected void displayAttack(FightingObject opponent, int damage) {
    // System.out.println(opponent.getName() + "に" + damage + "ダメージ!");
    // }
}