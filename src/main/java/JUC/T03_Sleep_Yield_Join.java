package JUC;

public class T03_Sleep_Yield_Join {

    public static void main(String[] args) {
        joinThread();
    }

    static void sleepThread() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("sleepThread：" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "sleepThread").start();
    }

    static void yieldThread() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("yieldThreadA：" + i);
                if (i % 10 == 0) Thread.yield();
            }
        }, "yieldThreadA").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("yieldThreadB：" + i);
                if (i % 10 == 0) Thread.yield();
            }
        }, "yieldThreadB").start();
    }

    static void joinThread() {
        Thread joinThreadA = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("joinThreadA：" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "joinThreadA");
        joinThreadA.start();
        new Thread(() -> {
            try {
                joinThreadA.join();
                System.out.println("yieldThreadB：");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "yieldThreadB").start();
    }
}
