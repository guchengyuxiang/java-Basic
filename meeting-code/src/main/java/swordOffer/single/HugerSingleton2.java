package swordOffer.single;

/**
 * 2.饿汉式：在静态代码块实例对象
 */
public class HugerSingleton2 {
    private final static HugerSingleton2 ourInstance;

    static {
        ourInstance = new HugerSingleton2();
    }

    public static HugerSingleton2 getInstance() {
        return ourInstance;
    }

    private HugerSingleton2() {
    }
}
