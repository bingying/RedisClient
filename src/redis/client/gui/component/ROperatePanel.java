package redis.client.gui.component;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ROperatePanel extends JPanel {

    private static final long serialVersionUID = 7877405750977847874L;

    private CommandText commandText = null;

    private CommandShowTextArea commandShowTextArea = null;

    private String title = "";

    public ROperatePanel(String title) {
        super();
        this.title = title;
        this.setLayout(new BorderLayout());
        initJTextArea();
        initCommandJText();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private void initJTextArea() {
        commandShowTextArea = CommandShowTextArea.getInstance();
        JScrollPane jScrollPane = new JScrollPane(commandShowTextArea);
        jScrollPane.setWheelScrollingEnabled(true);
        add(jScrollPane, BorderLayout.CENTER);
    }

    private void initCommandJText() {
        commandText = CommandText.getInstance();
        commandText.addKeyListener(commandShowTextArea);
        add(commandText, BorderLayout.SOUTH);
    }
}
