package org.example;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;

public class Window {
    public Window() {
        JFrame frame = new JFrame("BIG Business App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent panel1 = new JTextArea("\uD83D\uDC8E\uD83D\uDE4C\uD83D\uDCB9");
        tabbedPane.addTab("Tab 1", null, panel1, "");

        JComponent panel2 = null;
        try {
            final JFXPanel fxPanel = new JFXPanel();
            panel2 = new JPanel();
            panel2.add(fxPanel);

            Platform.runLater(() -> initFX(fxPanel));
        } catch (Exception e) {
            panel2 = new JTextArea("*insert web content here*");
        }
        tabbedPane.addTab("Tab 2", null, panel2, "");
        frame.add(tabbedPane);
        frame.pack();
        frame.setVisible(true);
    }

    private static void initFX(JFXPanel fxPanel) {
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private static Scene createScene() {
        VBox root = new VBox();
        Scene scene = new Scene(root);

        WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();
        webEngine.load("http://localhost:3000");

        root.getChildren().add(webView);

        return (scene);
    }
}
