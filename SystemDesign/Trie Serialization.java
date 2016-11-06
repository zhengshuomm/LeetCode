/*
 3 - Web Crawler & Google Suggestion

Trie Serialization

Serialize and deserialize a trie (prefix tree, search on internet for more details).

You can specify your own serialization algorithm, the online judge only cares about whether you can successfully deserialize the output from your own serialize function.

 Notice

You don't have to serialize like the test data, you can design your own format.

Have you met this question in a real interview? Yes
Example
str = serialize(old_trie)
>> str can be anything to represent a trie
new_trie = deserialize(str)
>> new_trie should have the same structure and values with old_trie
An example of test data: trie tree <a<b<e<>>c<>d<f<>>>>, denote the following structure:

     root
      /
     a
   / | \
  b  c  d
 /       \
e         f

*/


/**
 * Definition of TrieNode:
 * public class TrieNode {
 *     public NavigableMap<Character, TrieNode> children;
 *     public TrieNode() {
 *         children = new TreeMap<Character, TrieNode>();
 *     }
 * }
 */
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a trie which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TrieNode root) {
        // Write your code here
        if(root == null)
            return "";
        StringBuilder seriRoot = new StringBuilder();
        serializeHelper(seriRoot, root);
        return seriRoot.toString();
    }
    
    public void serializeHelper(StringBuilder seriRoot, TrieNode root){
        seriRoot.append('<');
        for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
        	seriRoot.append(entry.getKey());
        	serializeHelper(seriRoot, entry.getValue());
        }
        seriRoot.append('>');


    }
    

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TrieNode deserialize(String data) {
        // Write your code here
        TrieNode root = new TrieNode();
        if(data == null || data.length() == 0)
            return root;
        TrieNode cur = root;
        Stack<TrieNode> stack = new Stack<TrieNode>();
        for(char c : data.toCharArray()){
            if(c == '<'){
                stack.push(cur);
            }else if (c == '>'){
                stack.pop();
            }else{
                cur = new TrieNode();
                stack.peek().children.put(c, cur);
            }
        }
        return root;
    }
}
