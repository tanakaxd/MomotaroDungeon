import java.util.List;

public abstract class UltimateSkill extends Skill {

    protected int maxCharge;
    protected int charge;

    public UltimateSkill(String name, boolean isAOE, int times, int damageCoefficient, int mpConsumption,
            String description, int maxCharge) {
        super(name, isAOE, times, damageCoefficient, mpConsumption, description);
        this.maxCharge = maxCharge;
        this.charge = this.maxCharge;
    }

    public final boolean ultimate(FightingObject attacker, List<FightingObject> targets, Weapon weapon) {
        if (this.charge <= 0) {
            System.out.println("failed: charge <= 0");
            return false;
        }

        // template pattern
        boolean isSuccess = doUltimate(attacker, targets, weapon);

        if (isSuccess)
            this.charge--;

        return isSuccess;

    };

    protected abstract boolean doUltimate(FightingObject attacker, List<FightingObject> targets, Weapon weapon);

    public int getCharge() {
        // System.out.println(charge);
        return this.charge;
    }

    public void refill() {
        // System.out.println(charge);
        this.charge = this.maxCharge;
        // System.out.println(charge);

    }

}