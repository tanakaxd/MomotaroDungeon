package Momotaro.Skill;

public class Skill {
    // 対象が誰か
    // 全体か
    // 何連か
    // 属性

    private String name;
    private boolean isAOE;
    private boolean isUsable;
    private int times;
    private int damageCoefficient;
    private int mpConsumption;
    // private int critRate;
    // private int hitRate;
    private String description;

    public Skill(String name, boolean isAOE, int times, int damageCoefficient, int mpConsumption, String description) {
        this.name = name;
        this.isAOE = isAOE;
        this.isUsable = true;
        this.damageCoefficient = damageCoefficient;
        this.times = times;
        this.mpConsumption = mpConsumption;
        this.description = description;
    }

    public Skill(String name, boolean isAOE, int times, int damageCoefficient, int mpConsumption) {
        this(name, isAOE, times, damageCoefficient, mpConsumption, "");
    }

    @Override
    public String toString() {
        return "『" + this.name + "』" + " 対象:" + isAOEString() + " 威力:" + damageCoefficient + " × " + times + " 消費MP"
                + mpConsumption + " 備考:" + description;
    }

    private String isAOEString() {
        return isAOE ? "全体" : "単体";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isAOE() {
        return isAOE;
    }

    public void setAOE(boolean isAOE) {
        this.isAOE = isAOE;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public boolean isUsable() {
        return isUsable;
    }

    public void setUsable(boolean isUsable) {
        this.isUsable = isUsable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
