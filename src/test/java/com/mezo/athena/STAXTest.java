package com.mezo.athena;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.net.URL;

public class STAXTest {
    public static void main(String[] args) throws Exception {
        String urlString;
        if (args.length==0) {
            urlString = "http://www.sehutong43.com";
            System.out.println("Using:"+urlString);
        } else {
            urlString = args[0];
        }
        URL url = new URL(urlString);
        InputStream in = url.openStream();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(in);
        while (reader.hasNext()) {
            int event = reader.next();
            if (event == XMLStreamReader.START_ELEMENT) {
                if (reader.getLocalName().equals("a")) {
                    String href = reader.getAttributeValue(null, "href");
                    if (href!=null) {
                        System.out.println(href);
                    }
                }
            }
        }
    }
}
