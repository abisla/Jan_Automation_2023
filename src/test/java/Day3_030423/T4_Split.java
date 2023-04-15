package Day3_030423;

public class T4_Split {
    public static void main (String[] args){

        //declare a single string variable
        String message = "My Name is John";
        //print out only john from above string
        String[] arrayMessage = message.split(" ");
        System.out.println("Result:" + arrayMessage[3]);


    }//end of main
}//end of class
