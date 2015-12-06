package ide.ToJava;

import java.util.ArrayList;
import org.w3c.dom.*;

public class Importsen {

    ArrayList<Includsen> importsen = new ArrayList<>();

//    public Importsen() {
//
//    }

//    public Importsen(Document document) {
//        NodeList imports = document.getElementsByTagName("importsen");
//        for (int i = 0; i < imports.getLength(); i++) {
//            Element element = (Element) imports.item(i);
//            String name = element.getAttribute("name");
//            Includsen includsen = new Includsen(name);
//            addIncludsen(includsen);
//        }
//    }

    public Importsen(Node node) {
        NodeList imports = node.getChildNodes();
        for (int i = 0; i < imports.getLength(); i++) {
            Node activeNode = imports.item(i);
            if (activeNode.getNodeType() == Node.ELEMENT_NODE) {
                Includsen includsen = new Includsen((Element) activeNode);
                addIncludsen(includsen);
            }
        }
    }

    public void addIncludsen(Includsen includsen) {
        importsen.add(includsen);
    }

    public String toJava() {
        String javaCode = "";
        for (Includsen includsen : importsen) {
            javaCode += includsen.toJava();
        }
        return javaCode;
    }
}
