package coe528.com;

import java.util.ArrayList;

public class ProceduralAbstraction {

    //Requires: None
    //Modifies: None
    //Effects: Returns the smallest positive integer n for which n!
    //         (i.e. 1*2*3*...*n) is greater than or equal to x, for positive
    //         integer x. Otherwise returns 1.
    public static int reverseFactorial(int x) {
        int fact = 0;
        int count = 0;
        int num = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (fact < x) {
            
            count++;
            list.add(count);
            for (int element : list) {
                fact += element;
                //System.out.println(element);
            }
                
            //if (fact > x)
            //    return num;
            //num++;
        }
        return count;
    }

    //Requires: None
    //Modifies: None
    //Effects: If the matrix arr satisfies Nice property, prints the sum and
    //         returns true. Otherwise returns false.
    public static boolean isMatrixNice(int[][] arr) {
        //write the code here
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
