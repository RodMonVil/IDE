package ide.ToJava;

import org.w3c.dom.Node;

public class Printzen {
    
    String value;
    
    public Printzen(Node node) {
        this.value = node.getAttributes().item(0).getNodeValue();
    }
    
    public String toJava() {
        return "System.out.println(" + value + ");\n";
    }
}
