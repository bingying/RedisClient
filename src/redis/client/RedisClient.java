package redis.client;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

public class RedisClient {

    private ShardedJedisPool pool = null;

    private List<Jedis> jedises = new ArrayList<Jedis>();

    public RedisClient() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxActive(1000);
        poolConfig.setMaxIdle(100);
        poolConfig.setMaxWait(3000);
        poolConfig.setTestOnBorrow(true);

        JedisShardInfo je1 = new JedisShardInfo("10.10.72.146", 6380);
        JedisShardInfo je2 = new JedisShardInfo("10.10.72.147", 6380);
        JedisShardInfo je3 = new JedisShardInfo("10.10.72.146", 6380);
        JedisShardInfo je4 = new JedisShardInfo("10.10.72.147", 6380);

        jedises.add(je1.createResource());
        jedises.add(je2.createResource());

        List<JedisShardInfo> list = new ArrayList<JedisShardInfo>();
        list.add(je1);
        list.add(je2); 
        list.add(je3);
        list.add(je4);
        pool = new ShardedJedisPool(poolConfig, list);

    }

    public ShardedJedisPool getPool() {
        return pool;
    }

    public List<Jedis> getJedises() {
        return jedises;
    }
}
