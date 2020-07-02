package Momotaro.Battle;

import java.util.List;
import java.util.Random;

import Momotaro.Character.FightingObject;
import Momotaro.Character.Hero;
import Momotaro.Item.Consumable;
import Momotaro.Item.Weapon;
import Momotaro.Output.Display;
import Momotaro.Party.Inventory;
import Momotaro.Party.Party;

public class HeroAction extends Action {

    // heroは行動を選択可能

    @Override
    public void attemptAct(FightingObject self, List<FightingObject> enemies, List<FightingObject> friends, Party p) {

        // 外枠のループ。最終的に行動が不可能だったら最初に戻ってもう一度選択を求める
        boolean isAttemptSuccess = false;
        do {

            // 行動の種類を選択
            boolean isPossibleSelection = false;
            int option;
            do {
                Display.displayChoices("通常攻撃", "武器スキル", "アイテム");
                option = Display.scanNextInt(3);
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
                    isAttemptSuccess = attack(self, enemies, friends, p, option);
                    break;
                case 1:
                    isAttemptSuccess = attack(self, enemies, friends, p, option);
                    break;
                case 2:
                    isAttemptSuccess = useItem(self, enemies, friends, p, option);
                    break;

            }
            if (!isAttemptSuccess) {
                System.out.println("***その選択肢は使用可能な状態ではありません。別の選択肢を試してみてください***");
            }

        } while (!isAttemptSuccess);

    }

    private boolean useItem(FightingObject self, List<FightingObject> enemies, List<FightingObject> friends, Party p,
            int option) {
        Inventory inv = p.getInventory();
        if (inv.getConsumables().size() == 0)
            return false;

        inv.printConsumbales();

        int num = Display.scanNextInt(inv.getConsumables().size(), false);
        Consumable consumable = inv.getConsumables().get(num);
        boolean isUsed = consumable.calcDamage(self, enemies, friends, option);
        if (isUsed) {
            inv.removeConsumables(consumable);
        }
        // switch (num) {
        // case 0:
        // consumabe
        // break;
        // case 1:
        // break;
        // case 2:
        // break;
        // case 3:
        // break;
        // case 4:
        // break;
        // }

        return isUsed;
    }

    @Override
    protected boolean doAttack(FightingObject self, List<FightingObject> enemies, List<FightingObject> friends, Party p,
            int option) {

        switch (option) {

            // 通常攻撃
            case 0:
                FightingObject opponent = enemies.get(new Random().nextInt(enemies.size()));
                int damage = BattleCalc.calc(self, opponent);
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