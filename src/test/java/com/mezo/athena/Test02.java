package com.mezo.athena;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @serial
 * @since
 */

public class Test02 {

//    @Test
    public void test01() {
        try {
            BufferedReader files = Files.newBufferedReader(Paths.get("/Users/qzrs/workstation/spring-error.2020-09-29.log"));
            while (files.ready()) {
                System.out.println(files.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void test02() {
        try {
            FileChannel channel = FileChannel.open(Paths.get("/Users/qzrs/workstation/spring-error.2020-09-29.log"));
            FileLock lock = channel.lock();
            lock.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

//    @Test
    public void test03() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            File f = new File("/Users/qzrs/workstation/Q012.xml");
            Document document = builder.parse(f);
            Element element = document.getDocumentElement();
            NodeList carQuoteGenReq = element.getElementsByTagName("CarQuoteGenReq");
            Node item = carQuoteGenReq.item(0);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void test04() throws NoSuchAlgorithmException, IOException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        SecureRandom random = new SecureRandom();
        generator.init(random);
        SecretKey key = generator.generateKey();
        ObjectOutputStream  outputStream = new ObjectOutputStream(new FileOutputStream(""));
        outputStream.writeObject(key);
    }
}
