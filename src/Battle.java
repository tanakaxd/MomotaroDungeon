import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Battle {

    private List<FightingObject> objectsOnField = new ArrayList<FightingObject>();
    private List<FightingObject> friends = new ArrayList<>();
    private List<FightingObject> enemies = new ArrayList<>();

    public Battle(FightingObject m) {
        friends.add(m);
        enemies.add(new Oni("赤鬼"));
        objectsOnField.addAll(friends);
        objectsOnField.addAll(enemies);
//        System.out.println(objectsOnField);
//        System.out.println(friends);
//        System.out.println(enemies);

    }

    public void interate() {

        int turn = 1;
        while (true) {
            System.out.println("ターン：" + turn);

            // 素早さ順に並び替える
            objectsOnField = objectsOnField.stream().sorted((x, y) -> (y.getAgi() - x.getAgi()))
                    .collect(Collectors.toList());
            System.out.println("行動順："+objectsOnField);

            // 全員に行動権を与える
            for (FightingObject o : objectsOnField) {
                o.setActive(true);
            }

            // 順に攻撃
            for (FightingObject o : objectsOnField) {
                List<FightingObject> targets = new ArrayList<FightingObject>();
                targets = objectsOnField.stream().filter(x -> {
                    return x.isEnemy() != o.isEnemy();
                }).collect(Collectors.toList());
                System.out.println(targets);

                int index = new Random().nextInt(targets.size());

                o.attack(targets.get(index));
            }

            if (isWiped(enemies) || isWiped(friends)) {
                break;
            }
            System.out.println("\n");

            turn++;
            if (turn > 7) {
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