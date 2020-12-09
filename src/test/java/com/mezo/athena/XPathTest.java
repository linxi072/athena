package com.mezo.athena;

import javax.swing.*;
import java.awt.*;

public class XPathTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new XPathFrame();
            frame.setTitle("XPathTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
