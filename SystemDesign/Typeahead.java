/*
 3 - Web Crawler & Google Suggestion

Typeahead

Implement typeahead. Given a string and a dictionary, return all words that contains the string as a substring. The dictionary will give at the initialize method and wont be changed. The method to find all words with given substring would be called multiple times.

Have you met this question in a real interview? Yes
Example
Given dictionary = {"Jason Zhang", "James Yu", "Bob Zhang", "Larry Shi"}

search "Zhang", return ["Jason Zhang", "Bob Zhang"].

search "James", return ["James Yu"].
*/


public class Typeahead {
    private Trie trie;
    //suffix tree
    // @param dict A dictionary of words dict
    public Typeahead(Set<String> dict) {
        // do initialize if necessary
        trie = new Trie();
        for(String word : dict){
            for(int i = 0 ; i < word.length() ; ++ i){
                trie.insert(word.substring(i), word);
            }
        }
        
    }

    // @param str: a string
    // @return a list of words
    public List<String> search(String str) {
        // Write your code here
        return trie.search(str);
    }
    
    class TrieNode {
    // Initialize your data structure here.
        public HashMap<Character, TrieNode>  children;
        public Set<String> words;
        
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            words = new HashSet<String>();
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

    // Inserts a word into the trie.
        public void insert(String word, String fullWord) {
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                if(!cur.children.containsKey(c)){
                    cur.children.put(c, new TrieNode());
                }
                cur.children.get(c).words.add(fullWord);
                cur = cur.children.get(c);
            }
        }

        public List<String> search(String word) {
            TrieNode cur = root;
            List<String> result = new ArrayList<String>();
            for(char c : word.toCharArray()){
                if(!cur.children.containsKey(c)){
                    return result;
                }
                cur = cur.children.get(c);
            }
            result.addAll(cur.words);
            return result;

        }

    
    }
    
}