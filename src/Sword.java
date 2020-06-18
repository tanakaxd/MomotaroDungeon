
public class Sword extends Weapon {

    public Sword() {
        this.att = 8;
        this.skills.add(new Skill("虎狩", 150, 2));
        this.skills.add(new Skill("鬼斬り", 210, 3));
        this.skills.add(new Skill("竜巻", 300, 5));

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
