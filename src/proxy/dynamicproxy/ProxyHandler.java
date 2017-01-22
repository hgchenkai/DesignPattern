package proxy.dynamicproxy;

import proxy.RealSubject;
import proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现InvocationHandler
 * Created by chuck on 17/1/19.
 */
public class ProxyHandler implements InvocationHandler {
    private Subject subject;

    public ProxyHandler() {
        subject = new RealSubject();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("ProxyHandler:preInvoke");
        Object result = method.invoke(subject, args);
        System.out.println("ProxyHandler:finishInvoke");
        return result;
    }
}
