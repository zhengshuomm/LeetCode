/*
 7 - Location Based Service

529 Geohash


Geohash is a hash function that convert a location coordinate pair into a base32 string.

Check how to generate geohash on wiki: Geohash or just google it for more details.

Try http://geohash.co/.

You task is converting a (latitude, longitude) pair into a geohash string.

Have you met this question in a real interview? Yes
Example
Given lat = 39.92816697, lng = 116.38954991 and precision = 12 which indicate how long the hash string should be. You should return wx4g0s8q3jf9.

The precision is between 1 ~ 12.

先经后纬，经纬交替
除去aoil

*/



public class GeoHash {
    /**
     * @param latitude, longitude a location coordinate pair 
     * @param precision an integer between 1 to 12
     * @return a base32 string
     */
    public String encode(double latitude, double longitude, int precision) {
        // Write your code here  
        //no aoil
        String base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        String lat = getBin(latitude, -90, 90);
        String lon = getBin(longitude, -180, 180);
        StringBuilder geo = new StringBuilder();
        for(int i = 0 ; i < lat.length() ; ++i){
            geo.append(lon.charAt(i));
            geo.append(lat.charAt(i));
        }
        
        StringBuilder geoHash = new StringBuilder();
        
        for(int i = 0 ; i < 5 * precision ; i += 5){
            String s = geo.substring(i, i + 5);
            geoHash.append(base32.charAt(binToBinaryInt(s)));
        }
        return geoHash.toString();
    }
    
    private int binToBinaryInt(String s){
        return Integer.parseInt(s, 2);
    }
    
    
    private String getBin(double value , double left, double right){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 30; ++i){
            double mid = (left + right) / 2.0;
            if(value > mid){
                sb.append("1");
                left = mid;
            }else{
                sb.append("0");
                right = mid;
            }
        }
        return sb.toString();
    }
}