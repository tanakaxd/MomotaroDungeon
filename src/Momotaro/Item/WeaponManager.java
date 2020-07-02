package Momotaro.Item;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class WeaponManager {
    private static WeaponManager theInstance;
    // 理想はクラスクラスとして個々の武器クラス所持しその都度インスタンス化すること
    private List<Weapon> weapons;

    private WeaponManager() {
        weapons = new ArrayList<>();
        // weapons.add(new Sude());
        weapons.add(new Sword());
        weapons.add(new Hammer());
        weapons.add(new Shuriken());
        weapons.add(new Kusarigama());
        weapons.add(new Pistol());
    }

    public static WeaponManager getInstance() {
        if (theInstance == null) {
            theInstance = new WeaponManager();
        }
        return theInstance;
    }

    public static Weapon getWeaponByProbability() {
        WeaponManager manager = getInstance();
        int count = 0;

        while (true) {
            int index = new Random().nextInt(manager.weapons.size());
            Weapon weapon = manager.weapons.get(index);
            if (Math.random() < weapon.getRarityRate() || count > 1000)
                try {
                    return weapon.getClass().getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                }

            count++;
        }

    }

    public static List<Weapon> getWeapons() {
        return getInstance().weapons;
    }
}