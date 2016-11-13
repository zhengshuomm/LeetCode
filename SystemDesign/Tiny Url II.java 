/*
 5 - Web System



As a follow up for Tiny URL, we are going to support custom tiny url, so that user can create their own tiny url.

 Notice

Custom url may have more than 6 characters in path.

Have you met this question in a real interview? Yes
Example
createCustom("http://www.lintcode.com/", "lccode")
>> http://tiny.url/lccode
createCustom("http://www.lintcode.com/", "lc")
>> error
longToShort("http://www.lintcode.com/problem/")
>> http://tiny.url/1Ab38c   // this is just an example, you can have you own 6 characters.
shortToLong("http://tiny.url/lccode")
>> http://www.lintcode.com/
shortToLong("http://tiny.url/1Ab38c")
>> http://www.lintcode.com/problem/
shortToLong("http://tiny.url/1Ab38d")
>> null


*/

public class TinyUrl2 {
    public static int globalId = 0;
    private HashMap<Integer, String> idUrlMap = new HashMap<Integer, String>();
    private HashMap<String, Integer> urlIdMap = new HashMap<String, Integer>();
    private HashMap<String, String> custom2LongMap = new HashMap<String, String>();
    private HashMap<String, String> long2CustomMap = new HashMap<String, String>();
    private String shortUrlHead = "http://tiny.url/";
    
    /**
     * @param long_url a long url
     * @param a short key
     * @return a short url starts with http://tiny.url/
     */
    String createCustom(String long_url, String short_key) {
        // Write your code here
        if (isNormalKey(short_key)) {
            int id = shortUrl2Id(short_key);
            if (idUrlMap.containsKey(id) && !idUrlMap.get(id).equals(long_url)) {
                return "error";
            }
            if (urlIdMap.containsKey(long_url) && urlIdMap.get(long_url) != id) {
                return "error";
            }
            if (idUrlMap.containsKey(id) || urlIdMap.containsKey(long_url)) {
                return shortUrlHead + short_key;
            }
        }
        
        if (custom2LongMap.containsKey(short_key) && 
                !custom2LongMap.get(short_key).equals(long_url)) {
            return "error";
        }
        
        if (long2CustomMap.containsKey(long_url) && 
                !long2CustomMap.get(long_url).equals(short_key)) {
            return "error";
        }
        
        custom2LongMap.put(short_key, long_url);
        long2CustomMap.put(long_url, short_key);
        
        return shortUrlHead + short_key;
    }

    /**
     * @param long_url a long url
     * @return a short url starts with http://tiny.url/
     */
    public String longToShort(String url) {
        // Write your code here
        if (long2CustomMap.containsKey(url)) {
            return shortUrlHead + long2CustomMap.get(url);
        }
        
        if (!urlIdMap.containsKey(url)) {
            globalId++;
            String shortKey = id2ShortUrl(globalId);
            while (custom2LongMap.containsKey(shortKey)) {
                globalId++;
                shortKey = id2ShortUrl(globalId);
            }
            idUrlMap.put(globalId, url);
            urlIdMap.put(url, globalId);
        }
        String shortUrl = id2ShortUrl(urlIdMap.get(url));
        return shortUrlHead + shortUrl;
    }

    /**
     * @param short_url a short url starts with http://tiny.url/
     * @return a long url
     */
    public String shortToLong(String url) {
        // Write your code here
        String shortKey = url.substring(shortUrlHead.length());
        if (custom2LongMap.containsKey(shortKey)) {
            return custom2LongMap.get(shortKey);
        }
        int id = shortUrl2Id(shortKey);
        return idUrlMap.get(id);
    }
    
    private String id2ShortUrl(int id) {
        StringBuilder result = new StringBuilder();
        int cnt = 0;
        while (cnt < 6) {
            result.insert(0, num2Char(id % 62));
            id /= 62;
            cnt++;
        }
        return result.toString();
    }
    
    public int shortUrl2Id(String url) {
        int id = 0;
        for (char c : url.toCharArray()) {
            int num = char2Num(c);
            if (num < 0) {
                return -1;
            }
            id = id * 62 + num;
        }
        return id;
    }
    
    private int char2Num(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        } else if ('a' <= c && c <= 'z') {
            return c - 'a' + 10;
        } else if ('A' <= c && c <= 'Z') {
            return c - 'A' + 36;
        }
        return -1;
    }
    
    private char num2Char(int n) {
        if (n <= 9) {
            return (char)('0' + n);
        } else if (n <= 35) {
            return (char)('a' + (n - 10));
        } else {
            return (char)('A' + (n - 36));
        }
    }
    
    private boolean isNormalKey(String short_key) {
        if (short_key.length() != 6) {
            return false;
        }
        for (int i = 0; i < 6; i++) {
            char c = short_key.charAt(i);
            if (c >= '0' && c <= '9') {
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                continue;
            }
            if (c >= 'A' && c <= 'Z') {
                continue;
            }
            return false;
        }
        return true;
    }
}