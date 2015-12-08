package ide.ToJava;

import org.w3c.dom.Element;

public class Vari {

    String type;
    String name;
    String value;
    Dictionary dictionary = new Dictionary();

//    public Vari(String type, String name, String value) {
//        this.type = type;
//        this.name = name;
//        this.value = value;
//    }
//    
//    public Vari(String type, String name) {
//        this.type = type;
//        this.name = name;
//    }
    public Vari(Element element) {
        type = dictionary.translateToken(element.getAttribute("type"));
        name = element.getAttribute("name");
        if (element.hasAttribute("value")) {
            value = dictionary.translateToken(element.getAttribute("value"));
            if (value.isEmpty()) {
                value = element.getAttribute("value");
                if (value.isEmpty()) {
                    switch (type) {
                        case "String":
                            value = "\"\"";
                            break;
                        case "char":
                            value = "''";
                            break;
                        case "boolean":
                            value = "false";
                            break;
                        default:
                            value = "0";
                            break;
                    }
                }
            }
        }
    }

    public String toJava() {
        if (value != null) {
            if (type.equals("String")) {
                return "\t" + type + " " + name + " = \"" + value + "\";\n";
            } else if (type.equals("char")) {
                return "\t" + type + " " + name + " = '" + value + "';\n";
            } else {
                return "\t" + type + " " + name + " = " + value + ";\n";
            }
        }
        return "\t" + type + " " + name + ";\n";
    }
}
