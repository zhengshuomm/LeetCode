/*
6 - Map Reduce

504   Inverted Index (Map Reduce)


Use map reduce to build inverted index for given documents.

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
public class InvertedIndex {

    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int id = value.id;
            StringTokenizer stringTokenizer = new StringTokenizer(value.content);
            while(stringTokenizer.hasMoreTokens()){
                String word = stringTokenizer.nextToken();
                output.collect(word, id);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            Set<Integer> set = new HashSet<Integer>();
            
            while(values.hasNext()){
                int val = values.next();
                set.add(val);
            }
            
            output.collect(key, new ArrayList<Integer>(set));
        }
    }
}
