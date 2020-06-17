public abstract class FightingObject {
    protected String name;
    protected int id;
    protected int maxHp;
    protected int hp;
    protected int maxMp;
    protected int mp;
    protected int att;
    protected int def;
    protected int agi;
    protected int mnd;
    protected boolean isDead;
    protected boolean isActive;
    protected boolean isEnemy;

    public FightingObject() {
        Field.addFightingObject(this);
    }

    public abstract void attack(FightingObject opponent);

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        System.out.println(getName() + "の現在HP：" + getHp());
        if (hp <= 0) {
            this.setDead(true);
            System.out.println(getName() + "は死亡した");
        }
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnemy() {
        return isEnemy;
    }

    public void setEnemy(boolean isEnemy) {
        this.isEnemy = isEnemy;
    }
}