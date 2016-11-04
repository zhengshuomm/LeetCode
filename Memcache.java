
/*
Database & Consistent Hashing

Memcache

Actually, a real memcache server will evict keys if memory is not sufficient, and it also supports variety of value types like string and integer. In our case, let's make it simple, we can assume that we have enough memory and all of the values are integers.


Implement a memcache which support the following features:

get(curtTime, key). Get the key's value, return 2147483647 if key does not exist.
set(curtTime, key, value, ttl). Set the key-value pair in memcache with a time to live (ttl). The key will be valid from curtTime to curtTime + ttl - 1 and it will be expired after ttl seconds. if ttl is 0, the key lives forever until out of memory.
delete(curtTime, key). Delete the key.
incr(curtTime, key, delta). Increase the key's value by delta return the new value. Return 2147483647 if key does not exist.
decr(curtTime, key, delta). Decrease the key's value by delta return the new value. Return 2147483647 if key does not exist.
It's guaranteed that the input is given with increasingcurtTime.
*/



public class Memcache {

class Record{
    int key;
    int value;
    int deadTime;
    public Record(int key, int value, int deadTime){
        this.key = key;
        this.value = value;
        this.deadTime = deadTime;
    }
}

    HashMap<Integer, Record> map;
    public Memcache() {
        // Initialize your data structure here.
        map = new HashMap<Integer, Record>();
    }

    public int get(int curtTime, int key) {
        // Write your code here
        Record getRecord = map.get(key);
        if(getRecord == null || getRecord.deadTime < curtTime)
                return Integer.MAX_VALUE;
        return getRecord.value;
    }

    public void set(int curtTime, int key, int value, int ttl) {
        // Write your code here
        Record setRecord = new Record(key, value, ttl == 0? Integer.MAX_VALUE: curtTime + ttl - 1);
        map.put(key, setRecord);
    }

    public void delete(int curtTime, int key) {
        // Write your code here
        map.remove(key);
    }
    
    public int incr(int curtTime, int key, int delta) {
        // Write your code here
        Record getRecord = map.get(key);
        if(getRecord == null || getRecord.deadTime < curtTime)
                return Integer.MAX_VALUE;
        getRecord.value += delta;        
        return getRecord.value;
    }

    public int decr(int curtTime, int key, int delta) {
        // Write your code here
        Record getRecord = map.get(key);
        if(getRecord == null || getRecord.deadTime < curtTime)
                return Integer.MAX_VALUE;
        getRecord.value -= delta;        
        return getRecord.value;
    }
}