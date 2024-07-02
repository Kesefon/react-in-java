package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.lang.System.exit;

public class Window {
    public Window() {
        JFrame frame = new JFrame("BIG Business App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent panel1 = new JTextArea("\uD83D\uDC8E\uD83D\uDE4C\uD83D\uDCB9");
        tabbedPane.addTab("Tab 1", null, panel1, "");

        JComponent panel2 = null;
        try {
            panel2 = new JLabel(new ImageIcon(ImageIO.read(new File ("src/main/java/org/example/content.png"))));
        } catch (IOException e) {
            panel2 = new JTextArea("*insert web content here*");
        }
        tabbedPane.addTab("Tab 2", null, panel2, "");
        frame.add(tabbedPane);
        frame.pack();
        frame.setVisible(true);
    }
}
