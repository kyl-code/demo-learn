package org.example.common;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.StringReader;

public class XmlRead {
    public static void main(String[] args) throws Exception {
        String xml = "";
        SAXReader saxReader = new SAXReader();
        saxReader.setEncoding("UTF-8");
        Document document = saxReader.read(new StringReader(xml));
        Node node = document.selectSingleNode("");
        String text = node.getText();
    }
}
