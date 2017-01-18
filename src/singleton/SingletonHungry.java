package singleton;

/**
 * 饿汉式
 * 基于ClassLoader的机制，在同一classLoader下，该方式可以解决多线程同步的问题，
 * 但是该种单例模式没有办法实现懒加载
 * Created by chuck on 17/1/18.
 */
public class SingletonHungry {
    /**
     * 在ClassLoader加载该类时，就会初始化mInstance
     */
    private static SingletonHungry mInstance = new SingletonHungry();

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        return mInstance;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    SingletonHungry singletonHungry = SingletonHungry.getInstance();
                    System.out.println(singletonHungry.toString());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    SingletonHungry singletonHungry = SingletonHungry.getInstance();
                    System.out.println(singletonHungry.toString());
                }
            }
        }).start();
    }
}
