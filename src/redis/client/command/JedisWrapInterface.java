package redis.client.command;

import redis.client.annotation.Relation;

public interface JedisWrapInterface {

    String[] commands = new String[] { "keys", "get", "set", "expire", "exists", "ttl", "del",
            "expireat", "help" };

    @Relation("keys")
    public String keys(String pattern);

    @Relation("get")
    public String get(String key);

    @Relation("set")
    public String set(String key, String value);

    @Relation("expire")
    public long expire(String key, String seconds);

    @Relation("exists")
    public boolean exists(String key);

    @Relation("ttl")
    public long ttl(String key);

    @Relation("del")
    public long del(String key);

    @Relation("expireat")
    public long expireAt(String key, String seconds);

    @Relation("help")
    public String help();
}
