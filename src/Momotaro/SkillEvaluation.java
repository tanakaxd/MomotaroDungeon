package Momotaro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Momotaro.Item.Weapon;
import Momotaro.Item.WeaponManager;
import Momotaro.Skill.Skill;

public class SkillEvaluation {
    public static final String path = "C:\\Users\\T Tanaka\\Documents\\_Written\\Projects\\JavaProject\\MomotaroFight\\extractedData.csv";

    public static void main(String[] args) {
        java.util.List<Weapon> weapons = WeaponManager.getWeapons();

        BufferedWriter wr = null;
        try {
            wr = new BufferedWriter(new FileWriter(new File(path)));

            String line = "";

            for (int i = 0; i < weapons.size(); i++) {
                Weapon weapon = weapons.get(i);
                for (Skill s : weapon.getSkills()) {

                    line += weapon.getClass().getName() + "," + s.getName() + "," + s.isAOE() + "," + s.getTimes() + ","
                            + s.getDamageCoefficient() + "," + s.getMpConsumption() + "," + s.getDescription() + ","
                            + extrapolateDamage(s) + "," + evaluateSkill(s) + "\n";
                }
            }

            wr.write(line);
            wr.flush();

            // while ((line = br.readLine()) != null) {
            // String[] data = line.split(",", 0); // 行をカンマ区切りで配列に変換
            // if (count == 0) {
            // count++;
            // continue;
            // } else {

            // }
            // count++;
            // }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                wr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // try {
        // File f = new File(path);
        // br = new BufferedReader(new FileReader(f));

        // int count = 0;

        // String line;
        // // 1行ずつCSVファイルを読み込む

        // } catch (IOException e) {
        // System.out.println(e);
        // } finally {

        // br.close();
        // }
    }

    public static int extrapolateDamage(Skill skill) {
        int averageAtt = 15;
        int averageDef = 10;
        int value = (averageAtt * 4 - averageDef) * skill.getDamageCoefficient() / 100 * skill.getTimes();
        return value;

    }

    public static int evaluateSkill(Skill skill) {
        int averageAtt = 15;
        int averageDef = 10;
        int AOEcoefficient = skill.isAOE() ? 5 : 1;
        int value = (averageAtt * 4 - averageDef) * skill.getDamageCoefficient() / 100 * skill.getTimes()
                * AOEcoefficient / skill.getMpConsumption();

        return value;

    }

}