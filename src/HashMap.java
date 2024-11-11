public class HashMap {
    private int DEFAULT_TABLE_SIZE = 100000;
    private int tableSize = 0;
    private int keyNum = 0;
    private String[] keys;
    private String[] values;
    public HashMap(){
        this.keys = new string[DEFAULT_TABLE_SIZE];
        this.values = new string[DEFAULT_TABLE_SIZE];
    }
    public HashMap(int tableSize){
        this.keys = new string[tableSize];
        this.values = new string[tableSize];
    }

    int hash(String key){
        return 0;
    }
    void add(String key, String value){

    }
    String get(String key){
        return "0";
    }
    void resize(){

    }

}
