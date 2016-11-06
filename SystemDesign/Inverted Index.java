/*
 3 - Web Crawler & Google Suggestion

 Inverted Index



Given a list of documents with id and content. (class Document)

[
  {
    "id": 1,
    "content": "This is the content of document 1 it is very short"
  },
  {
    "id": 2,
    "content": "This is the content of document 2 it is very long bilabial bilabial heheh hahaha ..."
  },
]
Return an inverted index (HashMap with key is the word and value is a list of document ids).

{
   "This": [1, 2],
   "is": [1, 2],
   ...
}
*/

/**
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class Solution {
    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        if(docs == null || docs.size() == 0)
            return map;
        for(Document doc : docs){
            String [] doccontent = doc.content.trim().split(" ");
            for(String strcontent : doccontent){
                if(strcontent.length() == 0)
                    continue;
                if(!map.containsKey(strcontent)){
                    map.put(strcontent, new ArrayList<Integer>());
                }
                if(map.get(strcontent).size() == 0 || map.get(strcontent).get(map.get(strcontent).size() - 1) != doc.id)
                    map.get(strcontent).add(doc.id);
            }
        }
        return map;
    }
}