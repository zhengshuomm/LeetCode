/*
 2 - Database & Consistent Hashing

 Mini Cassandra

Cassandra is a NoSQL storage. The structure has two-level keys.

Level 1: raw_key. The same as hash_key or shard_key.
Level 2: column_key.
Level 3: column_value
raw_key is used to hash and can not support range query. let's simplify this to a string.
column_key is sorted and support range query. let's simplify this to integer.
column_value is a string. you can serialize any data into a string and store it in column value.

implement the following methods:

insert(raw_key, column_key, column_value)
query(raw_key, column_start, column_end) // return a list of entries

Example
insert("google", 1, "haha")
query("google", 0, 1)
>> [（1, "haha")]
*/



/**
 * Definition of Column:
 * public class Column {
 *     public int key;
 *     public String value;
 *     public Column(int key, String value) {
 *         this.key = key;
 *         this.value = value;
 *    }
 * }
 */
public class MiniCassandra {
    HashMap<String, TreeMap<Integer, String>>  map;
    public MiniCassandra() {
        // initialize your data structure here.
        map = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    /**
     * @param raw_key a string
     * @param column_start an integer
     * @param column_end an integer
     * @return void
     */
    public void insert(String raw_key, int column_key, String column_value) {
        // Write your code here
        if(!map.containsKey(raw_key)){
            TreeMap<Integer, String> colMap = new TreeMap<Integer, String>();
            map.put(raw_key, colMap);
        }
        map.get(raw_key).put(column_key, column_value);
    }

    /**
     * @param raw_key a string
     * @param column_start an integer
     * @param column_end an integer
     * @return a list of Columns
     */
    public List<Column> query(String raw_key, int column_start, int column_end){
        // Write your code here
        List<Column> result = new ArrayList<Column>();
        if(map.containsKey(raw_key)){
            SortedMap<Integer, String> range = map.get(raw_key).subMap(column_start, column_end + 1);
            for(Integer key : range.keySet()){
                result.add(new Column(key, range.get(key)));
            }
        }
        return result;

    }
}