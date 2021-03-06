package redis.client.gui.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextArea;

import redis.client.model.CommandShow;

public class CommandShowTextArea extends JTextArea implements KeyListener, MouseListener,
        FocusListener {

    private static final long serialVersionUID = 1608059716141587156L;

    private CommandShowTextArea() {
        super();
    }

    public static CommandShowTextArea getInstance() {
        CommandShowTextArea jpane = new CommandShowTextArea();
        jpane.setFont(new Font("Italic", Font.BOLD, 14));
        jpane.setDisabledTextColor(Color.cyan);
        jpane.enableInputMethods(false);
        jpane.setAutoscrolls(true);
        jpane.setLineWrap(true);
        jpane.setFocusable(true);
        jpane.setEditable(false);
        jpane.addFocusListener(jpane);
        jpane.append("...Redis-GUI running...\n");
        return jpane;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (KeyEvent.VK_ENTER == e.getKeyCode()) {
            Action action = (Action) e.getSource();
            CommandShow show = action.action();
            this.append("::<-__->:: " + show.getCommand() + "\n");
            this.setCaretPosition(this.getText().length());
            this.append(show.getResult());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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

    @Override
    public void focusGained(FocusEvent e) {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        this.setCaretPosition(this.getText().length());
    }

    @Override
    public void focusLost(FocusEvent e) {
        // TODO Auto-generated method stub

    }

}
