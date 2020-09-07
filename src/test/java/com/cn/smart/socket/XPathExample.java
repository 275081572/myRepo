package com.cn.smart.socket;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
public class XPathExample {

    public static void main(String[] args)
            throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

        String str = "<inventory>\n" + "    <book year=\"2000\">\n" + "        <title>Snow Crash</title>\n" + "        <author>Neal Stephenson</author>\n" + "        <publisher>Spectra</publisher>\n" + "        <isbn>0553380958</isbn>\n" + "        <price>14.95</price>\n" + "    </book>\n" + "  \n" + "    <book year=\"2005\">\n" + "        <title>Burning Tower</title>\n" + "        <author>Larry Niven</author>\n" + "        <author>Jerry Pournelle</author>\n" + "        <publisher>Pocket</publisher>\n" + "        <isbn>0743416910</isbn>\n" + "        <price>5.99</price>\n" + "    <book>\n" + "  \n" + "    <book year=\"1995\">\n" + "        <title>Zodiac</title>\n" + "        <author>Neal Stephenson<author>\n" + "        <publisher>Spectra</publisher>\n" + "        <isbn>0553573862</isbn>\n" + "        <price>7.50</price>\n" + "    <book>\n" + " \n" + "    <!-- more books... -->\n" + "  \n" + "</inventory>";


        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse(str);

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        XPathExpression expr
                = xpath.compile("//book[author='Neal Stephenson']/title/text()");

        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

    }
}
