package redis.client.gui.component;

import redis.client.model.CommandShow;

public interface Action {

    public String value();

    public CommandShow action();
}
