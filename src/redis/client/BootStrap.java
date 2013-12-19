package redis.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import redis.client.proxy.RedisClientCommandHandler;
import redis.common.StringUtils;

public class BootStrap {

    public static void main(String[] args) throws Throwable {
        RedisClientCommandHandler commandHandler = RedisClientCommandHandler.getInstance();
        InputStreamReader brige = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(brige);
        try {
            String line = "";
            while (true) {
                System.out.print("<-_->:: ");
                line = reader.readLine();
                String result = commandHandler.process(line);
                if (!StringUtils.isBlank(result)) {
                    System.out.println(result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
