package sdy;

public class Caller implements Runnable {
    String msg;
    CallMe target;
    public Thread t;

    public Caller (CallMe targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
    }

    // synchronize calls to call()
    @Override
    public void run() {
        synchronized (target) {
            target.call(msg);
        }

    }
}
