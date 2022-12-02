package swordOffer.single;

/**
 * 3.懒汉式：非线程安全
 */
public class Singleton1 {
    private static Singleton1 ourInstance;

    public static Singleton1 getInstance() {
        if (null == ourInstance) {
            ourInstance = new Singleton1();
        }
        return ourInstance;
    }

    private Singleton1() {
    }
}
