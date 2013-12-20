package redis.client;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import redis.client.annotation.Relation;

public class CommandRelationMapFactory {

    public static Map<String, Method> buildRelationMap() {
        Map<String, Method> methodMap = new HashMap<String, Method>();
        Class<? extends JedisWrapInterface> jedisClass = JedisWrapInterface.class;
        Method[] methods = jedisClass.getDeclaredMethods();
        for (Method tmp : methods) {
            Relation relation = tmp.getAnnotation(Relation.class);
            if (relation != null) {
                methodMap.put(relation.value().toUpperCase(), tmp);
            }
        }
        return methodMap;
    }
}
