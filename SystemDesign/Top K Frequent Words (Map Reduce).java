/*
6 - Map Reduce

549  Top K Frequent Words (Map Reduce)



Find top k frequent words with map reduce framework.

The mapper's key is the document id, value is the content of the document, words in a document are split by spaces.

For reducer, the output should be at most k key-value pairs, which are the top k words and their frequencies in this reducer. The judge will take care about how to merge different reducers' results to get the global top k frequent words, so you don't need to care about that part.

The k is given in the constructor of TopK class.

 Notice

For the words with same frequency, rank them with alphabet.

Have you met this question in a real interview? Yes
Example
Given document A =

lintcode is the best online judge
I love lintcode
and document B =

lintcode is an online judge for coding interview
you can test your code online at lintcode
The top 2 words and their frequencies should be

lintcode, 4
online, 3
*/


/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
class Pair implements Comparable<Pair>{
    String key;
    int value;
    public Pair(String key, int value){
        this.key = key;
        this.value = value;
    }
    @Override
    public int compareTo(Pair a){
        if(this.value != a.value) 
            return a.value - this.value;
        return this.key.compareTo(a.key);
    }
} 
 
 
public class TopKFrequentWords {

    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            StringTokenizer stringTokenizer = new StringTokenizer(value.content);
            while(stringTokenizer.hasMoreTokens()){
                String word = stringTokenizer.nextToken();
                output.collect(word, 1);
            }
        }
    }

    public static class Reduce {
        private PriorityQueue<Pair> queue;
        private int k;

        public void setup(int k) {
            // initialize your data structure here
            queue = new PriorityQueue<Pair>();
            this.k = k;
        }   

        public void reduce(String key, Iterator<Integer> values) {
            // Write your code here
            int count = 0;
            while (values.hasNext()){
                count += values.next();
            }
            Pair pair = new Pair(key, count);
            queue.offer(pair);
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
            for(int i = 0 ; i < k ; i ++){
                if(queue.isEmpty())
                    return;
                output.collect(queue.peek().key, queue.peek().value);
                queue.poll();
            }
            
        }
    }
}