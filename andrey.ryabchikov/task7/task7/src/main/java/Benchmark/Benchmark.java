package Benchmark;

import Temparary.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Benchmark {

    public static Service track(Service service) {
        if (service == null) {

            return null;

        }

        ClassLoader serviceClassLoader = service.getClass().getClassLoader();

        Class<?>[] interfaces = service.getClass().getInterfaces();

        return (Service) Proxy.newProxyInstance(serviceClassLoader, interfaces, new ServiceInvocationHandler(service));
    }

    public static Stat getStat(Service service) {

        if (service == null) {
            return null;
        }

        Stat stat = new Stat();
        Class<?> c = Service.class;
        Method[] m = c.getMethods();
        for (Method method : m) {
            if (method.isAnnotationPresent(Benchmarked.class)) {

                try {
                    long startTime = System.currentTimeMillis();
                    method.invoke(service);
                    stat.add("время выполнения: " + (System.currentTimeMillis() - startTime));

                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);

                }
            }
        }
        return stat;
    }
}
