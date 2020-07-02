package Momotaro.Skill;

import java.util.List;

import Momotaro.Character.FightingObject;
import Momotaro.Item.Weapon;

public abstract class UltimateSkill extends Skill {

    protected int maxCharge;
    protected int charge;

    public UltimateSkill(String name, boolean isAOE, int times, int damageCoefficient, int mpConsumption,
            String description, int maxCharge) {
        super(name, isAOE, times, damageCoefficient, mpConsumption, description);
        this.maxCharge = maxCharge;
        this.charge = this.maxCharge;
    }

    public final boolean ultimate(FightingObject attacker, List<FightingObject> enemies, List<FightingObject> friends,
            Weapon weapon) {
        if (this.charge <= 0) {
            System.out.println("failed: charge <= 0");
            return false;
        }

        // template pattern
        boolean isSuccess = doUltimate(attacker, enemies, friends, weapon);

        if (isSuccess) {
            this.charge--;
            attacker.consumeMp(getMpConsumption());
        }

        return isSuccess;

    };

    protected abstract boolean doUltimate(FightingObject attacker, List<FightingObject> enemies,
            List<FightingObject> friends, Weapon weapon);

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