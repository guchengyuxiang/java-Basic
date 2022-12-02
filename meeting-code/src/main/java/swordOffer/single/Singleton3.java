package swordOffer.single;

/**
 * 5.线程安全的懒汉式：双重检查锁（同步代码块）--- volatile 避免指令重排序
 */
public class Singleton3 {
    private static volatile Singleton3 ourInstance;

    public static Singleton3 getInstance() {
        if (null == ourInstance) {
            synchronized (Singleton3.class) {
                if (null == ourInstance) {
                    // volatile 避免指令重排序
                    ourInstance = new Singleton3();
                }
            }
        }
        return ourInstance;
    }

    private Singleton3() {
    }
}
