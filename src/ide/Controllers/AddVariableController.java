package ide.Controllers;

import ide.Views.AddVariablesDialog;
import ide.XML;
import javax.swing.JFrame;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AddVariableController {

    private CreateFileController controller;
    private AddVariablesDialog addVarDialog;
    private XML xml;
    private Element parentNode;
    private Document document;
    String[] variables = {"intze", "floastag", "dopplet", "stringze", "chaig", "boolsech"};

    public AddVariableController(JFrame frame, CreateFileController controller, XML xml, Document document, Element parentNode) {
        this.controller = controller;
        this.xml = xml;
        this.parentNode = parentNode;
        this.document = document;
        addVarDialog = new AddVariablesDialog(frame, true, this);
        addVarDialog.setTypeModel(variables);
        addVarDialog.setLocationRelativeTo(null);
        addVarDialog.setVisible(true);
    }

    public void createVariable() {
        Element variable = xml.createNode(document, "vari");
        xml.setAttribute(variable, "type", addVarDialog.getTypeText());
        xml.setAttribute(variable, "name", addVarDialog.getNameText());
        xml.setAttribute(variable, "value", addVarDialog.getValueText());
        xml.setText(variable, "\u200B");
        xml.appendNode(parentNode, variable);
    }

    public void done() {
        addVarDialog.dispose();
    }

}
