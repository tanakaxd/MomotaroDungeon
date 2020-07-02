package Momotaro.Party;

import java.util.ArrayList;
import java.util.List;

import Momotaro.Character.Hero;

public class Party {
    private List<Hero> heroes = new ArrayList<Hero>();
    private Hero mainHero;
    private Inventory inventory;

    public Party(Hero... heroes) {
        this.mainHero = heroes[0];
        for (Hero hero : heroes) {
            addHero(hero);
        }
        this.inventory = new Inventory();
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}