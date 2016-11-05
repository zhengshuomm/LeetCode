/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/lfu-cache
@Language: Java
@Datetime: 16-10-20 04:23
*/

/**
 * Created by swang on 10/19/2016.
 */
public class LFUCache {
    PriorityQueue<Node> heap;
    HashMap<Integer, Node> map;
    int capacity;
    int total = 0;
    // @param capacity, an integer
    public LFUCache(int capacity) {
        // Write your code here
        this.heap = new PriorityQueue<Node>(capacity, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.feq ==  o2.feq) return o1.total - o2.total;
                return o1.feq - o2.feq;
            }
        });
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // Write your code here
        if(get(key) != -1){
            map.get(key).value = value;
            map.get(key).total = total ++;
            
            return;
        }
        
        Node cur = new Node(key, value, total ++);
        if(map.size() == capacity){
            map.remove(heap.peek().key);
            heap.poll();
        }
        map.put(key, cur);
        heap.add(cur);
        
        
        return;
    }

    public int get(int key) {
        // Write your code here
        if(!map.containsKey(key))
            return -1;
        Node cur = map.get(key);
        add(key);

        return cur.value;
    }
    
    public void add(int key){
        Iterator<Node> iter = heap.iterator();
        while(iter.hasNext()){
        	Node cur = iter.next();
            if(cur.key == key){
            	heap.remove(cur);
               cur.addFeq();
               cur.total = total ++;
               heap.add(cur);
               break;
            }
        }
    }
}

class Node{
    int key;
    int value;
    int feq = 0;
    int total;
    public Node(int key, int value, int total){
        this.key = key;
        this.value = value;
        this.total = total;
    }

    public void addFeq(){
        feq = feq + 1;
    }
}