/*
 7 - Location Based Service

530  Geohash II


This is a followup question for Geohash.

Convert a Geohash string to latitude and longitude.

Try http://geohash.co/.

Check how to generate geohash on wiki: Geohash or just google it for more details.

Have you met this question in a real interview? Yes
Example
Given "wx4g0s", return lat = 39.92706299 and lng = 116.39465332.

Return double[2], first double is latitude and second double is longitude.

*/


public class GeoHash {
    /**
     * @param geohash a base32 string
     * @return latitude and longitude a location coordinate pair
     */
    public double[] decode(String geohash) {
        // Write your code here
        // Write your code here
        String base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        double[] lon = {-180, 180};
        double[] lat = {-90, 90};
        StringBuilder sb = new StringBuilder();
        boolean isEven = true;
        for (char c : geohash.toCharArray()) {
            int val = base32.indexOf(c);
            int mask = 16;
            for (int i = 0; i < 5; ++i) {
                int bit = val & mask;
                if (isEven) {
                    narrowLoc(lon, bit);
                } else {
                    narrowLoc(lat, bit);
                }
                mask /= 2;
                isEven = !isEven;
            }
        }
        
        double[] loc = {(lat[0] + lat[1]) / 2.0, (lon[0] + lon[1]) / 2.0};
        return loc;
    }
    
    private void narrowLoc (double[] interval, int bit) {
        if (bit > 0) {
            interval[0] = (interval[0] + interval[1])/2.0;
        } else {
            interval[1] = (interval[0] + interval[1])/2.0;
        }
    }
    
    // private String getBin(double value, double left, double right) {
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < 30; ++i) {
    //         double mid = (left + right) / 2.0;
    //         if (value > mid) {
    //             left = mid;
    //             sb.append("1");
    //         } else {
    //             right = mid;
    //             sb.append("0");
    //         }
    //     }
    //     return sb.toString();
    // }
}