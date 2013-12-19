package redis.client;


public interface JedisWrapInterface {

    public String keys(String pattern);

    public String get(String key);

    public String set(String key, String value);

    public long expire(String key, String seconds);

    public boolean exists(String key);
}
