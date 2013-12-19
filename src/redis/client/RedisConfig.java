package redis.client;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.common.TimeUtil;

public class RedisConfig {

    private String host = "10.10.72.147";

    private int port = 6380;

    private int timeout = 3000;

    public RedisConfig() {
        Jedis jedis = new Jedis("", 6380);
        if (jedis != null) {
            System.out.println("Connect successed...10.10.72.147");
            Set<String> keys = jedis.keys("*");
            List<String> skeys = (List<String>) Arrays
                    .asList(keys.toArray(new String[keys.size()]));
            Collections.sort(skeys);
            Long second = 0l;
            for (String tmp : keys) {
                second = jedis.ttl(tmp);
                System.out.println(String.format("%-40s   %-8s  %-20s", tmp, " 有效时间: ",
                        TimeUtil.formatHMS(second)));
            }
        }
    }

    public Jedis createJedis() {
        Jedis jedis = new Jedis(host, port, timeout);
        return jedis;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
