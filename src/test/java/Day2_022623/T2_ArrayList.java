package Day2_022623;

import java.util.ArrayList;

public class T2_ArrayList {
    public static void main(String[] args) {

    //create an ArrayList of countries
        ArrayList<String> cities = new ArrayList<>();
        cities.add("new york city");
        cities.add("california");
        cities.add("sacremento");
        cities.add("philly");

        //Get count of list
        System.out.println("cities list:" + cities.size());
        //print only new york and cali
        System.out.println("cities are" + cities.get(0) + "," + cities.get(1)+"," + cities.get(2));

        cities.add("minnesota");
        //get the count
        System.out.println("cities list:" + cities.size());
        System.out.println(cities.get(4));

        ArrayList<Integer> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(347);
        phoneNumbers.add(346);
        phoneNumbers.add(345);
        phoneNumbers.add(344);

        System.out.println("phone numbers list:" + phoneNumbers.size());
        System.out.println("phone numbers are:" + phoneNumbers.get(0) + phoneNumbers.get(1)+phoneNumbers.get(2));











    ArrayList<String> countries = new ArrayList<>();
    countries.add("USA");
    countries.add("India");
    countries.add("Bangladesh");
    countries.add("Pakistan");

    //get the count of the list
    System.out.println("Countries list: " + countries.size());
    //Print only USA Bangladesh and India
    System.out.println("Countries are " + countries.get(0) + ","+ countries.get(1)+", " + countries.get(2));

    countries.add("Russia");
    //get the count of the List
    System.out.println("Countries list:" + countries.size());
    System.out.println(countries.get(4));

//create an integer ArrayList
ArrayList<Integer> areaCode = new ArrayList<>();
areaCode.add(777);
areaCode.add(222);
areaCode.add(333);
//get the count of the list
System.out.println("Area code list: " + areaCode.size());
//Print the first and third area code
        System.out.println("Area codes are " + areaCode.get(0) + ", " + areaCode.get(2));





    }//end of main
} //end of java