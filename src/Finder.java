import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [Elijah Chandler]
 **/

public class Finder {
    private HashMap map;
    // Constructor
    public Finder() {
        this.map = new HashMap();
    }
    // Creates hash map of the keys and values given
    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        String line = br.readLine();
        String[] current;
        // Loop through each line
        while(line != null){
            // Each line separated by commas so split the strings when a comma if found
            current = line.split(",");
            String key = current[keyCol];
            String val = current[valCol];
            // Add key and values to hash map
            map.add(key,val);
            line = br.readLine();
        }
        br.close();
    }
    // Searches hashmap for the value of a key given
    public String query(String key){
        return map.get(key);
    }
}