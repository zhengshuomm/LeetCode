/*
 7 - Location Based Service

 509. Mini Yelp



Design a simple yelp system. Support the following features:

Add a restaurant with name and location.
Remove a restaurant with id.
Search the nearby restaurants by given location.
A location is represented by latitude and longitude, both in double. A Location class is given in code.

Nearby is defined by distance smaller than k Km .

Restaurant class is already provided and you can directly call Restaurant.create() to create a new object. Also, a Helper class is provided to calculate the distance between two location, use Helper.get_distance(location1, location2).

A GeoHash class is provided to convert a location to a string. Try GeoHash.encode(location) to convert location to a geohash string and GeoHash.decode(string) to convert a string to location.

 Notice

Learn about GeoHash http://www.lintcode.com/en/help/geohash/

Have you met this question in a real interview? Yes
Example
addRestauraunt("Lint Cafe", 10.4999999, 11.599999) // return 1
addRestauraunt("Code Cafe", 10.4999999, 11.512109) // return 2
neighbors(10.5, 11.6, 6.7) // return ["Lint Cafe"]
removeRestauraunt(1) 
neighbors(10.5, 9.6, 6.7) // return []


// The distance between location(10.5, 11.6) and "Lint Code" is 0.0001099 km
// The distance between location(10.5, 11.6) and "Code Code" is 9.6120978 km

*/


/**
 * Definition of Location:
 * class Location {
 *     public double latitude, longitude;
 *     public static Location create(double lati, double longi) {
 *         // This will create a new location object
 *     }
 * };
 * Definition of Restaurant
 * class Restaurant {
 *     public int id;
 *     public String name;
 *     public Location location;
 *     public static Restaurant create(String name, Location location) {
 *         // This will create a new restaurant object,
 *         // and auto fill id
 *     }
 * };
 * Definition of Helper
 * class Helper {
 *     public static get_distance(Location location1, Location location2) {
 *         // return distance between location1 and location2.
 *     }
 * };
 * class GeoHash {
 *     public static String encode(Location location) {
 *         // return convert location to a GeoHash string
 *     }
 *     public static Location decode(String hashcode) {
 *          // return convert a GeoHash string to location
 *     }
 * };
 */
class Distance{
    public String name;
    public Double distance;
    public Distance(Double distance, String name){
        this.distance = distance;
        this.name = name;
    }
} 
 
public class MiniYelp {
    public HashMap<Integer, Restaurant> restaurants;

    public MiniYelp() {
        // initialize your data structure here.
        restaurants = new HashMap<Integer, Restaurant>();
    }

    // @param name a string
    // @param location a Location
    // @return an integer, restaurant's id
    public int addRestaurant(String name, Location location) {
        // Write your code here
        Restaurant curRest = Restaurant.create(name, location);
        restaurants.put(curRest.id, curRest);
        return curRest.id;
    }

    // @param restaurant_id an integer
    public void removeRestaurant(int restaurant_id) {
        // Write your code here
        if(restaurants.containsKey(restaurant_id)){
            restaurants.remove(restaurant_id);
        }
    }

    // @param location a Location
    // @param k an integer, distance smaller than k miles
    // @return a list of restaurant's name and sort by 
    // distance from near to far.
    public List<String> neighbors(Location location, double k) {
        // Write your code here
        PriorityQueue<Distance> queue = new PriorityQueue<Distance>(11, new Comparator<Distance>(){
            public int compare(Distance a, Distance b){
                if(a.distance == b.distance){
                    return a.name.compareTo(b.name);
                }
                if(Math.abs(a.distance) < Math.abs(b.distance))
                    return -1;
                return 1;
            }
        });
        List<String> results = new ArrayList<String>();
        for (Map.Entry<Integer, Restaurant> entry : 
                restaurants.entrySet()) {
            int key = entry.getKey();
            Restaurant value = entry.getValue();
            double distance = Helper.get_distance(location, value.location);
            if (distance <= k)
                queue.offer(new Distance(distance, value.name));
        }
        while(!queue.isEmpty()){
            results.add(queue.peek().name);
            queue.poll();
        }
        return results;
    }
};