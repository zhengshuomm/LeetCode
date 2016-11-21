/*
 9 - Message System & Rate Limiter

498. Parking Lot



Design a parking lot.

see CC150 OO Design for details.
1) n levels, each level has m rows of spots and each row has k spots.So each level has m x k spots.
2) The parking lot can park motorcycles, cars and buses
3) The parking lot has motorcycle spots, compact spots, and large spots
4) Each row, motorcycle spots id is in range [0,k/4)(0 is included, k/4 is not included), compact spots id is in range [k/4,k/4*3) and large spots id is in range [k/4*3,k).
5) A motorcycle can park in any spot
6) A car park in single compact spot or large spot
7) A bus can park in five large spots that are consecutive and within same row. it can not park in small spots

Have you met this question in a real interview? Yes
Example
level=1, num_rows=1, spots_per_row=11
parkVehicle("Motorcycle_1") // return true
parkVehicle("Car_1") // return true
parkVehicle("Car_2") // return true
parkVehicle("Car_3") // return true
parkVehicle("Car_4") // return true
parkVehicle("Car_5") // return true
parkVehicle("Bus_1") // return false
unParkVehicle("Car_5")
parkVehicle("Bus_1") // return true

*/

// enum type for Vehicle
enum VehicleSize {
    Motorcycle,
    Compact,
    Large,
}

abstract class Vehicle {
    // Write your code here
    protected String name;
    protected int spotsNeeded;
    protected VehicleSize size;
    protected List<Spot> spots;

    public Vehicle(){
        spots = new ArrayList<Spot>();
    }
    
    public int getSpotsNeeded(){
        return spotsNeeded;
    }
    
    public VehicleSize getSize(){
        return size;
    }
    
    public void parkInSpot(Spot spot){
        spots.add(spot);
    }
    
    public void clearSpots(){
        for(Spot spot: spots){
            spot.removeVehicle();
        }
        spots.clear();
    }
    
    public abstract boolean canFitInSpot(Spot spot);
}

class Motorcycle extends Vehicle {
    // Write your code here
    public Motorcycle(){
        super();
        size = VehicleSize.Motorcycle;
        spotsNeeded = 1;
    }
    
    public boolean canFitInSpot(Spot spot){
        return true;
    }
}

class Car extends Vehicle {
    // Write your code here
    public Car(){
        super();
        size = VehicleSize.Compact;
        spotsNeeded = 1;
    }
    
    public boolean canFitInSpot(Spot spot){
        return spot.getSize()==VehicleSize.Compact || spot.getSize()==VehicleSize.Large;
    }
}

class Bus extends Vehicle {
    // Write your code here
    public Bus(){
        super();
        size = VehicleSize.Large;
        spotsNeeded = 5;
    }
    
    public boolean canFitInSpot(Spot spot){
        return spot.getSize() == VehicleSize.Large;
    }
}

/* Represents a level in a parking garage */
class Level {
    // Write your code here
    private int floor;
    private int row;
    private Spot[][] spots;
    private int availableSpots;
    private int spotsPerRow;
    
    public Level(int floor, int row, int spotsPerRow){
        this.floor = floor;
        this.row = row;
        this.spotsPerRow = spotsPerRow;
        availableSpots = row*spotsPerRow;
        
        spots = new Spot[row][spotsPerRow];
        for(int i=0;i<row;++i){
            for(int j=0;j<spotsPerRow/4;++j){
                spots[i][j] = new Spot(this, i, j, VehicleSize.Motorcycle);
            }
            
            for(int j=spotsPerRow/4;j<spotsPerRow/4*3;++j){
                spots[i][j] = new Spot(this, i, j, VehicleSize.Compact);
            }
            
            for(int j=spotsPerRow/4*3;j<spotsPerRow;++j){
                spots[i][j] = new Spot(this, i, j, VehicleSize.Large);
            }
        }
    }
    
    public boolean parkVehicle(Vehicle vehicle){
        if(availableSpots < vehicle.getSpotsNeeded()){
            return false;
        }
        
        Spot firstSpot = findAvailableSpots(vehicle);
        if(firstSpot == null){
            return false;
        }
        
        return parkStartingAtSpot(firstSpot, vehicle);
    }
    
    private Spot findAvailableSpots(Vehicle v){
        int spotNeeded = v.getSpotsNeeded();
        for(int i=0;i<row;++i){
            int spotFound = 0;
            for(int j=0;j<spotsPerRow;++j){
                if(spots[i][j].canFitVehicle(v)){
                    spotFound ++;
                }
                if(spotFound == spotNeeded){
                    return spots[i][j-spotNeeded+1];
                }
            }
        }
        return null;
    }
    
    public boolean parkStartingAtSpot(Spot firstSpot, Vehicle v){
        int rowNum = firstSpot.getRow();
        int spotNum = firstSpot.getSpotNumber();
        int spotsNeeded = v.getSpotsNeeded();
        v.clearSpots();
        for(int i=0;i<spotsNeeded;++i){
            spots[rowNum][spotNum+i].park(v);
        }
        
        availableSpots -= spotsNeeded;
        return true;
    }
    
    public void spotFreed(){
        availableSpots ++;
    }
    
    public int availableSpots(){
        return availableSpots;
    }
    
}


class Spot{
    private Vehicle vehicle;
    private VehicleSize size;
    private int row;
    private int spotNumber;
    private Level level;
    
    public Spot(Level level, int row, int spotNumber, VehicleSize size){
        this.level = level;
        this.row = row;
        this.spotNumber = spotNumber;
        this.size = size;
    }
    
    public boolean isAvailable(){
        return vehicle == null;
    }
    
    public boolean canFitVehicle(Vehicle v){
        return isAvailable() && v.canFitInSpot(this);
    }
    
    public boolean park(Vehicle v){
        if(!canFitVehicle(v))
            return false;
        vehicle = v;
        v.parkInSpot(this);
        return true;
    }
    
    public void removeVehicle(){
        vehicle = null;
        level.spotFreed();
    }
    
    public int getRow(){
        return row;
    }
    
    public int getSpotNumber(){
        return spotNumber;
    }
    
    public VehicleSize getSize(){
        return size;
    }
}

public class ParkingLot {
     Level[] levels;
   
    // @param n number of leves
    // @param num_rows  each level has num_rows rows of spots
    // @param spots_per_row each row has spots_per_row spots
    public ParkingLot(int n, int num_rows, int spots_per_row) {
        // Write your code here
        levels  = new Level[n];
        for(int i=0;i<n;++i){
            levels[i] = new Level(i, num_rows, spots_per_row);
        }
    }

    // Park the vehicle in a spot (or multiple spots)
    // Return false if failed
    public boolean parkVehicle(Vehicle vehicle) {
        // Write your code here
        for(int i=0;i<levels.length;++i){
            if(levels[i].parkVehicle(vehicle))
                return true;
        }
        return false;
    }

    // unPark the vehicle
    public void unParkVehicle(Vehicle vehicle) {
        // Write your code here
        vehicle.clearSpots();

    }
}