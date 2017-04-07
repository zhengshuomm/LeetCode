import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by swang on 3/22/2017.
 */
public class ShortestWordDistance {
    public static void main(String[] args) {
        String [] words = {""practice"", ""coding"", ""perfect"", ""practice"", ""coding"", ""perfect"", ""coding"", ""makes""};

        System.out.println(shortestDistance2(words, ""practice"",""makes""));
    }

    /* SWD 1
    Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example, Assume that words = [""practice"", ""makes"", ""perfect"", ""coding"", ""makes""].

Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = ""makes"", word2 = ""coding"", return 1.

Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

    public static int shortestDistance(String [] words, String word1, String word2){
        int idx1 = -1, idx2 = -1, distance = Integer.MAX_VALUE;
        for(int i = 0 ; i < words.length ; i ++){
            if(words[i].equals(word1)){
                idx1 = i;
                if(idx2 != -1){
                    distance = Math.min(distance, idx1 - idx2);
                }
            }
            if(words[i].equals(word2)){
                idx2 = i;
                if(idx1 != -1){
                    distance = Math.min(distance, idx2 - idx1);
                }
            }
        }
        return distance;
    }


    /*
    * This is a follow up of Shortest Word Distance.
    *
    * The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters.
    *
    * How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example, Assume that words = [""practice"", ""makes"", ""perfect"", ""coding"", ""makes""].

Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = ""makes"", word2 = ""coding"", return 1.

Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
    *
    * */

    public static int shortestDistance2(String [] words, String word1, String word2){
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < words.length ; i ++){
            if(!map.containsKey(words[i])){
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }

        int distance = Integer.MAX_VALUE;

        for(int i = 0 ; i < map.get(word1).size(); i ++){
            for(int j = 0 ; j < map.get(word2).size(); j ++){
                distance = Math.min(distance, Math.abs(map.get(word1).get(i)- map.get(word2).get(j)));
            }
        }

        return  distance;

    }

/*
* This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example, Assume that words = [""practice"", ""makes"", ""perfect"", ""coding"", ""makes""].

Given word1 = “makes”, word2 = “coding”, return 1. Given word1 = ""makes"", word2 = ""makes"", return 3.

Note: You may assume word1 and word2 are both in the list.
*
*
* */

    public static int shortestDistance3(String [] words, String word1, String word2){
        int idx1 = -1, idx2 = -1, distance = Integer.MAX_VALUE;
        boolean turn = true;
        for(int i = 0 ; i < words.length ; i ++){
            if(words[i].equals(word1) && turn){
                idx1 = i;
                if(idx2 != -1){
                    distance = Math.min(distance, idx1 - idx2);
                }
                turn = !turn;
            }
            if(words[i].equals(word2) && !turn){
                idx2 = i;
                if(idx1 != -1){
                    distance = Math.min(distance, idx2 - idx1);
                }
                turn = !turn;

            }
        }
        return distance;
    }



}
"