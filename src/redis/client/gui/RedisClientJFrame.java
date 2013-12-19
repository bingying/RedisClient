package redis.client.gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.text.JTextComponent;

public class RedisClientJFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private ImageIcon icon = new ImageIcon("redis.jpg");

    private RedisClientJFrame() {

    }

    private void initFrame() {
        this.setTitle("Redis-GUI");;
        this.setBounds(300, 300, 500, 500);
        this.setIconImage(icon.getImage());
        this.setMinimumSize(new Dimension(300, 300));
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        this.initFrame();
        this.initMenu();
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu start = new JMenu("开始");
        menuBar.add(start);
        start.add(new JMenuItem("新建"));
        start.add(new JMenuItem("历史"));
    }

    private void initJText() {
       
    }

    public static RedisClientJFrame getInstance() {
        RedisClientJFrame redisClientJFrame = new RedisClientJFrame();
        redisClientJFrame.init();
        return redisClientJFrame;
    }
}
