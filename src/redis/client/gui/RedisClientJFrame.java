package redis.client.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import redis.client.gui.component.RConfigPanel;
import redis.client.gui.component.ROperatePanel;
import redis.client.gui.component.RTabbedPane;

public class RedisClientJFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private ImageIcon icon = new ImageIcon("redis.jpg");

    private Container container = null;

    private RTabbedPane tabbedPane = null;

    private RedisClientJFrame() {
        container = this.getContentPane();

    }

    public void init() {
        this.initFrame();
        this.initMenu();
        this.add(new RConfigPanel());
        //        tabbedPane = new RTabbedPane();
        //        container.add(tabbedPane);
        this.pack();
    }

    private void initFrame() {
        this.setTitle("Redis-GUI");;
        this.setBounds(300, 300, 500, 500);
        this.setIconImage(icon.getImage());
        this.setMinimumSize(new Dimension(500, 500));
        this.setAlwaysOnTop(false);
        this.setVisible(true);
        this.setLayout(new CardLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addPanel(ROperatePanel rOperatePanel) {
        tabbedPane.addTab(rOperatePanel.getTitle(), rOperatePanel);
    }

    public void removePanel(ROperatePanel rOperatePanel) {
        tabbedPane.remove(rOperatePanel);
    }

    public void removePanel(int index) {
        tabbedPane.remove(index);
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu start = new JMenu("开始");
        menuBar.add(start);
        start.add(new JMenuItem("新建"));
        start.add(new JMenuItem("历史"));
    }

    public static RedisClientJFrame getInstance() {
        RedisClientJFrame redisClientJFrame = new RedisClientJFrame();
        redisClientJFrame.init();
        return redisClientJFrame;
    }
}
