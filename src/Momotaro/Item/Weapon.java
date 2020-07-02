package Momotaro.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Momotaro.Battle.BattleCalc;
import Momotaro.Character.FightingObject;
import Momotaro.Output.Display;
import Momotaro.Skill.Skill;
import Momotaro.Skill.UltimateSkill;

public abstract class Weapon extends Item implements ICalcDamageable {
    protected int att;
    protected List<Skill> skills = new ArrayList<>();

    // protected double precisionRate;
    // protected double fatigueModifier;

    public void equip() {

    }

    @Override
    public boolean calcDamage(FightingObject attacker, List<FightingObject> enemies, List<FightingObject> friends,
            int skillOption) {

        Skill s = skills.get(skillOption);
        System.out.println(attacker.getName() + "の『" + s.getName() + "』");

        // MPが十分にあるか確認
        if (attacker.getMp() < s.getMpConsumption() || s == null)
            return false;

        // 必殺技の場合
        if (s instanceof UltimateSkill) {

            boolean isSuccess = ((UltimateSkill) s).ultimate(attacker, enemies, friends, this);// ultimateにmp消費が含まれる

            return isSuccess;

        } else {
            // 通常攻撃
            // 全体攻撃の場合
            if (s.isAOE()) {
                for (FightingObject opponent : enemies) {
                    for (int i = 0; i < s.getTimes(); i++) {
                        int damage = BattleCalc.calc(attacker, opponent, s);
                        damage = Math.max(1, damage);
                        opponent.getDamage(damage);
                        // displayAttack(opponent, damage);
                    }
                }

            } else {
                // targetを選ぶ
                FightingObject opponent = enemies.get(new Random().nextInt(enemies.size()));
                for (int i = 0; i < s.getTimes(); i++) {
                    int damage = BattleCalc.calc(attacker, opponent, s);
                    damage = Math.max(1, damage);
                    opponent.getDamage(damage);
                    // displayAttack(opponent, damage);
                }
            }

            // mp消費
            attacker.consumeMp(s.getMpConsumption());

            return true;

        }

    }

    protected void displayAttack(FightingObject opponent, int damage) {
        System.out.println(opponent.getName() + "に" + damage + "ダメージ!");
    }

    public int skillSelect() {

        for (int i = 0; i < skills.size(); i++) {
            Skill skill = skills.get(i);

            if (skill instanceof UltimateSkill) {
                if (((UltimateSkill) skill).getCharge() == 0)
                    continue;
            }
            int num = i + 1;
            System.out.println(" " + num + " --> " + skill);
        }

        int option = Display.scanNextInt(skills.size(), false);
        return option;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "『" + this.name + "』" + " ATT:+" + this.att;
    }

    public String toDetailString() {
        String s = "";
        for (Skill skill : skills) {
            s += skill.getName() + " ";
        }
        return "『" + this.name + "』" + " ATT:+" + this.att + " スキル: " + s;
    }

}
