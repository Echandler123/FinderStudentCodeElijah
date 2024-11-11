public class HashMap {
    private int DEFAULT_TABLE_SIZE = 100000;
    private int tableSize = 0;
    private int keyNum = 0;
    private String[] keys;
    private String[] values;
    private String[] oldKeys;
    private String[] oldVals;
    private int hash = 0;
    private double maxCap = 0.5;
    private int oldSize;
    int radix = 256;
    public HashMap(){
        this.tableSize = DEFAULT_TABLE_SIZE;
        this.keys = new String[DEFAULT_TABLE_SIZE];
        this.values = new String[DEFAULT_TABLE_SIZE];
    }
    public HashMap(int tableSize){
        this.keys = new String[tableSize];
        this.values = new String[tableSize];
    }

    void add(String key, String value){
        if((double) keyNum / tableSize == maxCap){
            resize();
        }
    }
    String get(String key){
        return "INVALID KEY";
    }
    void resize(){
        oldSize = tableSize;
        tableSize = oldSize*2;
        oldKeys = keys;
        oldVals = values;
        keys = new String[tableSize];
        values = new String[tableSize];
        for(int i = 0; i < oldSize; i ++ ){
            if(oldKeys[i] != null){
                add(oldKeys[i], oldVals[i]);
            }
        }
    }
    public int hash(String Key) {
        int length = Key.length();
        for (int i = 0; i < length; i++) {
            this.hash = (hash * radix + Key.charAt(i)) % tableSize;
        }
        return hash;
    }

}
