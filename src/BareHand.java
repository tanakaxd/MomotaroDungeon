
public class BareHand extends Weapon {

    public BareHand(int times) {
        this.att = 0;
        this.skills.add(new Skill("攻撃", false, times, 100, 0));
    }

}
