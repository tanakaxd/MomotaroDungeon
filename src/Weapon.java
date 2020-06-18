import java.util.ArrayList;
import java.util.List;

public abstract class Weapon implements ICalcDamageable, ISkillSelectable {
    protected int att;
    protected List<Skill> skills = new ArrayList<>();

}
