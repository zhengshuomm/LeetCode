/*
 5 - Web System

526  Load Balancer

Implement a load balancer for web servers. It provide the following functionality:

Add a new server to the cluster => add(server_id).
Remove a bad server from the cluster => remove(server_id).
Pick a server in the cluster randomly with equal probability => pick().
Have you met this question in a real interview? Yes
Example
At beginning, the cluster is empty => {}.

add(1)
add(2)
add(3)
pick()
>> 1         // the return value is random, it can be either 1, 2, or 3.
pick()
>> 2
pick()
>> 1
pick()
>> 3
remove(1)
pick()
>> 2
pick()
>> 3
pick()
>> 3

*/

public class LoadBalancer {
    HashMap<Integer,Integer> map;
    List<Integer> cluster;
    public LoadBalancer() {
        // Initialize your data structure here.
        map = new HashMap<Integer,Integer>();
        cluster = new ArrayList<Integer>();
    }

    // @param server_id add a new server to the cluster 
    // @return void
    public void add(int server_id) {
        // Write your code here
        if(!map.containsKey(server_id)){
            cluster.add(server_id);
            map.put(server_id, cluster.size() - 1);
        }
    }

    // @param server_id server_id remove a bad server from the cluster
    // @return void
    public void remove(int server_id) {
        // Write your code here
        if(map.containsKey(server_id)){
            int last = cluster.size() - 1;
            int index = map.get(server_id);
            cluster.set(index, cluster.get(last));
            map.put(cluster.get(last), index);
            cluster.remove(last);
            map.remove(server_id);
        }
    }

    // @return pick a server in the cluster randomly with equal probability
    public int pick() {
        // Write your code here
        Random random = new Random();
        int index = random.nextInt(cluster.size());
        return cluster.get(index);
    } 
}