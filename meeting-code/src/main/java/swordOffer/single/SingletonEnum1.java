package swordOffer.single;

/**
 * 第2题 单例设计模式
 * 设计一个类，只能生成该类的一个实例。
 *
 * @author qgl
 * @date 2019/06/21
 */
public class SingletonEnum1 {
    private SingletonEnum1() {
        System.out.println("SingletonPattern2");
    }

    public static SingletonEnum1 getInstance() {
        return SingletonEnum.INSTANCE.getSingletonPattern2();
    }

    /**
     * 7.线程安全的懒汉式：枚举
     */
    enum SingletonEnum {
        INSTANCE;
        private final SingletonEnum1 singletonEnum1;

        SingletonEnum() {
            singletonEnum1 = new SingletonEnum1();
        }

        private SingletonEnum1 getSingletonPattern2() {
            return singletonEnum1;
        }
    }

}


