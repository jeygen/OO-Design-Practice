package coe528.com;

public class ProceduralAbstraction {

    //Requires: None
    //Modifies: None
    //Effects: Returns the smallest positive integer n for which n!
    //         (i.e. 1*2*3*...*n) is greater than or equal to x, for positive
    //         integer x. Otherwise returns 1.
    public static int reverseFactorial(int x) {
        int fact = 1;
        while (fact < x) {
            //while (fact >= 1) {
                fact *= (fact + 1);
                fact++;
            //}
        }
        return fact;
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
        System.out.println(reverseFactorial(4));
        System.out.println("hello");
    }
}
