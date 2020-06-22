package Momotaro.Item;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;
import java.util.List;

public interface ICalcDamageable {

    public abstract boolean calcDamage(FightingObject attacker, List<FightingObject> enemies,
            List<FightingObject> friends, int skillOption);
    // 選択肢を受け取って、そのスキルと攻撃側防御側のパラメータを使ってダメージを計算するメソッド
}
