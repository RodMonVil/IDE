package ide;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XML {

    private int numElements = 0;
    private String information;

    public XML() {
//        createDoc();
    }

    public Document createDoc() {
        Document document;
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            document = docBuilder.newDocument();
            document.setXmlStandalone(true);
            return document;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Document createDoc(File file) {
        Document document;
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            document = docBuilder.parse(file);
            document.getDocumentElement().normalize();
            return document;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Document createDoc(String dom) {
        Document document;
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            document = docBuilder.parse(new InputSource(new StringReader(dom)));
            document.getDocumentElement().normalize();
            return document;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Element createNode(Document document, String name) {
        Element node = document.createElement(name);
        return node;
    }

    public void setText(Element element, String text) {
        element.setTextContent(text);
    }

    public void setAttribute(Element element, String name, String value) {
        element.setAttribute(name, value);
    }

    public void appendNode(Element parent, Element child) {
        parent.appendChild(child);
    }

    public void appendNode(Document document, Element child) {
        document.appendChild(child);
    }

    public String createXMLFile(Document document, String fileName) {
        String filePath = "projects_DestructiveC/" + fileName + ".xml";
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //Activar Indentación
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");

            DOMSource source = new DOMSource(document);

            File archivo = new File(filePath);
            StreamResult resultFile = new StreamResult(archivo);
            transformer.transform(source, resultFile);
            return filePath;
        } catch (TransformerException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String createXMLString(Document document) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //Activar Indentación
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");

            DOMSource source = new DOMSource(document);

            StringWriter strWriter = new StringWriter();
            StreamResult resultString = new StreamResult(strWriter);
            transformer.transform(source, resultString);
            return strWriter.toString();
        } catch (TransformerException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String analizeXML(Document document) {
        information = "";
        numElements = 0;
        if (document.hasChildNodes()) {
            getChildNodes(document.getChildNodes());
            return information;
        }
        return "No Data";
    }

    public void getChildNodes(NodeList nodeList) {
        int listSize = nodeList.getLength();
        for (int count = 0; count < listSize; count++) {
            information += "\n";
            Node activeNode = nodeList.item(count);
            // make sure it's element node.
            if (activeNode.getNodeType() == Node.ELEMENT_NODE) {
                numElements++;
                // get node name and value
                information += numElements + ".  " + activeNode.getNodeName() + "\n    ";
                if (activeNode.hasAttributes()) {
                    information += "   Attributes:\n        ";
                    // get attributes names and values
                    NamedNodeMap nodeAttributes = activeNode.getAttributes();
                    int attributesLength = nodeAttributes.getLength();
                    for (int i = 0; i < attributesLength; i++) {
                        Node attribute = nodeAttributes.item(i);
                        information += attribute.getNodeName() + " --> " + attribute.getNodeValue() + "\n        ";
                    }
                    information = information.trim();
                }
                if (activeNode.hasChildNodes()) {
                    // loop again if has child nodes
                    getChildNodes(activeNode.getChildNodes());
                }
            }
            information = information.trim();
        }
    }
}
