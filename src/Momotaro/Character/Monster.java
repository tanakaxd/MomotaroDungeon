package Momotaro.Character;

import Momotaro.Battle.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;
import java.util.List;
import java.util.Random;

public abstract class Monster extends FightingObject {

    protected static int count = 0;

    public Monster() {
        super();
        count++;
        this.setName(name + count);
        this.action = new MonsterAction();
    }

}