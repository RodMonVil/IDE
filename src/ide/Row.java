package ide;

import java.util.HashMap;
import java.util.Set;

public class Row {
    HashMap<String, String> data;
    
    public Row() {
        data = new HashMap();
    }
    
    public void put(String key, String value) {
        data.put(key, value);
    }
    
    public String get(String key) {
        return data.get(key);
    }
    
    public Set<String> getColumnNames() {
        return data.keySet();
    }
    
    @Override
    public String toString() {
        String info = "";
        Set<String> columns = getColumnNames();
        for(String column : columns) {
            info += column + " -> " + this.get(column) + "\n";
        }
        return info;
    }
}
