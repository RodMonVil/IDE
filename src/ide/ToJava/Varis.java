package ide.ToJava;

import java.util.ArrayList;
import org.w3c.dom.*;

public class Varis {
    ArrayList<Vari> varis = new ArrayList<>();
    
//    public Varis() {
//        
//    }
    
//    public Varis(Document document) {
//        NodeList varis = document.getElementsByTagName("vari");
//        for(int i = 0; i < varis.getLength(); i++) {
//            Element element = (Element) varis.item(i);
//            String name = element.getAttribute("name");
//            String type = element.getAttribute("type");
//            String value = element.getAttribute("value");
//            if(!value.isEmpty()) {
//                Vari vari = new Vari(type, name, value);
//                addVari(vari);
//            } else {
//                Vari vari = new Vari(type, name);
//                addVari(vari);
//            }
//        }
//    }
    
    public Varis(Node node) {
        NodeList varisList = node.getChildNodes();
        for (int i = 0; i < varisList.getLength(); i++) {
            Node activeNode = varisList.item(i);
            if (activeNode.getNodeType() == Node.ELEMENT_NODE) {
                Vari vari = new Vari((Element) activeNode);
                addVari(vari);
            }
        }
    }
    
    public void addVari(Vari vari) {
        varis.add(vari);
    }
    
    public String toJava() {
        String javaCode = "";
        for(Vari vari : varis) {
            javaCode += vari.toJava();
        }
        return javaCode;
    }
}
