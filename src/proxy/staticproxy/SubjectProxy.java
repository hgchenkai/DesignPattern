package proxy.staticproxy;

import proxy.RealSubject;
import proxy.Subject;

/**
 * 代理类，通过其访问委托的实现
 * Created by chuck on 17/1/19.
 */
public class SubjectProxy implements Subject {
    Subject subject;

    public SubjectProxy() {
        this.subject = new RealSubject();
    }

    @Override
    public void request() {
        System.out.println("SubjectProxy:preRequest");
        if (subject != null) {
            subject.request();
        }
        System.out.println("SubjectProxy:finishRequest");
    }
}
