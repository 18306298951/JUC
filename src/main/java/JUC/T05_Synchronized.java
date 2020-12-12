package JUC;

public class T05_Synchronized {

    private int cout = 10;
    private Object o = new Object();

    public void m() {
        synchronized (o) {
            cout--;
            System.out.println(Thread.currentThread().getName() + " count" + cout);
        }

    }

    public void n() {
        synchronized (this) {
            cout--;
            System.out.println(Thread.currentThread().getName() + " count" + cout);
        }

    }

    public synchronized void o() {
        cout--;
        System.out.println(Thread.currentThread().getName() + " count" + cout);

    }
}
