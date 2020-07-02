package Momotaro.Item;

import java.util.List;

import Momotaro.Character.FightingObject;

public interface ICalcDamageable {

    public abstract boolean calcDamage(FightingObject attacker, List<FightingObject> enemies,
            List<FightingObject> friends, int skillOption);
    // 選択肢を受け取って、そのスキルと攻撃側防御側のパラメータを使ってダメージを計算するメソッド
}
