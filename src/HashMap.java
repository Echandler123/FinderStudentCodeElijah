public class HashMap {
    private static final String INVALID = "INVALID KEY";
    private static final int DEFAULT_TABLE_SIZE = 100000;
    private int tableSize;
    private int keyNum = 0;
    private String[] keys;
    private String[] values;
    private static final double maxCap = 0.5;
    private static final int radix = 256;
    // Constructor when no table size is given so the default table size is used
    public HashMap() {
        this.tableSize = DEFAULT_TABLE_SIZE;
        this.keys = new String[DEFAULT_TABLE_SIZE];
        this.values = new String[DEFAULT_TABLE_SIZE];
    }
    // Constructor when table size is given
    public HashMap(int tableSize) {
        this.tableSize = tableSize;
        this.keys = new String[tableSize];
        this.values = new String[tableSize];
    }
    // Adds key and value pair to hash map
    public void add(String key, String value) {
        // Resizes the table if it reaches 50% or more capacity
        if((double) keyNum / tableSize >= maxCap) {
            resize();
        }
        int index = hash(key);
        // Add key and value pair if the current keys index is empty
        if(keys[index] == null){
            keys[index] = key;
            values[index] = value;
            keyNum++;
        }
        else{
            // Linear probing to counter collisions by moving to the next closes empty index when there is
            // a collision
            while(keys[index] != null) {
                index += 1;
                index = index % tableSize;
            }
        }
        // Add the key and value pair and increase the count of keys in the hashmap
        keys[index] = key;
        values[index] = value;
        keyNum++;
    }
    // Returns the corresponding value of given key snd returns invalid if there isn't one
    public String get(String key) {
        int index = hash(key);
        // Loops through the keys starting at the index that the key should be at and checks if the
        // key at the index is the same as the given key
        while(keys[index] != null) {
            if(keys[index].equals(key)) {
                return values[index];
            }
            index += 1;
            index = index % tableSize;
        }
        return INVALID;
    }
    // Doubles the size of the HashMap
    public void resize() {
        int oldSize = tableSize;
        tableSize = oldSize * 2;
        String[] oldKeys = keys;
        String[] oldVals = values;
        keys = new String[tableSize];
        values = new String[tableSize];
        // Re-adding old keys and values
        for(int i = 0; i < oldSize; i ++ ){
            if(oldKeys[i] != null){
                add(oldKeys[i], oldVals[i]);
            }
        }
    }
    // Calculates hash of given key
    public int hash(String Key) {
        int length = Key.length();
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * radix + Key.charAt(i)) % tableSize;
        }
        return hash % tableSize;
    }

}
