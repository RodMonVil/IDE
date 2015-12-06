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
        this.type = dictionary.translateToken(element.getAttribute("type"));
        this.name = element.getAttribute("name");
        if (element.hasAttribute("value")) {
            this.value = dictionary.translateToken(element.getAttribute("value"));
            if (this.value.isEmpty()) {
                this.value = element.getAttribute("value");
            }
        }
    }

    public String toJava() {
        if (value != null) {
            return "\t" + type + " " + name + " = " + value + ";\n";
        }
        return "\t" + type + " " + name + ";\n";
    }
}
