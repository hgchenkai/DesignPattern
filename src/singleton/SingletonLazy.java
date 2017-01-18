package singleton;

/**
 * 懒汉式
 * 只有在getInstance（）时才会初始化mInstance
 * Created by chuck on 17/1/18.
 */
public class SingletonLazy {
    private static SingletonLazy mInstance;

    private SingletonLazy() {

    }

    /**
     * 懒加载，线程不安全
     * @return
     */
    public static SingletonLazy getInstanceUnLocked() {
        if (mInstance == null) {
            mInstance = new SingletonLazy();
        }
        return mInstance;
    }

    /**
     * 懒加载 线程安全
     * @return
     */
    public static synchronized SingletonLazy getInstanceLocked() {
        if (mInstance == null) {
            mInstance = new SingletonLazy();
        }
        return mInstance;
    }

    /**
     * 双重检查锁定DCL
     * @return
     */
    public static SingletonLazy getInstance() {
        if (mInstance == null) {//第一次检查
            synchronized (SingletonLazy.class) {//加锁
                if (mInstance == null) {//第二次次检查
                    mInstance = new SingletonLazy();//new 一个对象
                }
            }
        }
        return mInstance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        SingletonLazy singletonLazy = SingletonLazy.getInstanceUnLocked();
                        System.out.println("Thread" + i + ":" + singletonLazy.toString());
                    }
                }
            }).start();
        }
    }
}
