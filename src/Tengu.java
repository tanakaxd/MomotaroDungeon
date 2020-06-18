public class Tengu extends FightingObject {

    private static int count = 0;

    public Tengu(String name) {
        super();
        count++;

        this.setName(name + count);
        this.id = count;
        this.maxHp = 20;
        this.hp = maxHp;
        this.maxMp = 30;
        this.mp = maxMp;
        this.agi = 20;
        this.att = 7;
        this.def = 0;
        this.mnd = 10;
        this.isDead = false;
        this.isEnemy = true;
        this.isActive = true;
    }

    @Override
    public void attack(FightingObject opponent) {
        super.attack(opponent);

        int damage = Math.max(1, this.att - opponent.getDef());
        // int damage = damageCalculator.calcDamage(this, opponent);
        closeAttack(opponent, damage);
    }

}