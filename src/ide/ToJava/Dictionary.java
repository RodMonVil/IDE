package ide.ToJava;

import java.util.*;

public class Dictionary {
    
    private Map<String, String> dictionary = new HashMap<>();
    
    public Dictionary() {
        generateDictionary();
    }
    
    public String translateToken(String token) {
        if(dictionary.containsKey(token)) {
            return dictionary.get(token);
        }
        return "";
    }
    
    private void generateDictionary() {
        dictionary.put("intze", "int");
        dictionary.put("floastag", "float");
        dictionary.put("dopplet", "double");
        dictionary.put("stringze", "String");
        dictionary.put("chaig", "char");
        dictionary.put("boolsech", "boolean");
        dictionary.put("trulsch", "true");
        dictionary.put("falsch", "false");
        dictionary.put("nein", "null");
        dictionary.put("volsch", "void");
        //Falta para impresion y calculos
    }
}
