/**
 * Definition of Tweet:
 * public class Tweet {
 *     public int id;
 *     public int user_id;
 *     public String text;
 *     public static Tweet create(int user_id, String tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
1. postTweet(user_id, tweet_text). Post a tweet.
2. getTimeline(user_id). Get the given user's most recently 10 tweets posted by himself, order by timestamp from most recent to least recent.
3.getNewsFeed(user_id). Get the given user's most recently 10 tweets in his news feed (posted by his friends and himself). Order by timestamp from most recent to least recent.
4.follow(from_user_id, to_user_id). from_user_id followed to_user_id.
5.unfollow(from_user_id, to_user_id). from_user_id unfollowed to to_user_id.
 */
public class MiniTwitter {
    class UserTweet{
        int user_id;
        int tweetNum;
        int tweetid;
        public UserTweet(int user_id, int tweetNum){
            this.user_id = user_id;
            this.tweetNum = tweetNum;
        }
    }
    
    private Map<Integer, Set<Integer>> friends;
    private Map<Integer, List<Tweet>> tweets;
    
    public MiniTwitter() {
        // initialize your data structure here.
        this.friends = new HashMap<Integer, Set<Integer>>();
        this.tweets = new HashMap<Integer, List<Tweet>>();
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here
        Tweet tweet = Tweet.create(user_id, tweet_text);
        if(!tweets.containsKey(user_id)){
            tweets.put(user_id, new ArrayList<Tweet>());
        }
        tweets.get(user_id).add(tweet);
        
        return tweet;
        
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        List<Tweet> newsfeed = new ArrayList<Tweet>();
        PriorityQueue<UserTweet> queue= new PriorityQueue<UserTweet>(10, new Comparator<UserTweet>(){
            public int compare(UserTweet u1, UserTweet u2){
                return tweets.get(u2.user_id).get(u2.tweetNum).id - tweets.get(u1.user_id).get(u1.tweetNum).id;
            }
        });
        if(friends.containsKey(user_id)){
            for(int friend_id : friends.get(user_id)){
                if(tweets.containsKey(friend_id)){
                    int friLastTweetNum = tweets.get(friend_id).size() -1;
                    UserTweet friLastTweet = new UserTweet(friend_id, friLastTweetNum);
                    queue.offer(friLastTweet);
                }
            }
        }
        
        if(tweets.containsKey(user_id)){
            int myLastTweetNum = tweets.get(user_id).size() -1;
            UserTweet myLastTweet = new UserTweet(user_id, myLastTweetNum);
            queue.offer(myLastTweet);
        }
        while(!queue.isEmpty() && newsfeed.size() < 10){
            UserTweet lastUserTweet = queue.poll();
            Tweet lastTweet = tweets.get(lastUserTweet.user_id).get(lastUserTweet.tweetNum);
            newsfeed.add(lastTweet);
            if(lastUserTweet.tweetNum > 0){
                UserTweet nextLastTweet = new UserTweet(lastUserTweet.user_id, lastUserTweet.tweetNum - 1);
                queue.offer(nextLastTweet);
            }
        }
        return newsfeed;
    }
        
    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here
        List<Tweet> timeline = new ArrayList<Tweet>();
        if (!tweets.containsKey(user_id)) {
            return timeline;
        }
        List<Tweet> tweet_list = tweets.get(user_id);
        int idx = tweet_list.size() - 1;
        for (int ii = 0; ii < 10; ii++) {
            if (idx >= 0) {
                timeline.add(tweet_list.get(idx--));
            } else {
                break;
            }
        }
        return timeline;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        if(from_user_id == to_user_id)
            return;
        if(!friends.containsKey(from_user_id)){
            friends.put(from_user_id, new HashSet<Integer>());
        }
        friends.get(from_user_id).add(to_user_id);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if(friends.containsKey(from_user_id))
            friends.get(from_user_id).remove(to_user_id);
    }
}