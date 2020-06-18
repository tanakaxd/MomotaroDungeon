
public interface ICalcDamageable {

    public abstract int calcDamage(FightingObject attacker, FightingObject opponent, int option);
    // 選択肢を受け取って、そのスキルと攻撃側防御側のパラメータを使ってダメージを計算するメソッド
}
