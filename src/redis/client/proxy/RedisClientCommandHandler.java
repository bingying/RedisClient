package redis.client.proxy;

import java.lang.reflect.Method;
import java.util.Map;

import redis.client.CommandRelationMapFactory;
import redis.client.JedisWrapInterface;
import redis.client.JedisWrapper;
import redis.client.RedisClient;
import redis.clients.jedis.ShardedJedisPool;
import redis.common.StringUtils;

public class RedisClientCommandHandler {

    private JedisWrapInterface jedisWrapper;

    private Map<String, Method> commandMap;

    private RedisClientCommandHandler() {

    }

    private void init() {
        RedisClient client = new RedisClient();
        ShardedJedisPool pool = client.getPool();
        jedisWrapper = new JedisWrapper(pool);
        this.commandMap = CommandRelationMapFactory.buildRelationMap();
    }

    public static RedisClientCommandHandler getInstance() {
        RedisClientCommandHandler clientCommandHandler = new RedisClientCommandHandler();
        clientCommandHandler.init();
        return clientCommandHandler;
    }

    public String process(String line) throws Throwable {
        if (line == null || line.length() == 0 || line.trim() == "") {
            return "";
        }

        line = line.trim();
        String[] args = StringUtils.split(line);
        if (args.length < 2) return "";

        Method method = commandMap.get(args[0].toUpperCase());
        if (method == null) {
            return "无效的命令 " + args[0];
        }
        args = getArgs(args);
        int paramLe = method.getGenericParameterTypes().length;
        if (!(args.length == paramLe)) {
            return "无效的命令 " + line;
        }

        Object obj = method.invoke(jedisWrapper, args);

        return obj == null ? "" : obj.toString();
    }

    private String[] getArgs(String[] args) {
        String[] temp = new String[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            temp[i - 1] = args[i];
        }
        return temp;
    }
}
