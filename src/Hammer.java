public class Hammer extends Weapon {
    public Hammer() {
        this.att = 15;
        this.rarityRate = 0.2;

        this.skills.add(new Skill("微スウィング", false, 1, 120, 0, "通常攻撃"));
        this.skills.add(new Skill("スウィング", false, 1, 210, 5, "単体中威力攻撃"));
        this.skills.add(new Skill("回転スウィング", true, 1, 100, 10, "範囲攻撃"));
        this.skills.add(new HammerUltimateSkill("超振り下ろしスウィング", false, 1, 300, 15, "相手の防御が高いほどダメージ上昇", 1));

    }
}