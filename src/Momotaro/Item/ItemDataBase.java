package Momotaro.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class ItemDataBase {
    private static ItemDataBase theInstance;
    // 理想はクラスクラスとして個々のクラス所持しその都度インスタンス化すること
    private List<Item> items;

    private ItemDataBase() {
        items = new ArrayList<>();
        // items.add(new Sude());
        items.add(new Consumable("団子", ItemCategory.HEAL, false, 50));
        items.add(new Consumable("石", ItemCategory.DAMAGE, false, 30));

    }

    public static ItemDataBase getInstance() {
        if (theInstance == null) {
            theInstance = new ItemDataBase();
        }
        return theInstance;
    }

    public static Consumable getItemByProbability() {
        ItemDataBase manager = getInstance();
        int count = 0;

        while (count <= 1000) {
            int index = new Random().nextInt(manager.items.size());
            Item i = manager.items.get(index);
            if (i instanceof Consumable) {

                Consumable c = (Consumable) i;
                return c.clone();
            }
            count++;
        }
        System.out.println("infinite loop");
        return null;
        // if (Math.random() < item.getRarityRate() || count > 1000) {
        // count++;
        // return (Consumable) item.clone();

        // }
        // Consumableはコンストラクタに引数を取っているからnewInstanceできない
        // try {
        // return item.getClass().getDeclaredConstructor().newInstance();
        // } catch (InstantiationException | IllegalAccessException |
        // IllegalArgumentException
        // | InvocationTargetException | NoSuchMethodException | SecurityException e) {
        // e.printStackTrace();
        // }

    }

}
