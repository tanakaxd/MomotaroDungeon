import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Weapon implements ICalcDamageable, ISkillSelectable {
    protected int att;
    protected List<Skill> skills = new ArrayList<>();
    protected double rarityRate;

    @Override
    public void calcDamage(FightingObject attacker, List<FightingObject> targets) {
        Skill s;
        do {
            int option = skillSelect();
            s = skills.get(option);

        } while (!attacker.consumeMp(s.getMpConsumption()) || s == null);
        // s.getMpConsumption() > attacker.getMp()

        System.out.println(attacker.getName() + "の" + s.getName());

        // 必殺技の場合
        if (s instanceof UltimateSkill) {

            boolean isSuccess = ((UltimateSkill) s).ultimate(attacker, targets, this);

            // 使えなかった場合何もできない。上のwhile loopに入れる手もあるが調整が必要
            return;

        }
        // 通常攻撃
        // 全体攻撃の場合
        if (s.isAOE()) {
            for (FightingObject opponent : targets) {
                for (int i = 0; i < s.getTimes(); i++) {
                    int damage = (int) ((attacker.getAtt() + this.att - opponent.getDef())
                            * ((double) s.getDamageCoefficient() / 100));
                    displayAttack(opponent, damage);
                }
            }

        } else {
            // targetを選ぶ
            FightingObject opponent = targets.get(new Random().nextInt(targets.size()));
            for (int i = 0; i < s.getTimes(); i++) {
                int damage = (int) ((attacker.getAtt() + this.att - opponent.getDef())
                        * ((double) s.getDamageCoefficient() / 100));
                displayAttack(opponent, damage);
            }
        }

    }

    protected void displayAttack(FightingObject opponent, int damage) {
        // 最低1ダメージ
        damage = Math.max(1, damage);
        System.out.println(opponent.getName() + "に" + damage + "ダメージ!");
        opponent.setHp(opponent.getHp() - damage);
    }

    @Override
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

        int option = Main.scanNextInt(skills.size());
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

    public double getRarityRate() {
        return rarityRate;
    }

    public void setRarityRate(double rarityRate) {
        this.rarityRate = rarityRate;
    }

}
