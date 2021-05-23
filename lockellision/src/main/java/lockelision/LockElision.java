package lockelision;

/**
 * Lock elision
 *
 */
public class LockElision {

    static final Object lock1 = new Object();

    public static void main(String[] args) {
        lockElision(100);
    }

    public static int lockElision(int j) {
        Object lock = new Object();
        synchronized (lock) {
            j++;
        }
        return j;
    }

    public synchronized static void loop() {
        for (int i = 0; i < 15_000; i++) {
            lockElision(i);
        }
    }
}
