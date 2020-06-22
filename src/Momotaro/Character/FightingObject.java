package Momotaro.Character;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;
import java.util.List;

public abstract class FightingObject {
    protected String name;
    protected int id;
    protected int maxHp;
    protected int hp;
    protected int maxMp;
    protected int mp;
    protected int att;
    protected int def;
    protected int agi;
    protected int mnd;
    protected int hitTimes;

    protected boolean isDead;
    protected boolean isActive;
    protected boolean isEnemy;

    // 状態異常系 todo status class
    protected boolean isParalized;
    protected int paralysisCount;
    protected boolean isSleeping;
    protected int sleepCount;
    protected boolean isPoisoned;
    protected int poisonCount;
    protected boolean isStunned;
    protected int stunCount;
    // バフ系
    protected double attModifier;
    protected double defModifier;
    protected double agiModifier;
    protected double mndModifier;
    // レベル
    protected int level;
    protected int xp;
    // 成長度

    // action
    protected Action action;

    public FightingObject() {
        // Field.addFightingObject(this);
        this.isDead = false;
        this.isActive = true;
        this.isParalized = false;
        this.isSleeping = false;
        this.isPoisoned = false;
        this.attModifier = 1;
        this.defModifier = 1;
        this.agiModifier = 1;
        this.mndModifier = 1;
    }

    public class Timer {
        private int count;

        Timer(int count) {
            this.count = count;
        }

    }

    public final void attemptAct(List<FightingObject> enemies, List<FightingObject> friends) {
        // 行動前、誰もが行う処理
        if (isDead || !isActive || isParalized() || isSleeping() || enemies.size() == 0)
            return;
        // if (isImmobilized()) {
        // System.out.println("行動不能");
        // return;
        // }
        Display.delayedPrint("\n-----" + getName() + "の番" + "-----");
        beginTurn();

        // クラスごとに独自の行動メソッド
        this.action.attemptAct(this, enemies, friends);

        // 行動後、誰もが行う処理
        setActive(false);
        endTurn();
    };

    private void endTurn() {
    }

    private void beginTurn() {
    }

    @Override
    public String toString() {
        return "『" + this.name + "』" + " HP:" + this.hp + "/" + this.maxHp + " MP:" + this.mp + "/" + this.maxMp;
    }

    public String toDetailString() {
        String s = "";
        s += toString() + "\n";
        s += "ATT:" + this.att + " DEF:" + this.def + " AGI:" + this.agi + " MND:" + this.mnd + "\n";
        return s;
    }

    public int getHp() {
        return hp;
    }

    private void setHp(int hp) {
        if (hp > this.maxHp) {
            this.hp = this.maxHp;
        } else if (hp > 0) {
            this.hp = hp;
        } else if (hp <= 0) {
            this.hp = 0;
            if (!this.isDead)
                System.out.println(getName() + "は倒れた");
            this.setDead(true);
        }

        System.out.println(getName() + "の現在HP：" + getHp());

    }

    public void getDamage(int damage) {
        Display.delayedPrint(150, 50, getName() + "に" + damage + "ダメージ");
        setHp(getHp() - damage);
    }

    public void healHp(int amounts) {
        System.out.println(getName() + "は" + amounts + "HPを回復した");
        setHp(getHp() + amounts);
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        if (mp > this.maxMp) {
            this.mp = this.maxMp;
        } else if (mp > 0) {
            this.mp = mp;
        } else if (mp <= 0) {
            this.mp = 0;
        }

        System.out.println(getName() + "の現在mp：" + getMp());
    }

    public void consumeMp(int amounts) {
        System.out.println(getName() + "は" + amounts + "MPを消費した");
        setMp(getMp() - amounts);
    }

    public void healMp(int amounts) {
        System.out.println(getName() + "は" + amounts + "MPを回復した");
        setMp(getMp() + amounts);
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnemy() {
        return isEnemy;
    }

    public void setEnemy(boolean isEnemy) {
        this.isEnemy = isEnemy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getMnd() {
        return mnd;
    }

    public void setMnd(int mnd) {
        this.mnd = mnd;
    }

    public int getHitTimes() {
        return hitTimes;
    }

    public void setHitTimes(int hitTimes) {
        this.hitTimes = hitTimes;
    }

    public boolean isParalized() {
        return isParalized;
    }

    public void setParalized(boolean isParalized) {
        this.isParalized = isParalized;
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public void setSleeping(boolean isSleeping) {
        this.isSleeping = isSleeping;
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    public void setPoisoned(boolean isPoisoned) {
        this.isPoisoned = isPoisoned;
    }

    public double getAttModifier() {
        return attModifier;
    }

    public void setAttModifier(double attModifier) {
        this.attModifier = attModifier;
    }

    public double getDefModifier() {
        return defModifier;
    }

    public void setDefModifier(double defModifier) {
        this.defModifier = defModifier;
    }

    public double getAgiModifier() {
        return agiModifier;
    }

    public void setAgiModifier(double agiModifier) {
        this.agiModifier = agiModifier;
    }

    public double getMndModifier() {
        return mndModifier;
    }

    public void setMndModifier(double mndModifier) {
        this.mndModifier = mndModifier;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public boolean isStunned() {
        return isStunned;
    }

    public void setStunned(boolean isStunned) {
        this.isStunned = isStunned;
    }

    public int getParalysisCount() {
        return paralysisCount;
    }

    public void setParalysisCount(int paralysisCount) {
        this.paralysisCount = paralysisCount;
    }

    public int getSleepCount() {
        return sleepCount;
    }

    public void setSleepCount(int sleepCount) {
        this.sleepCount = sleepCount;
    }

    public int getPoisonCount() {
        return poisonCount;
    }

    public void setPoisonCount(int poisonCount) {
        this.poisonCount = poisonCount;
    }

    public int getStunCount() {
        return stunCount;
    }

    public void setStunCount(int stunCount) {
        this.stunCount = stunCount;
    }

}