import members.NewThread;

public class SuspendResume {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");

        ob1.t.start(); // Start the thread
        ob2.t.start(); // Start the thread

        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("Suspending Thread One");
            Thread.sleep(1000);
            ob1.myResume();
            System.out.println("Resuming Thread One");
            ob2.mySuspend();
            System.out.println("Suspending Thread Two");
            Thread.sleep(1000);
            ob2.myResume();
            System.out.println("Resuming Thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // wait for threads to finish
        try {
            System.out.println("Waiting for threads to finish.");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
}
