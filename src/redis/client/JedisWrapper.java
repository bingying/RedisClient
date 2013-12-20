package redis.client;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import redis.client.annotation.Relation;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class JedisWrapper implements JedisWrapInterface {

    private ShardedJedisPool pool = null;

    public JedisWrapper(ShardedJedisPool pool) {
        assert pool != null;
        this.pool = pool;
    }

    @Override
    @Relation("KEYS")
    public String keys(String pattern) {
        ShardedJedis shardedJedis = pool.getResource();
        Set<String> result = new TreeSet<String>();
        StringBuilder builder = new StringBuilder();
        try {
            Collection<Jedis> jedises = shardedJedis.getAllShards();
            for (Jedis tmp : jedises) {
                result.addAll(tmp.keys(pattern));
            }
            for (String tmp : result) {
                builder.append(tmp);
                builder.append('\n');
            }
        } catch (Exception e) {

        }
        return builder.toString();
    }

    @Override
    @Relation("GET")
    public String get(String key) {
        ShardedJedis shardedJedis = pool.getResource();
        try {
            return shardedJedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    @Relation("SET")
    public String set(String key, String value) {
        ShardedJedis shardedJedis = pool.getResource();
        try {
            return shardedJedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    @Relation("EXPIRE")
    public long expire(String key, String seconds) {
        ShardedJedis shardedJedis = pool.getResource();
        try {
            return shardedJedis.expire(key, Integer.valueOf(seconds));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    @Relation("exists")
    public boolean exists(String key) {
        ShardedJedis shardedJedis = pool.getResource();
        try {
            return shardedJedis.exists(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public long ttl(String key) {
        ShardedJedis shardedJedis = pool.getResource();
        try {
            return shardedJedis.ttl(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -2;
    }

    @Override
    public long del(String key) {
        ShardedJedis shardedJedis = pool.getResource();
        try {
            return shardedJedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public long expireAt(String key, String seconds) {
        ShardedJedis shardedJedis = pool.getResource();
        try {
            return shardedJedis.expireAt(key, Long.valueOf(seconds));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
