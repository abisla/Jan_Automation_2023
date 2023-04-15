package Day2_022623;

public class T1_LinearArray {
    public static void main(String[]args) {

        //create a list of cities in linear array
        String[] cities = new String[]{"Brookyln","Queens","Manhattan","Bronx","Staten Island"};
        //get the count of the list of cities
        System.out.println("Cities count"+ cities.length);
        //print out Brooklyn & Bronx from the List
        System.out.println("My cities are " + cities[0]+ " " + cities[3]);

        //create a list of zipcode
        int[] zipcode = new int[]{11218,22222,33333,55555};
        //get the count of hte list of zipcodes
        System.out.println("Zip code count " + zipcode.length);
        //print out 111218 & 33333 from the list
        System.out.println("My zipcodes are " + zipcode[0] + ", " + zipcode[2]);




    } //end of java
}//end of class
