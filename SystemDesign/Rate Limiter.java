/*
 5 - Web System

 215 Rate Limiter



Implement a rate limiter, provide one method: is_ratelimited(timestamp, event, rate, increment).

timestamp: The current timestamp, which is an integer and in second unit.
event: The string to distinct different event. for example, "login" or "signup".
rate: The rate of the limit. 1/s (1 time per second), 2/m (2 times per minute), 10/h (10 times per hour), 100/d (100 times per day). The format is [integer]/[s/m/h/d].
increment: Whether we should increase the counter. (or take this call as a hit of the given event)
The method should return true or false to indicate the event is limited or not.

Have you met this question in a real interview? Yes
Example
is_ratelimited(1, "login", "3/m", true), return false.
is_ratelimited(11, "login", "3/m", true), return false.
is_ratelimited(21, "login", "3/m", true), return false.
is_ratelimited(30, "login", "3/m", true), return true.
is_ratelimited(65, "login", "3/m", true), return false.
is_ratelimited(300, "login", "3/m", true), return false.
*/


public class RateLimiter {
    private Map<String, List<Integer>> map = 
            new HashMap<String, List<Integer>>();
    /**
     * @param timestamp the current timestamp
     * @param event the string to distinct different event
     * @param rate the format is [integer]/[s/m/h/d]
     * @param increment whether we should increase the counter
     * @return true or false to indicate the event is limited or not
     */
    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        // Write your code here
        String[] rates = rate.split("/");
        int max = Integer.parseInt(rates[0]);
        if (max == 0) {
            return true;
        }
        int sec = calRate(rates);
        List<Integer> log = map.get(event);
        int count = 0;
        if(log != null){
            for(int i = log.size() - 1; i >= 0 ; i --){
                int preEventTime = log.get(i);
                if(timestamp - sec < preEventTime){
                    count ++;
                }else{
                    break;
                }
            }
        }
        boolean block = count >= max;
        if (!block && increment){
            if(log == null)
                log = new ArrayList<Integer>();
                map.put(event, log);
            log.add(timestamp);
            return false;
        }
        return block;
        
    }
    
    public int calRate(String[] rates){
        int sec = 1;
        switch (rates[1].charAt(0)) {
            case 'm':
                sec = 60;
                break;
            case 'h':
                sec = 60 * 60;
                break;
            case 'd':
                sec = 60 * 60 * 24;
                break;
        }
        return sec;
    }
}