package JUC;

public class T02_HowToCreateThread {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello World MyThread!");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello World MyRun!");
        }
    }

    public static void main(String[] args) {

        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(() -> {
            System.out.println("Hello World MyLambda!");
        }, "MyLambda").start();
    }


}
