package swordOffer.single;

/**
 * 6.线程安全的懒汉式：静态内部类（推荐）
 */
public class Singleton4 {
    private static class SingletonHolder {
        private static Singleton4 ourInstance = new Singleton4();

    }

    public static Singleton4 getInstance() {
        return SingletonHolder.ourInstance;
    }

    private Singleton4() {
    }
}
