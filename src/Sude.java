import java.util.List;
import java.util.Random;

public class Sude extends Weapon {

    public Sude() {
        this.name = "素手";
        this.att = 0;
        this.rarityRate = 0.5;

        this.skills.add(new Skill("パンチ", false, 1, 110, 0));
        this.skills.add(new Skill("キック", false, 1, 210, 3));
        this.skills.add(new Skill("連撃", false, 5, 60, 5));

    }

}