package Momotaro.Character;

import Momotaro.Battle.MonsterAction;

public abstract class Monster extends FightingObject {

    protected static int count = 0;

    public Monster() {
        super();
        count++;
        this.setName(name + count);
        this.action = new MonsterAction();
    }

}