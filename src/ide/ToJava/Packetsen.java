package ide.ToJava;

import org.w3c.dom.Node;

public class Packetsen {
    
    String name;
    
//    public Packetsen(String name) {
//        this.name = name;
//    }
    
    public Packetsen(Node node) {
        this.name = node.getAttributes().item(0).getNodeValue();
    }
    
    public String toJava() {
        return "package " + name + ";\n";
    }
}
