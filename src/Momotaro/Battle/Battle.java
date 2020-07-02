package Momotaro.Battle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Momotaro.Character.Boss;
import Momotaro.Character.FightingObject;
import Momotaro.Character.Hero;
import Momotaro.Character.MonsterDatabase;
import Momotaro.Output.MomotaroDeadException;
import Momotaro.Party.Party;

public class Battle {

    private List<FightingObject> objectsOnField = new ArrayList<FightingObject>();
    private List<FightingObject> friends = new ArrayList<>();
    private List<FightingObject> enemies = new ArrayList<>();
    private Party party;

    public Battle(Party p, int stairs) {

        this.party = p;

        p.initForCombat();

        for (Hero hero : p.getHeroes()) {
            friends.add(hero);
        }
        for (int i = 0; i < BattleDatabase.getEnemyAmountsForStairs(stairs); i++) {
            enemies.add(MonsterDatabase.getInstance().getRandomMonster());
        }
        objectsOnField.addAll(friends);
        objectsOnField.addAll(enemies);

    }

    public Battle(Party p, Boss boss) {

        this.party = p;

        p.initForCombat();

        for (Hero hero : p.getHeroes()) {
            friends.add(hero);
        }
        enemies.add(boss);
        objectsOnField.addAll(friends);
        objectsOnField.addAll(enemies);

    }

    public void iterate() throws MomotaroDeadException {

        int turn = 1;

        while (true) {
            System.out.println("ターン：" + turn + "\n");

            // 素早さ順に並び替える
            objectsOnField = objectsOnField.stream().sorted((x, y) -> (y.getAgi() - x.getAgi()))
                    .filter(x -> !x.isDead()).collect(Collectors.toList());
            System.out.println("行動順：" + objectsOnField);

            // 全員に行動権を与える
            for (FightingObject o : objectsOnField) {
                o.setActive(true);
            }

            // 順に攻撃
            for (FightingObject o : objectsOnField) {
                // 死んでいない敵リスト
                List<FightingObject> o_enemies = new ArrayList<FightingObject>();
                o_enemies = objectsOnField.stream().filter(x -> {
                    return (x.isEnemy() != o.isEnemy()) && !x.isDead();
                }).collect(Collectors.toList());

                // 死人を含めた仲間リスト
                // 戦闘中に仲間いなるやつがいるかもしれないからpartyがあろうともそれとは別に残しておく
                List<FightingObject> o_friends = new ArrayList<FightingObject>();
                o_friends = objectsOnField.stream().filter(x -> {
                    return (x.isEnemy() == o.isEnemy());
                }).collect(Collectors.toList());

                // System.out.println(o_enemies);
                // System.out.println(o_friends);

                o.attemptAct(o_enemies, o_friends, this.party);
            }

            if (isWiped(enemies)) {
                break;
            } else if (isWiped(friends)) {
                // System.exit(0);
                throw new MomotaroDeadException("パーティが全滅。ゲームオーバーです");
            }

            System.out.println("\n");

            if (turn > 30) {
                break;
            }
            turn++;
        }
    }

    private boolean isWiped(List<FightingObject> lists) {
        boolean isWiped = true;
        for (FightingObject o : lists) {
            isWiped = isWiped && o.isDead();
        }
        return isWiped;
    }
}