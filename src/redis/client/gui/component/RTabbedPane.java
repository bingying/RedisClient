package redis.client.gui.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;

public class RTabbedPane extends JTabbedPane implements MouseListener {

    private static final long serialVersionUID = -2256030137528923839L;

    private JPopupMenu jPopupMenu = null;

    public RTabbedPane() {
        super();
        initPopMenu();
        setTabPlacement(JTabbedPane.BOTTOM);
        JPanel panel1 = new JPanel();
        addTab("首页", panel1);
        JPanel panel2 = new JPanel();
        add("新建", panel2);
        this.add(jPopupMenu);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.isPopupTrigger()) {
            jPopupMenu.show(this, e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    private void initPopMenu() {
        jPopupMenu = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("关闭");
        jPopupMenu.add(item1);
    }
}
