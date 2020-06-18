import java.util.List;

public abstract class UltimateSkill extends Skill implements IUltimateable {

    protected int maxCharge;
    protected int charge;

    public UltimateSkill(String name, boolean isAOE, int times, int damageCoefficient, int mpConsumption,
            String description) {
        super(name, isAOE, times, damageCoefficient, mpConsumption, description);
        // refill();
    }

    public int getCharge() {
        System.out.println(charge);
        return this.charge;
    }

    public void refill() {
        System.out.println(charge);
        this.charge = this.maxCharge;
        System.out.println(charge);

    }

}