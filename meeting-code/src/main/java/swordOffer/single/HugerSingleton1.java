package swordOffer.single;


/**
 * 1.饿汉式：线程安全，耗费资源
 */
public class HugerSingleton1 {
    //该对象的引用不可修改
    private static final HugerSingleton1 ourInstance = new HugerSingleton1();

    public static HugerSingleton1 getInstance() {
        return ourInstance;
    }

    private HugerSingleton1() {
    }
}

