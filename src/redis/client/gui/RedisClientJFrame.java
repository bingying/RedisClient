package redis.client.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import redis.client.gui.component.CommandShowTextArea;
import redis.client.gui.component.CommandText;

public class RedisClientJFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private ImageIcon icon = new ImageIcon("redis.jpg");

    private Container container = null;

    private CommandText commandText = null;

    private CommandShowTextArea commandShowTextArea = null;

    private RedisClientJFrame() {
        container = this.getContentPane();
    }

    private void initFrame() {
        this.setTitle("Redis-GUI");;
        this.setBounds(300, 300, 500, 500);
        this.setIconImage(icon.getImage());
        this.setMinimumSize(new Dimension(500, 500));
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        this.initFrame();
        this.initMenu();
        //        this.initJTextArea();
        //        this.initCommandJText();
        initTabed();
        this.pack();
    }

    public void initTabed() {
        JTabbedPane tabPane = new JTabbedPane();
        tabPane.setTabPlacement(JTabbedPane.BOTTOM);
        tabPane.addTab("首页", new JPanel());
        tabPane.add("开发环境", new JPanel());
        container.add(tabPane);
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu start = new JMenu("开始");
        menuBar.add(start);
        start.add(new JMenuItem("新建"));
        start.add(new JMenuItem("历史"));
    }

    private void initJTextArea() {
        commandShowTextArea = CommandShowTextArea.getInstance();
        JScrollPane jScrollPane = new JScrollPane(commandShowTextArea);
        container.add(jScrollPane, BorderLayout.CENTER);
    }

    private void initCommandJText() {
        commandText = CommandText.getInstance();
        commandText.addKeyListener(commandShowTextArea);
        container.add(commandText, BorderLayout.SOUTH);
    }

    public static RedisClientJFrame getInstance() {
        RedisClientJFrame redisClientJFrame = new RedisClientJFrame();
        redisClientJFrame.init();
        return redisClientJFrame;
    }
}
