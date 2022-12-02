package swordOffer.single;

/**
 * 4.线程安全的懒汉式：给方法加锁
 */
public class Singleton2 {
    private static Singleton2 ourInstance;

    public synchronized static Singleton2 getInstance() {
        if (null == ourInstance) {
            ourInstance = new Singleton2();
        }
        return ourInstance;
    }

    private Singleton2() {
    }
}
