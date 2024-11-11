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

    private static final String INVALID = "INVALID KEY";

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        long prime = 2499998741L;
        int radix = 256;
        HashMap HM = new HashMap();
        String currentLine = br.readLine();
        while(currentLine != null){
            long num = hash(currentLine, radix,prime);
            [(int) num].add((int)hash(currentLine, radix,prime));
        }
        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        return INVALID;
    }
    public static long hash(String STR, int radix, long prime) {
        long hash = 0;
        int length = STR.length();
        for (int i = 0; i < length; i++) {
            hash = ((hash * radix + STR.charAt(i)) % prime);
        }
        return hash;
    }
}