/*
 3 - Web Crawler & Google Suggestion

  Trie Service



Given a list of 

<"abc", 2>
<"ac", 4>
<"ab", 9>
Return <a[9,4,2]<b[9,2]<c[2]<>>c[4]<>>>, and denote the following tree structure:

         Root
         / 
       a(9,4,2)
      /    \
    b(9,2) c(4)
   /
 c(2)

*/
/**
 * Definition of TrieNode:
 * public class TrieNode {
 *     public NavigableMap<Character, TrieNode> children;
 *     public List<Integer> top10;
 *     public TrieNode() {
 *         children = new TreeMap<Character, TrieNode>();
 *         top10 = new ArrayList<Integer>();
 *     }
 * }
 */
public class TrieService {

    private TrieNode root = null;
    private int TOP_NUM = 10;

    public TrieService() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        // Return root of trie root, and 
        // lintcode will print the tree struct.
        return root;
    }

    // @param word a string
    // @param frequency an integer
    public void insert(String word, int frequency) {
        // Write your cod here
        if (word == null) {
    		return;
    	}
    	TrieNode cur = root;
    	for (Character ch : word.toCharArray()) {
    		if (!cur.children.containsKey(ch)) {
    			cur.children.put(ch, new TrieNode());
    		}
    		cur = cur.children.get(ch);
    		int ii = 0;
    		for (; ii < cur.top10.size(); ++ii) {
    			if (frequency > cur.top10.get(ii)) {
    				break;
    			}
    		}
    		cur.top10.add(ii, frequency);
    		if (cur.top10.size() > TOP_NUM) {
    			cur.top10.remove(TOP_NUM);
    		}
    	}
    }
 }