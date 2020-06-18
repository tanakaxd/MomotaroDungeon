import java.util.List;
import java.util.Random;

public class Sword extends Weapon {

    public Sword() {
        this.att = 8;
        this.skills.add(new Skill("虎狩", false, 1, 100, 0, "通常攻撃"));
        this.skills.add(new Skill("鬼斬り", false, 1, 210, 3, "単体中威力攻撃"));
        this.skills.add(new Skill("竜巻", true, 3, 30, 8, "範囲多段攻撃"));
        this.skills.add(new Busou("武装一文字", false, 1, 300, 10, "戦闘中一回のみ使用可能"));

    }

}
