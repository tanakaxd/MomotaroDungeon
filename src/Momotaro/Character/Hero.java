package Momotaro.Character;

import java.util.List;
import java.util.stream.Collectors;

import Momotaro.Battle.HeroAction;
import Momotaro.Item.Weapon;
import Momotaro.Skill.Skill;
import Momotaro.Skill.UltimateSkill;

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
        List<Skill> s = weapon.getSkills().stream().filter(x -> x instanceof UltimateSkill)
                .collect(Collectors.toList());
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

    @Override
    public String toDetailString() {
        String s = super.toDetailString();
        s += getWeapon().toDetailString();
        return s;
    }

    @Override
    public int getModifiedAtt() {
        // int modifier = 1;
        double att = (this.att + this.weapon.getAtt()) * this.attModifier;
        return (int) att;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "『" + this.name + "』" + "[装備:" + this.weapon + "]" + " HP:" + this.hp + "/" + this.maxHp + " MP:"
                + this.mp + "/" + this.maxMp;
    }
}