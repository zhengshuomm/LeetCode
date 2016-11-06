/*
 3 - Web Crawler & Google Suggestion

 Implement Trie

Implement a trie with insert, search, and startsWith methods.

 Notice

You may assume that all inputs are consist of lowercase letters a-z.

Have you met this question in a real interview? Yes
Example
insert("lintcode")
search("code") // return false
startsWith("lint") // return true
startsWith("linterror") // return false
insert("linterror")
search("lintcode) // return true
startsWith("linterror") // return true

*/


/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    TrieNode [] children;
    boolean word;
    public TrieNode() {
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() == 0)
            return;
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(cur.children[index] == null){
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.word = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        if(word == null || word.length() == 0)
            return true;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null)
                return false;
            cur = cur.children[c - 'a'];
        }
        return cur.word;

    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        if(prefix == null || prefix.length() == 0)
            return true;
        for(char c : prefix.toCharArray()){
            if(cur.children[c - 'a'] == null)
                return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}