package proxy.staticproxy;

import proxy.RealSubject;
import proxy.Subject;
import proxy.dynamicproxy.ProxyHandler;

import java.lang.reflect.Proxy;

/**
 * Created by chuck on 17/1/19.
 */
public class ProxyTest {
    public static void main(String[] args) {
        //静态代理
//        SubjectProxy proxy = new SubjectProxy();
//        //通过代理访问
//        proxy.request();
        ProxyHandler handler = new ProxyHandler();
        Subject proxy = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader()
                , RealSubject.class.getInterfaces(), handler);
        proxy.request();
    }
}
