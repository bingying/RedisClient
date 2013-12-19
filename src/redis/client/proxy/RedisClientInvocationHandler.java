package redis.client.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RedisClientInvocationHandler implements InvocationHandler {

    private Object object = null;

    public RedisClientInvocationHandler(Object obj) {
        this.object = obj;

    }

    public Object bind() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass()
                .getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(object, args);
    }

}
