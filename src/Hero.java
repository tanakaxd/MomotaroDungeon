import java.util.List;
import java.util.stream.Collectors;

public abstract class Hero extends FightingObject {
    // 経験値を蓄積しレベルアップできる
    protected int accumulatedExp;
    // 装備
    protected Weapon weapon;
    // protected Armor armor;

    public Hero() {
        super();
        this.isEnemy = false;
        this.accumulatedExp = 0;
        this.action = new HeroAction();
    }

    public int calcLevel(int exp) {
        return 0;
    }

    public void initForCombat() {

        // ultimateの回復
        List<Skill> s = weapon.skills.stream().filter(x -> x instanceof UltimateSkill).collect(Collectors.toList());
        for (Skill skill : s) {
            ((UltimateSkill) skill).refill();
        }
    }

    public void terminateForCombat() {
        // 戦闘が終わった時の処理
        // バフの状態を元に戻す等
    }

    public void rest() {
        healHp((int) (this.maxHp * 0.2));
        healMp((int) (this.maxMp * 0.2));
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return name + "[装備:" + this.weapon + "]" + " HP:" + this.hp + "/" + this.maxHp + " MP:" + this.mp + "/"
                + this.maxMp;
    }
}