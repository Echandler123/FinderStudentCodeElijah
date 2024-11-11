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
    public Finder() {
        this.map = new HashMap();
    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        String line = br.readLine();
        String[] current;
        while(line != null){
            current = line.split(",");
            String key = current[keyCol];
            String val = current[valCol];
            map.add(key,val);
            line = br.readLine();
        }
        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        return map.get(key);
    }

}