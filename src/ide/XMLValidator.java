package ide;

import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.SAXException;

public class XMLValidator {

    private String errorMsg = "Something Happened";
    private boolean valid = false;
    
    public XMLValidator(String xsdPath, String xmlPath) {
        this.valid = validateXMLSchema(xsdPath, xmlPath);
    }
    
    private boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (SAXException | IOException ex) {
            this.errorMsg = ex.toString();
            return false;
        }
        return true;
    }
    
    public String getErrorMsg() {
        return this.errorMsg;
    }
    
    public boolean isValid() {
        return this.valid;
    }
    
}
