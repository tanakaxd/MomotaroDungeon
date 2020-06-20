import java.util.ArrayList;
import java.util.List;

public class Party {
    private List<Hero> heroes = new ArrayList<Hero>();
    private Hero mainHero;

    public Party(Hero mainHero) {
        this.mainHero = mainHero;
        addHero(mainHero);
    }

    public void rest() {
        for (Hero hero : heroes) {
            hero.rest();
        }
    }

    public void initForCombat() {
        for (Hero hero : heroes) {
            hero.initForCombat();
        }
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public Hero getMainHero() {
        return mainHero;
    }

    public void setMainHero(Hero mainHero) {
        this.mainHero = mainHero;
    }

}