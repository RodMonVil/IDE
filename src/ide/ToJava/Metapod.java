package ide.ToJava;

import org.w3c.dom.*;

public class Metapod {
    
    String name;
    String parameters;
    String type;
    String content = "";
    boolean isStartzen;
    Dictionary dictionary = new Dictionary();
    
    public Metapod(Node node, boolean isStartzen) {
        this.isStartzen = isStartzen;
        this.name = node.getAttributes().getNamedItem("name").getNodeValue();
        if (((Element) node).hasAttribute("return")) {
            this.type = dictionary.translateToken(node.getAttributes().getNamedItem("return").getNodeValue());
        }
        if (node.getAttributes().getNamedItem("parameters") != null) {
            this.parameters = node.getAttributes().getNamedItem("parameters").getNodeValue();
        } else {
            this.parameters = "";
        }
        
        if (node.hasChildNodes()) {
            NodeList contentList = node.getChildNodes();
            for (int i = 0; i < contentList.getLength(); i++) {
                Node activeNode = contentList.item(i);
                if (activeNode.getNodeType() == Node.ELEMENT_NODE) {
                    switch (activeNode.getNodeName()) {
                        case "varis":
                            Varis varis = new Varis(activeNode);
                            content += varis.toJava();
                            break;
                        case "printzen":
                            Printzen printzen = new Printzen(activeNode);
                            content += printzen.toJava();
                            break;
                    }
                }
            }
        }
        
    }
    
    public String toJava() {
        String javaCode = "";
        if (isStartzen) {
            javaCode += "\tpublic " + name + "(" + parameters + ") {\n";
        } else {
            javaCode += "\tpublic " + type + " " + name + "(" + parameters + ") {\n";
        }
        if (!content.isEmpty()) {
            javaCode += "\t" + content;
        }
        if (type != null && !type.equals("void")) {
            switch (type) {
                case "String":
                    javaCode += "\treturn \"\";\n";
                    break;
                case "char":
                    javaCode += "\treturn '';\n";
                    break;
                case "boolean":
                    javaCode += "\treturn false;\n";
                    break;
                default:
                    javaCode += "\treturn 0;\n";
                    break;
            }
        }
        javaCode += "\t}\n";
        return javaCode;
    }
}
