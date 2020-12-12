package JUC;

import java.util.concurrent.TimeUnit;

public class T06_Volatile {
    static volatile Boolean runnning = true;

    static void m() {
        System.out.println("start");
        while (runnning
        ) {
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        new Thread(T06_Volatile::m).start();
        try {
            TimeUnit.MICROSECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runnning = false;
    }
}
