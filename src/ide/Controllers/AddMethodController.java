package ide.Controllers;

import ide.Views.AddMethodsDialog;
import ide.XML;
import javax.swing.JFrame;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AddMethodController {

    private CreateFileController controller;
    private AddMethodsDialog addMethDialog;
    private XML xml;
    private Element parentNode;
    private Document document;
    String[] variables = {"ganze", "schwimmer", "dopplet", "zeichenfolge", "saibling", "boolsech"};

    public AddMethodController(JFrame frame, CreateFileController controller, XML xml, Document document, Element parentNode) {
        this.controller = controller;
        this.xml = xml;
        this.parentNode = parentNode;
        this.document = document;
        addMethDialog = new AddMethodsDialog(frame, true, this);
        addMethDialog.setReturnModel(variables);
        addMethDialog.setLocationRelativeTo(null);
        addMethDialog.setVisible(true);
    }

    public void createMethod() {
        Element method = xml.createNode(document, "Method");
        xml.setAttribute(method, "name", addMethDialog.getNameText());
        if (addMethDialog.getVoidCheck()) {
            xml.setAttribute(method, "return", "void");
        } else {
            xml.setAttribute(method, "return", addMethDialog.getReturnText());
        }
        if (addMethDialog.getVariablesCheck()) {
            controller.createVariables(method);
        }
        xml.appendNode(parentNode, method);
    }

    public void done() {
        addMethDialog.dispose();
    }
}
