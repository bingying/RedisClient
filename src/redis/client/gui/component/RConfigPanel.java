package redis.client.gui.component;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RConfigPanel extends JPanel {

    private static final long serialVersionUID = 9004372325668097333L;

    public RConfigPanel() {
        BoxLayout y = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(y);
        JPanel panel1 = new JPanel();
        panel1.setSize(250, 50);
        this.add(panel1);
        BoxLayout x1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
        panel1.setLayout(x1);
        JLabel titleLabel = new JLabel("群名:");
        titleLabel.setSize(40, 40);
        panel1.add(titleLabel);
        JTextField titleText = new JTextField();
        titleText.setSize(200, 40);
        panel1.add(titleText);
    }
}
