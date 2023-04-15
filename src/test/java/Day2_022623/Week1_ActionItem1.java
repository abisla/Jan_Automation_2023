package Day2_022623;

import java.util.ArrayList;

public class Week1_ActionItem1 {
    public static void main (String[] args){
        //create ArrayList to store country names
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Nigeria");
        countries.add("Cambodia");
        countries.add("India");
        countries.add("China");

        //create an Integer ArrayList
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(0);
        countryCode.add(1);
        countryCode.add(2);
        countryCode.add(3);

        //iterate through a for loop
        for(int i = 0; i < countries.size(); i++) {
            System.out.println(" My Country is" + countries.get(i) + " and my country code is " + countryCode.get(i));
        }
        }
    }
