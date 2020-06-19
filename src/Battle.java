import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Battle {

    private List<FightingObject> objectsOnField = new ArrayList<FightingObject>();
    private List<FightingObject> friends = new ArrayList<>();
    private List<FightingObject> enemies = new ArrayList<>();

    public Battle(Momotaro m, int stairs) {

        m.initForCombat();

        friends.add(m);
        for (int i = 0; i < stairs; i++) {
            int random = new Random().nextInt(3);
            switch (random) {
                case 0:
                    enemies.add(new Oni());
                    break;
                case 1:
                    enemies.add(new Tengu());
                    break;
                case 2:
                    enemies.add(new Ochimusha());
                    break;
            }

        }
        objectsOnField.addAll(friends);
        objectsOnField.addAll(enemies);

    }

    public void iterate() {

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
                List<FightingObject> targets = new ArrayList<FightingObject>();
                targets = objectsOnField.stream().filter(x -> {
                    return (x.isEnemy() != o.isEnemy()) && !x.isDead();
                }).collect(Collectors.toList());
                System.out.println(targets);
                o.attack(targets);
            }

            if (isWiped(enemies)) {
                break;
            } else if (isWiped(friends)) {
                // System.exit(0);
                throw new MomotaroDeadException("パーティが全滅。ゲームオーバーです");
            }

            System.out.println("\n");

            turn++;
            if (turn > 20) {
                break;
            }
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