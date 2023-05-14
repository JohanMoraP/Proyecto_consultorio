package co.edu.uptc.view;

import javax.swing.plaf.basic.BasicButtonUI;

import javax.swing.*;
import java.awt.*;

public class RoundedButtonUI extends BasicButtonUI {

    private static final int ARC_SIZE = 20;

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();
        int width = b.getWidth();
        int height = b.getHeight();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (model.isArmed()) {
            g2.setColor(b.getBackground().darker());
        } else if (b.isEnabled()) {
            g2.setColor(new Color(41, 99, 99));
        } else {
            g2.setColor(Color.GRAY);
        }
        g2.fillRoundRect(0, 0, width, height, ARC_SIZE, ARC_SIZE);
        super.paint(g, c);
    }
}