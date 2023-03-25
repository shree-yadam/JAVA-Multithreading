package members;

// Suspending and resuming a thread the modern way.
public class NewThread implements Runnable {
    String name; // name of thread
    public Thread t;

    Boolean suspendFlag;

    public NewThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + name);
        suspendFlag = false;
    }

    // This is the entry point for thread.
    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch(InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }

    synchronized public void mySuspend() {
        suspendFlag = true;
    }

    synchronized public void myResume() {
        suspendFlag = false;
        notify();
    }
}
