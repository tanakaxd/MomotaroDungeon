
public class Skill {
    // 対象が誰か
    // 対象が何人か

    private String name;
    private Weapon weapon;
    private int damageCoefficient;
    private int mpConsumption;

    public Skill(String name, int damageCoefficient, int mpConsumption) {
        this.name = name;
        this.damageCoefficient = damageCoefficient;
        this.mpConsumption = mpConsumption;
    }

    @Override
    public String toString() {
        return name + " 威力:" + damageCoefficient + " 消費MP" + mpConsumption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getDamageCoefficient() {
        return damageCoefficient;
    }

    public void setDamageCoefficient(int damageCoefficient) {
        this.damageCoefficient = damageCoefficient;
    }

    public int getMpConsumption() {
        return mpConsumption;
    }

    public void setMpConsumption(int mpConsumption) {
        this.mpConsumption = mpConsumption;
    }

}
