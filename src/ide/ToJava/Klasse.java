package ide.ToJava;

import org.w3c.dom.*;

public class Klasse {

    Packetsen packetsen;
    Importsen importsen;
    Varis globalVaris;
    String startzen;
    String metapods = "";
    String name;

//    public Klasse(String name) {
//        this.name = name;
//        importsen = new Importsen();
//        importsen.addIncludsen(new Includsen("java.util.*"));
//        globalVaris = new Varis();
//        globalVaris.addVari(new Vari("intze", "temp"));
//        globalVaris.addVari(new Vari("floastag", "aux", "1.6"));
//    }
//
//    public Klasse(Document document) {
//        Element element = document.getDocumentElement();
//        this.name = element.getAttribute("name");
//        importsen = new Importsen(document);
//        globalVaris = new Varis(document);
////        importsen.addIncludsen(new Includsen("java.util.*"));
////        globalVaris.addVari(new Vari("intze", "temp"));
////        globalVaris.addVari(new Vari("floastag", "aux", "1.6"));
//    }
    public Klasse(Element element) {
        this.name = element.getAttribute("name");
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node activeNode = nodeList.item(i);
            if (activeNode.getNodeType() == Node.ELEMENT_NODE) {
                switch (activeNode.getNodeName()) {
                    case "paketsen":
                        packetsen = new Packetsen(activeNode);
                        break;
                    case "importsen":
                        importsen = new Importsen(activeNode);
                        break;
                    case "varis":
                        globalVaris = new Varis(activeNode);
                        break;
                    case "startzen":
                        startzen = new Metapod(activeNode, true).toJava();
                        break;
                    case "metapod":
                        Metapod metapod = new Metapod(activeNode, false);
                        metapods += metapod.toJava();
                        break;
                }
            }
        }
    }

    public String toJava() {
        String javaCode = "";
        javaCode += packetsen.toJava() + "\n";
        if (importsen != null) {
            javaCode += importsen.toJava() + "\n";
        }
        javaCode += "public class " + name + " {\n";
        if (globalVaris != null) {
            javaCode += globalVaris.toJava();
        }
        if (startzen != null) {
            javaCode += startzen + "\n";
        }
        if (!metapods.isEmpty()) {
            javaCode += metapods + "\n";
        }
        javaCode += "}\n";
        return javaCode;
    }
}
