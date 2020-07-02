package Momotaro.Dungeon;

import java.util.List;
import java.util.Random;

import Momotaro.Battle.Battle;
import Momotaro.Character.Boss;
import Momotaro.Character.BossDataBase;
import Momotaro.Character.FightingObject;
import Momotaro.Character.Hero;
import Momotaro.Character.Kintaro;
import Momotaro.Item.Consumable;
import Momotaro.Item.Item;
import Momotaro.Item.ItemDataBase;
import Momotaro.Item.WeaponManager;
import Momotaro.Output.Display;
import Momotaro.Output.MomotaroDeadException;
import Momotaro.Party.Inventory;
import Momotaro.Party.Party;

enum RoomType {
    NOTHING, COMBAT, TREASURE, FOUNTAIN, TRAP, UPSTAIR, BOSS, ADDFRIEND,
}

public class Room {

    private RoomType roomType;
    private double assaultRate;
    private double weaponDroprate;
    private int stairs;

    public Room(RoomType roomType) {
        this.roomType = roomType;
        this.assaultRate = 0.1;
        this.weaponDroprate = 0.2;
    }

    public Room() {
        this(getRandomRoomTypeByProbability());
    }

    public void event(Party p, int stairs) {
        this.stairs = stairs;

        int option;
        do {
            System.out.println("\n次の部屋へ進みますか？");
            Display.displayChoices(false, "はい", "PTを確認", "装備", "消費アイテム");
            option = Display.scanNextInt(4, false);
            switch (option) {
                case 0:
                    break;
                case 1:
                    System.out.println("---ステータス表示---");
                    for (Hero h : p.getHeroes()) {
                        System.out.println(h.toDetailString());
                    }
                    System.out.println("------------------");
                    break;
                case 2:
                    Inventory inv = p.getInventory();
                    inv.printWeapons();
                    if (inv.getWeapons().size() == 0) {
                        System.out.println("装備品を所持していません");
                        break;
                    }
                    int num = Display.scanNextInt(inv.getWeapons().size(), false);
                    System.out.println(inv.getWeapons().get(num).getName() + "を装備しますか？");
                    Display.displayChoices("はい", "いいえ");
                    int res = Display.scanNextInt(2, false);
                    if (res == 1)
                        break;
                    Hero mainHero = p.getMainHero();
                    inv.addWeapon(mainHero.getWeapon());
                    mainHero.setWeapon(inv.getWeapons().get(num));
                    inv.removeWeapon(mainHero.getWeapon());

                    break;
                case 3:
                    Inventory inv2 = p.getInventory();
                    inv2.printConsumbales();
                    if (inv2.getConsumables().size() == 0) {
                        System.out.println("消費アイテムを所持していません");
                        break;
                    }
                    int num2 = Display.scanNextInt(inv2.getConsumables().size(), false);
                    Consumable c = inv2.getConsumables().get(num2);
                    System.out.println(c.getName() + "をどうしますか？");
                    Display.displayChoices("使う", "捨てる", "キャンセル");
                    int yes = Display.scanNextInt(3, false);
                    switch (yes) {
                        case 0:
                            c.calcDamage((FightingObject) (p.getMainHero()),
                                    (List<FightingObject>) (Object) (p.getHeroes()),
                                    (List<FightingObject>) (Object) (p.getHeroes()), 0);
                            inv2.removeConsumables(c);
                            break;
                        case 1:
                            inv2.removeConsumables(c);
                            break;
                        case 2:
                            break;
                    }

                    break;

            }

        } while (option != 0);
        switch (roomType) {
            case NOTHING:
                initiateRest(p);
                break;
            case TREASURE:
                initiateEquip(p);
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
        Display.delayedPrint("\nボスに捕縛されていたやつが仲間にしてくれと言っている");
        Display.delayedPrint("仲間にしますか？");
        Display.displayChoices("はい", "いいえ");
        int option = Display.scanNextInt(2, false);
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
        Item item;
        if (this.weaponDroprate > Math.random()) {

            item = WeaponManager.getWeaponByProbability();
        } else {
            item = ItemDataBase.getItemByProbability();
        }
        Display.delayedPrint(item.toDetailString());
        System.out.println("拾う？");
        Display.displayChoices("はい", "いいえ");
        int option = Display.scanNextInt(2, false);
        switch (option) {
            case 0:
                p.getInventory().addItem(item);
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
            int option = Display.scanNextInt(2, false);
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

    private void initiateEquip(Party p) {
        Display.delayedPrint("\n宝箱発見！　開けてみますか？");
        Display.displayChoices("はい", "いいえ");
        int option1 = Display.scanNextInt(2, false);
        if (option1 == 1)
            return;

        Item item = WeaponManager.getWeaponByProbability();
        Display.delayedPrint(item.toDetailString());
        System.out.println("どうしますか？");
        Display.displayChoices("拾う", "スルー");
        int option = Display.scanNextInt(3, false);
        switch (option) {
            case 0:
                p.getInventory().addItem(item);
                break;
            case 1:
                break;
        }
    }

    private void initiateTrap(Party p) {
        Display.delayedPrint("\n宝箱発見！　開けてみますか？");
        Display.displayChoices("はい", "いいえ");
        int option1 = Display.scanNextInt(2, false);
        if (option1 == 1)
            return;

        Display.delayedPrint("\n起爆装置が起動した！罠だったみたいだ…");
        for (Hero h : p.getHeroes()) {
            h.getDamage(20);
        }

    }

    private static RoomType getRandomRoomType() {
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

    private static RoomType getRandomRoomTypeByProbability() {
        while (true) {
            RoomType roomtype = getRandomRoomType();
            double prob = getProbabilityForRoom(roomtype);
            if (Math.random() < prob) {
                return roomtype;
            }
        }

    }

    private static double getProbabilityForRoom(RoomType roomtype) {
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