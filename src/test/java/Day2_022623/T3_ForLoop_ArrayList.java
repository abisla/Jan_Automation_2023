package Day2_022623;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class T3_ForLoop_ArrayList {
    public static void main(String[]args) {
        //create an ArrayList of countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("India");
        countries.add("Bangladesh");
        countries.add("Russia");
        countries.add("Canada");
        countries.add("Argentina");

        ArrayList<Integer> areaCode = new ArrayList<>();
        areaCode.add(111);
        areaCode.add(211);
        areaCode.add(311);
        areaCode.add(411);
        areaCode.add(511);
        areaCode.add(611);
        areaCode.add(811);

        ArrayList<String> counties = new ArrayList<>();
        counties.add("queens");
        counties.add("manhattan");
        counties.add("staten island");
        counties.add("brooklyn");
        counties.add("bronx");

        ArrayList<Integer> zipCode = new ArrayList<>();
        zipCode.add(11364);
        zipCode.add(11365);
        zipCode.add(11366);
        zipCode.add(11367);

        for (int i = 0; i <=2; i++) {
            System.out.println("county is " + counties.get(i));

        }

        for (int i =0; i <=2; i++) {
            System.out.println("zipcode is "+ zipCode.get(i));
        }


        //if you are using one loop for 2 or more array list, then they all should have the same amount of count
        //if not then it needs to be in the seperate loop statement

        //iterate/loop through the entire list of countries using for loop
        for (int i = 0; i <= 2; i++) {
            System.out.println("Country is " + countries.get(i));

        }//end of loop

    }//end of main
} // end of class
