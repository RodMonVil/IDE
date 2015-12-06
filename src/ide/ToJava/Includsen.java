package ide.ToJava;

import org.w3c.dom.Element;

public class Includsen {

    String name;

    public Includsen(String name) {
        this.name = name;
    }

    public Includsen(Element element) {
        this.name = element.getAttribute("name");
    }

    public String toJava() {
        return "import " + name + ";\n";
    }
}
