package com.mezo.athena;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RectangleComponent extends JComponent {
    private static final Dimension PREFERRED_SIZE = new Dimension(300,200);
    private List<Rectangle2D> rects;
    private List<Color> colors;
    private Random generator;
    private DocumentBuilder builder;
    public RectangleComponent() {
        rects = new ArrayList<>();
        colors = new ArrayList<>();
        generator = new Random();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void newDrawing() {
        int n = 10 + generator.nextInt(20);
        rects.clear();
        colors.clear();
        for (int i=1;i<=n;i++) {
            int x = generator.nextInt(getWidth());
            int y = generator.nextInt(getHeight());
            int width = generator.nextInt(getWidth() - x);
            int height = generator.nextInt(getHeight() - y);
            rects.add(new Rectangle(x,y,width,height));
            int r = generator.nextInt(256);
            int g = generator.nextInt(256);
            int b = generator.nextInt(256);
            colors.add(new Color(r,g,b));
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        if (rects.size() == 0) newDrawing();
        Graphics2D g2 = (Graphics2D) g;
        for (int i=0;i<rects.size();i++) {
            g2.setPaint(colors.get(i));
            g2.fill(rects.get(i));
        }
    }

    public Document buildDocument() {
        String namespace = "http://wwww.w3.org/2000/svg";
        Document doc = builder.newDocument();
        Element svgElement = doc.createElementNS(namespace,"svg");
        doc.appendChild(svgElement);
        svgElement.setAttribute("width","" + getWidth());
        svgElement.setAttribute("heigth","" + getHeight());
        for (int i=0;i<rects.size();i++) {
            Color color = colors.get(i);
            Rectangle2D r = rects.get(i);
            Element rectElement = doc.createElementNS(namespace,"rect");
            rectElement.setAttribute("x","" + r.getX());
            rectElement.setAttribute("y","" + r.getY());
            rectElement.setAttribute("width","" + r.getWidth());
            rectElement.setAttribute("heigth","" + r.getHeight());
            rectElement.setAttribute("fill",String.format("#%06x", color.getRGB() & 0xFFFFFF));
            svgElement.appendChild(rectElement);
        }
        return doc;
    }

    public void writeDocument(XMLStreamWriter writer) throws XMLStreamException {
        writer.writeStartDocument();
        writer.writeDTD("<!DOCTYPE svg PUBLIC \"-//W3C/DTD SVG 20000802//EN\" \"http://www.w3.org/TR/2000/CR-SVG-20000802/DTD/svg-20000802.dtd\">");
        writer.writeStartElement("svg");
        writer.writeDefaultNamespace("http://www.w3.org/2000/svg");
        writer.writeAttribute("width","" + getWidth());
        writer.writeAttribute("heigth","" + getHeight());
        for (int i=0;i<rects.size();i++) {
            Color color = colors.get(i);
            Rectangle2D r = rects.get(i);
            writer.writeEmptyElement("rect");
            writer.writeAttribute("x","" + r.getX());
            writer.writeAttribute("y","" + r.getY());
            writer.writeAttribute("width","" + r.getWidth());
            writer.writeAttribute("heigth","" + r.getHeight());
            writer.writeAttribute("fill",String.format("#%06x", color.getRGB() & 0xFFFFFF));
        }
        writer.writeEndDocument();
    }

    public Dimension getPreferredSize() {
        return PREFERRED_SIZE;
    }
 }
