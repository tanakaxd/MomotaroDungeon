package Momotaro.Dungeon;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;
import java.util.Random;

enum RoomType {
    NOTHING, COMBAT, TREASURE, FOUNTAIN, TRAP, UPSTAIR, BOSS, ADDFRIEND,
}

public class Room {

    private RoomType roomType;
    private double assaultRate;
    private int stairs;

    public Room() {
        this.roomType = getRandomRoomTypeByProbability();
        this.assaultRate = 0.1;
    }

    public Room(RoomType roomType) {
        this.roomType = roomType;
        this.assaultRate = 0.1;
    }

    public void event(Party p, int stairs) {
        this.stairs = stairs;

        int option;
        do {
            System.out.println("\n次の部屋へ進みますか？");
            Display.displayChoices("はい", "PTを確認");
            option = Display.scanNextInt(2);
            if (option == 1) {
                System.out.println("---ステータス表示---");
                for (Hero h : p.getHeroes()) {
                    System.out.println(h.toDetailString());
                }
                System.out.println("------------------");
            }

        } while (option != 0);
        switch (roomType) {
            case NOTHING:
                initiateRest(p);
                break;
            case TREASURE:
                initiateEquip(p.getMainHero());
                break;
            case COMBAT:
                initiateCombat(p, stairs);
                break;
            case TRAP:
                initiateTrap(p);
                break;
            case FOUNTAIN:
                initiateFountain(p);
                break;
            case UPSTAIR:
                initiateUpstair();
                break;
            case BOSS:
                initiateBoss(p, stairs);
                break;
            case ADDFRIEND:
                initiateAddFriend(p, stairs);
                break;
            default:
                break;
        }
    }

    private void initiateAddFriend(Party p, int stairs) {
        Display.delayedPrint("\nボスに捕縛されていたやつがいる");
        Display.delayedPrint("仲間にしますか？");
        Display.displayChoices("はい", "いいえ");
        int option = Display.scanNextInt(2);
        switch (option) {
            case 0:
                p.addHero(new Kintaro());
                System.out.println("金太郎が仲間になった！！");
                break;
            case 1:
                return;
        }

    }

    private void initiateBoss(Party p, int stairs) {
        Display.delayedPrint("\n強い殺気を感じる…");
        Display.delayedPrint(2000, "\n!!!!!!! 強敵が現れた !!!!!!!!");
        Boss boss = BossDataBase.getBossByStairs();
        Battle b = new Battle(p, boss);
        try {
            b.iterate();

        } catch (Exception e) {
            // 例外を一回中継する。キャッチして記録を表示した後、もう一度例外を発生させてMainまで伝播させる
            System.out.println("あなたの最終到達階層: " + this.stairs);
            e.printStackTrace();
            throw new MomotaroDeadException(null);
        } finally {
            // System.out.println("Room finally block excuted!");
        }
    }

    private void initiateFountain(Party p) {
        Display.delayedPrint("\n泉が湧き出ている");
        Display.delayedPrint("\n吸い込まれるように美しい部屋だ");
        Display.delayedPrint("\n戦いの傷が癒されていく");

        for (Hero h : p.getHeroes()) {
            h.healHp(h.getMaxHp() - h.getHp());
            h.healMp(h.getMaxMp() - h.getMp());
        }

    }

    private void initiateUpstair() {
        Display.delayedPrint("階段がある。次の階へ進みます");
    }

    public void initiateCombat(Party p, int stairs) {
        Display.delayedPrint("\n!!!! 敵が現れた !!!!");
        Battle b = new Battle(p, stairs);
        try {
            b.iterate();

        } catch (Exception e) {
            // 例外を一回中継する。キャッチして記録を表示した後、もう一度例外を発生させてMainまで伝播させる
            System.out.println("あなたの最終到達階層: " + this.stairs);
            e.printStackTrace();
            throw new MomotaroDeadException(null);
        } finally {
            // System.out.println("Room finally block excuted!");
        }

        Display.delayedPrint("敵は逃げ出した");
        Display.delayedPrint("アイテムを落としていったようだ");
        Weapon weapon = WeaponManager.getWeaponByProbability();
        Display.delayedPrint(weapon.toDetailString());
        System.out.println("装備する？");
        Display.displayChoices("はい", "いいえ");
        int option = Display.scanNextInt(2);
        switch (option) {
            case 0:
                p.getMainHero().setWeapon(weapon);
                break;
            case 1:
                return;
        }
    }

    private void initiateRest(Party p) {
        Display.delayedPrint("\n何もない部屋だ");

        int count = 1;

        while (true) {
            if (count >= 3) {
                System.out.println("同じ部屋にとどまり続けると敵に嗅ぎ付けられるかもしれない…");
            }
            System.out.println("休憩する？");
            Display.displayChoices("はい", "いいえ");
            int option = Display.scanNextInt(2);
            switch (option) {
                case 0:

                    p.rest();
                    // System.out.println(assaultRate);
                    if (Math.random() < assaultRate) {
                        initiateCombat(p, this.stairs);
                    }
                    assaultRate *= 2;
                    count++;
                    break;
                case 1:
                    return;
            }
        }
    }

    private void initiateEquip(Hero m) {
        Display.delayedPrint("\n宝箱発見！　開けてみますか？");
        Display.displayChoices("はい", "いいえ");
        int option1 = Display.scanNextInt(2);
        if (option1 == 1)
            return;

        Weapon weapon = WeaponManager.getWeaponByProbability();
        Display.delayedPrint(weapon.toDetailString());
        System.out.println("装備する？");
        Display.displayChoices("はい", "いいえ");
        int option = Display.scanNextInt(2);
        switch (option) {
            case 0:
                m.setWeapon(weapon);
                break;
            case 1:
                return;
        }
    }

    private void initiateTrap(Party p) {
        Display.delayedPrint("\n宝箱発見！　開けてみますか？");
        Display.displayChoices("はい", "いいえ");
        int option1 = Display.scanNextInt(2);
        if (option1 == 1)
            return;

        Display.delayedPrint("\n起爆装置が起動した！罠だったみたいだ…");
        for (Hero h : p.getHeroes()) {
            h.getDamage(20);
        }

    }

    private RoomType getRandomRoomType() {
        int random = new Random().nextInt(4);
        switch (random) {
            case 0:
                return RoomType.COMBAT;
            case 1:
                return RoomType.TREASURE;
            case 2:
                return RoomType.NOTHING;
            case 3:
                return RoomType.TRAP;
            case 4:
                return RoomType.FOUNTAIN;
            default:
                System.out.println("invalid arguments");
                return null;

        }
    }

    private RoomType getRandomRoomTypeByProbability() {
        while (true) {
            RoomType roomtype = getRandomRoomType();
            double prob = getProbabilityForRoom(roomtype);
            if (Math.random() < prob) {
                return roomtype;
            }
        }

    }

    private double getProbabilityForRoom(RoomType roomtype) {
        switch (roomtype) {
            case COMBAT:
                return 0.4;
            case TREASURE:
                return 0.2;
            case NOTHING:
                return 0.3;
            case TRAP:
                return 0.02;
            case FOUNTAIN:
                return 0.08;
            default:
                System.out.println("invalid arguments");
                return 0;

        }
    }

}