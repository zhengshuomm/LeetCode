/*
 7 - Location Based Service

525  Mini Uber



Support two basic uber features:

Drivers report their locations.
Rider request a uber, return a matched driver.
When rider request a uber, match a closest available driver with him, then mark the driver not available.

When next time this matched driver report his location, return with the rider's information.

You can implement it with the following instructions:

report(driver_id, lat, lng)
1) return null if no matched rider.
2) return matched trip information.

request(rider_id, lat, lng)
1) create a trip with rider's information.
2) find a closest driver, mark this driver not available.
3) fill driver_id into this trip.
4) return trip

This is the definition of Trip in Java:

public class Trip {
    public int id; // trip's id, primary key
    public int driver_id, rider_id; // foreign key
    public double lat, lng; // pick up location
}
Have you met this question in a real interview? Yes
Example
report(1, 36.1344, 77.5672) // return null
report(2, 45.1344, 76.5672) // return null
request(2, 39.1344, 76.5672) // return a trip, LOG(INFO): Trip(rider_id: 2, driver_id: 1, lat: 39.1344, lng: 76.5672)
report(1, 38.1344, 75.5672) // return a trip, LOG(INFO): Trip(rider_id: 2, driver_id: 1, lat: 39.1344, lng: 76.5672)
report(2, 45.1344, 76.5672) // return null

*/


/**
 * Definition of Trip:
 * public class Trip {
 *     public int id; // trip's id, primary key
 *     public int driver_id, rider_id; // foreign key
 *     public double lat, lng; // pick up location
 *     public Trip(int rider_id, double lat, double lng);
 * }
 * Definition of Helper
 * class Helper {
 *     public static double get_distance(double lat1, double lng1,
                                         double lat2, double lng2) {
 *         // return distance between (lat1, lng1) and (lat2, lng2)
 *     }
 * };
 */
class Location {
    public double lat, lng;
    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
} 
 
public class MiniUber {
    Map<Integer, Trip> driverTrip;
    Map<Integer, Location> driverLocation;
    public MiniUber() {
        // initialize your data structure here.
        driverTrip = new HashMap<Integer, Trip>();
        driverLocation = new HashMap<Integer, Location>();
    }

    // @param driver_id an integer
    // @param lat, lng driver's location
    // return matched trip information if there have matched rider or null
    public Trip report(int driver_id, double lat, double lng) {
        // Write your code here
        if(driverTrip.containsKey(driver_id)){
            //这里不汇报位置是因为没有必要
            return driverTrip.get(driver_id);
        }
        driverLocation.put(driver_id, new Location(lat, lng));
        return null;
    }

    // @param rider_id an integer
    // @param lat, lng rider's location
    // return a trip
    public Trip request(int rider_id, double lat, double lng) {
        // Write your code here
        Trip trip = new Trip(rider_id, lat, lng);
        int driver_id = -1;
        double min_dis = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Location> entry: driverLocation.entrySet()){
            Location location = entry.getValue();
            double dis = Helper.get_distance(lat, lng, location.lat, location.lng);
            if (dis < 0 || min_dis > dis) {
                driver_id = entry.getKey();
                min_dis= dis;
            }
        }
        if (driver_id != -1)
            driverLocation.remove(driver_id);
        trip.driver_id = driver_id;
        driverTrip.put(driver_id, trip);
        return trip;
    }
}