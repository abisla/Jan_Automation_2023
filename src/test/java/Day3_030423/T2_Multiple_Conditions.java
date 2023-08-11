package Day3_030423;

public class T2_Multiple_Conditions {
    public static void main(String[] args) {

        //using multiple conditional statements verify when a+b >c, a+b < c, a+b ==c
        int a = 2;
        int b = 3;
        int c = 5;

        if(a+b > c){
            System.out.println("a & b is greater than c");
        } else if (a+b <c) {
            System.out.println("a & b is less than c");
        } else if (a+b == c) {
            System.out.println("a & b is equal to c");
        }//end of multiple conditions

        int d = 7;
        int e = 8;
        int f = 9;

        if(d+e > f) {
            System.out.println("d & e is greater than f");
        } else if (d + e < f) {
            System.out.println("d & e is less than f");
        } else if (d + e == f) {
            System.out.println("d and e is equal to f");
        }




    }//end of main
}//end of class

