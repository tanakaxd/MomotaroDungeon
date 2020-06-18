import java.util.List;

public interface ICalcDamageable {

    public abstract void calcDamage(FightingObject attacker, List<FightingObject> targets);
    // 選択肢を受け取って、そのスキルと攻撃側防御側のパラメータを使ってダメージを計算するメソッド
}
