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

public class HeroAction extends Action {

    // heroは行動を選択可能

    @Override
    public void attemptAct(FightingObject self, List<FightingObject> enemies, List<FightingObject> friends) {
        // TODO Auto-generated method stub

        // 外枠のループ。最終的に行動が不可能だったら最初に戻ってもう一度選択を求める
        boolean isAttemptSuccess = false;
        do {

            // 行動の種類を選択
            boolean isPossibleSelection = false;
            int option;
            do {
                Display.displayChoices("通常攻撃", "武器スキル");
                option = Display.scanNextInt(2);
                // isPossible = askPossible(option);
                isPossibleSelection = true;

            } while (!isPossibleSelection);

            switch (option) {
                // 選択による分岐
                // heal();
                // runAway();
                // useItem();
                // guard();
                case 0:
                    isAttemptSuccess = attack(self, enemies, friends, option);
                    break;
                case 1:
                    isAttemptSuccess = attack(self, enemies, friends, option);
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
            if (!isAttemptSuccess) {
                System.out.println("***その選択肢は使用可能な状態ではありません。別の選択肢を試してみてください***");
            }

        } while (!isAttemptSuccess);

    }

    @Override
    protected boolean doAttack(FightingObject self, List<FightingObject> enemies, List<FightingObject> friends,
            int option) {

        switch (option) {
            // 通常攻撃
            case 0:
                FightingObject opponent = enemies.get(new Random().nextInt(enemies.size()));
                int damage = (self.getAtt() + ((Hero) self).getWeapon().getAtt() - opponent.getDef());
                damage = Math.max(1, damage);
                for (int i = 0; i < self.getHitTimes(); i++) {
                    // displayAttack(opponent, damage);
                    opponent.getDamage(damage);
                }
                return true;
            // スキル
            case 1:
                Weapon weapon = ((Hero) self).getWeapon();
                int skillOption = weapon.skillSelect();
                boolean isAttemptSuccess = weapon.calcDamage(self, enemies, friends, skillOption);
                return isAttemptSuccess;
            default:
                return false;
        }

    }

}