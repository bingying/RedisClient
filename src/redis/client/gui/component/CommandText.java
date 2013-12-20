package redis.client.gui.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

import redis.client.model.CommandShow;
import redis.client.proxy.RedisClientCommandHandler;

public class CommandText extends JTextField implements Action {

    private static final long serialVersionUID = 7171525552742278083L;

    RedisClientCommandHandler commandHandler = RedisClientCommandHandler.getInstance();

    private CommandText() {
        super();
    }

    public static CommandText getInstance() {
        CommandText commandText = new CommandText();
        commandText.setFont(new Font("Italic", Font.BOLD, 16));
        commandText.setBackground(Color.BLACK);
        commandText.setForeground(Color.WHITE);
        commandText.setCaretColor(Color.WHITE);
        commandText.setFocusable(true);
        return commandText;
    }

    public void clear() {
        this.setText("");
    }

    @Override
    public CommandShow action() {
        CommandShow show = new CommandShow();
        try {
            String text = this.getText();
            String result = commandHandler.process(text);
            show.setCommand(text);
            show.setResult(result);
            this.clear();
            return show;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return show;
    }

    @Override
    public String value() {
        // TODO Auto-generated method stub
        return null;
    }
}
