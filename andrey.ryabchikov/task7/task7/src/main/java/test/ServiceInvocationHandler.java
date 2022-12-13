package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceInvocationHandler implements InvocationHandler {


    private final Service service;

    public ServiceInvocationHandler(Service service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.isAnnotationPresent(Benchmarked.class)) {

            long startTime = System.currentTimeMillis();
            method.invoke(service, args);
            System.out.println("время выполнения: " + (System.currentTimeMillis() - startTime));
            return null;

        } else {

            return method.invoke(service, args);

        }

    }
}
