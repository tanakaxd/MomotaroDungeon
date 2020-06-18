
public class Sude extends Weapon {

    public Sude() {
        this.att = 0;
        this.skills.add(new Skill("パンチ", 150, 2));
        this.skills.add(new Skill("キック", 210, 3));
        this.skills.add(new Skill("連撃", 300, 5));

    }

    @Override
    public int calcDamage(FightingObject attacker, FightingObject opponent, int option) {

        Skill s = skills.get(option);
        System.out.println(attacker.getName() + "の" + s.getName());
        int damage = (attacker.getAtt() + this.att - opponent.getDef()) * (s.getDamageCoefficient() / 100);

        return damage;

    }

    @Override
    public int skillSelect() {
        for (Skill skill : skills) {
            System.out.println(skill);
        }
        int option = Main.scanner.nextInt() - 1;
        return option;

    }

}