package coe528.com;

import java.util.ArrayList;

public class ProceduralAbstraction {
    private final static int MAX_SIZE = 10;

    //Requires: None
    //Modifies: None
    //Effects: Returns the smallest positive integer n for which n!
    //         (i.e. 1*2*3*...*n) is greater than or equal to x, for positive
    //         integer x. Otherwise returns 1.
    public static int reverseFactorial(int x) {
        int num = 1;
        int i = 0;

        for (i = 1; i <= MAX_SIZE; i++) {
            num *= i;
            //System.out.println("Fact: " + num);
            if (num >= x)
                break;
        }

        return i;
    }

    //Requires: None
    //Modifies: None
    //Effects: If the matrix arr satisfies Nice property, prints the sum and
    //         returns true. Otherwise returns false.
    public static boolean isMatrixNice(int[][] arr) {
        //write the code here, nice matrix is square, sum of ints row, columns, and diagonals all same
        //if (int i = 0; i < 
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(reverseFactorial(24));
        System.out.println(reverseFactorial(119));
        System.out.println(reverseFactorial(1));
        System.out.println(reverseFactorial(1722));
        System.out.println("hello");
    }
}
