import java.util.List;
import java.util.Random;

public class Sude extends Weapon {

    public Sude() {
        this.att = 0;
        this.skills.add(new Skill("パンチ", false, 1, 150, 2));
        this.skills.add(new Skill("キック", false, 1, 210, 3));
        this.skills.add(new Skill("連撃", false, 5, 60, 5));

    }

}