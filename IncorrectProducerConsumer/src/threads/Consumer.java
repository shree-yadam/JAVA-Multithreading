package threads;

public class Consumer implements Runnable {
    Q q;
    public Thread t;

    public Consumer(Q q) {
        this.q = q;
        t = new Thread(this, "Consumer");
    }
    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}
