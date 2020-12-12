package JUC;

public class T04_ThreadStatus {
    public static void main(String[] args) {
        Thread thread =  new Thread(() -> {

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "ThreadStatus");
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }
}
