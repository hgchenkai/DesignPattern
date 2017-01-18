package singleton;

/**
 * 静态内部类方式实际上是结合了饿汉式和懒汉式的优点的一种方式
 * Created by chuck on 17/1/18.
 */
public class SingletonInner {
    private SingletonInner() {
    }

    /**
     * 在调用getInstance()方法时才会去初始化mInstance
     * 实现了懒加载
     *
     * @return
     */
    public static SingletonInner getInstance() {
        return SingletonInnerHolder.mInstance;
    }

    /**
     * 静态内部类
     * 因为一个ClassLoader下同一个类只会加载一次，保证了并发时不会得到不同的对象
     */
    public static class SingletonInnerHolder {
        public static SingletonInner mInstance = new SingletonInner();
    }
}
