package org.example;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import javax.swing.*;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

public class Window {
    public Window() {
        JFrame frame = new JFrame("BIG Business App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent panel1 = new JTextArea("\uD83D\uDC8E\uD83D\uDE4C\uD83D\uDCB9");
        tabbedPane.addTab("Tab 1", null, panel1, "");

        JComponent panel2 = null;
        try {
            Engine engine = Engine.newInstance(HARDWARE_ACCELERATED);
            Browser browser = engine.newBrowser();
            panel2 = BrowserView.newInstance(browser);
            browser.navigation().loadUrl("localhost:3000");
        } catch (Exception e) {
            panel2 = new JTextArea("*insert web content here*");
        }
        tabbedPane.addTab("Tab 2", null, panel2, "");
        frame.add(tabbedPane);
        frame.pack();
        frame.setVisible(true);
    }
}
