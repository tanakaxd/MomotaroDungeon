import java.util.Scanner;

public class Display {

    public static Scanner scanner = new Scanner(System.in);
    public static boolean isDelayed = true;

    // 引数は選択肢の数。範囲外の場合もう一度入力を求める
    public static int scanNextInt(int amounts) {
        int option;
        boolean ok = false;
        do {
            option = scanner.nextInt();
            if (option >= 1 && option <= amounts) {

                ok = true;
            } else {
                System.out.println("***無効な入力です。もう一回やってみて***");
            }
        } while (!ok);
        return option - 1;
    }

    public static void displayChoices(String... lines) {// 可変長引数
        for (int i = 0; i < lines.length; i++) {
            int num = i + 1;
            System.out.println(" " + num + " --> " + lines[i]);
        }
    }

    public static void delayedPrint(String... lines) {

        try {
            Thread.sleep(800);
            for (int i = 0; i < lines.length; i++) {
                System.out.println(lines[i]);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 別スレッドを生成することになる
        // Timer timer = new Timer(false);
        // TimerTask task = new TimerTask() {

        // @Override
        // public void run() {

        // for (int i = 0; i < lines.length; i++) {
        // System.out.println(lines[i]);
        // }

        // // System.out.flush();
        // }
        // };
        // timer.schedule(task, 500);
    }

    public static void delayedPrint(int miliseconds, String... lines) {

        try {
            Thread.sleep(miliseconds);
            for (int i = 0; i < lines.length; i++) {
                System.out.println(lines[i]);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void delayedPrint(int miliseconds, int interval, String... lines) {

        try {
            Thread.sleep(miliseconds);
            for (int i = 0; i < lines.length; i++) {
                Thread.sleep(interval);
                System.out.println(lines[i]);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}