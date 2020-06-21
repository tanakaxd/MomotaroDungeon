import java.util.List;

public interface ICalcDamageable {

    public abstract boolean calcDamage(FightingObject attacker, List<FightingObject> targets, int skillOption);
    // 選択肢を受け取って、そのスキルと攻撃側防御側のパラメータを使ってダメージを計算するメソッド
}
