package proxy;

/**
 * 委托类，该类真正实现了request()
 * Created by chuck on 17/1/19.
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject::request");
    }
}
