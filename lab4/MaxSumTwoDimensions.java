import java.util.Random;
import java.util.*;

/**
 * Various algorithms for the maximum sub matrix sum problem.
 * 
 * @authors 
 * @version 2012-04-
 */
public class MaxSumTwoDimensions {

    private static Random random = new Random();
    
    // A couple of two dimensional algorithms for rectangular matrixes.
    
    // O(n^6)
    public static int maxSubMatrixSumBad( int[][] a ) {
        int i,j,m,n,maxSubSum = 0,tempSum = 0;
        for(m = 0; m < a.length; m++)
        {
        	
        	for(i=0;i<a.length;i++)
    		{
        		System.out.println(tempSum);
        		tempSum=0;
	        	for(n = m; n<a.length;n++)
	        	{
	        		
        			for(j=i;j<a.length;j++)
        			{
        				tempSum = tempSum + a[n][j];
        			}
        			if(tempSum > maxSubSum)
    				{
    					maxSubSum = tempSum;
    				}
        			
        		}
        		
        	}
        	
        	
        	
        }
        
        return maxSubSum;
    }
 
    // O(n^5)
    public static int maxSubMatrixSumBetter( int[][] a ) {
        // ...
        return 0;
    }
    
    // O(n^4)
    public static int maxSubMatrixSumEvenBetter( int[][] a ) {
        // ...
        return 0;
    }
    
    private static int[][] randMatrix(int m,int n) {
        int[][] a = new int[m][n];
        for( int i = 0; i < m; i++ )
            for( int j = 0; j < n; j++ )
                a[i][j] = random.nextInt(100) - 50;
        return a;
    }
    
    private static void test(int[][] m) {
// Uncomment as you proceed!
//         System.out.println("EvenBetter: "+maxSubMatrixSumEvenBetter(m));
//         System.out.println("Better: "+maxSubMatrixSumBetter(m));
        System.out.println("Bad: "+maxSubMatrixSumBad(m));
    }
    
    public static void main(String[] arg) {
        // Three test cases with known answers
        
        // This is the matrix in the lab PM.
        int[][] sampleMatrix = {     // max sum is 21
            {-1,-2,1,3},
            {0,2,0,8},
            {-5,10,-2,1},
            {4,5,-7,1}
        };
         test(sampleMatrix);
            
        int[][] matrix_10x10 = {    // max sum is 213
            {39,-33,-5,-21,-31,-33,31,32,37,-37},
            {28,-20,-9,-25,38,-15,18,-45,-34,-42},
            {31,34,-42,-33,-12,8,29,21,-10,-6},
            {-6,31,14,-2,46,7,18,15,-37,42},
            {45,34,22,34,-28,-42,-38,27,-43,43},
            {-13,-6,-38,-47,30,-49,-2,-11,-48,-39},
            {24,-12,-28,-22,17,16,43,5,41,45},
            {-25,-24,-34,24,24,-23,21,9,0,9},
            {17,-50,33,-21,-30,-44,-28,-12,-37,-6},
            {-35,35,-27,44,-42,24,36,43,-49,-46}
        };
//         test(matrix_10x10);
        
        int[][] matrix_20x20 = {    // max sum is 346
        	{39,19,39,21,-19,-40,-20,9,-29,42,-48,46,-7,31,-50,-41,5,11,30,23},
        	{47,-40,30,46,-18,-29,22,-6,-44,42,-30,-46,-40,22,26,-49,27,-10,-35,44},
        	{28,-41,-5,-7,-7,-9,-42,38,-44,45,13,17,18,-30,-44,-23,-17,22,-17,-26},
        	{-9,2,13,30,-18,-13,28,30,-45,-11,0,22,-41,-7,6,-9,16,-47,33,23},
        	{45,-35,11,-1,-26,-33,21,-15,-24,-32,-35,-50,-4,14,24,-50,39,43,49,-33},
        	{-9,9,-47,-43,19,-36,-43,11,-32,-48,-11,15,-44,27,27,20,-38,-14,33,-31},
        	{-32,17,-44,11,27,2,-49,7,-38,0,48,30,18,45,-46,-38,-20,0,15,10},
        	{-12,30,-8,-25,-46,39,-45,13,-36,-11,-23,21,-44,2,-42,20,-16,-6,-34,2},
        	{28,-31,34,-50,39,34,8,-46,11,10,20,3,23,-35,-43,45,-38,-22,12,41},
        	{-14,14,-21,9,-21,26,17,2,-1,-22,38,-39,19,46,-41,43,0,-35,-28,43},
        	{-1,33,-42,18,-18,38,32,-25,-3,31,37,-19,22,-10,13,-19,-22,1,6,-8},
        	{-28,13,-35,-50,3,-40,-50,-5,15,11,-7,30,41,-47,-13,9,-19,12,-47,-13},
        	{-30,-18,-1,-35,2,-39,-34,-3,19,-25,-40,-25,34,-44,-27,-29,-18,-6,16,27},
        	{9,-17,-45,24,40,39,-12,25,1,-35,24,31,-14,-5,-38,4,-5,7,46,0},
        	{45,21,-12,7,-1,15,-43,18,-13,12,20,-22,-14,4,14,-45,-16,10,-48,-27},
        	{12,3,-46,49,-28,-33,17,42,-27,-21,13,36,-15,38,38,-41,-15,-10,45,-42},
        	{7,-34,40,41,38,-15,-34,41,-42,14,-16,22,-26,47,29,23,44,17,26,20},
        	{8,-6,-17,36,29,-34,-47,-9,30,-4,-31,-46,-16,1,38,-49,41,-49,-37,12},
        	{-11,-9,-48,43,13,-47,-1,-32,-45,-10,-22,-26,36,20,-27,44,29,6,18,-28},
        	{28,46,46,-4,-6,-16,-38,-46,-49,-46,-38,-38,2,46,3,49,-12,-11,-9,31}
        };
//         test(matrix_20x20);
        
        // Test the algorithms for random matrixes of increasing sizes.
      /*  for ( int size = 1; size <= 2048; size *= 2 ) {
            int[][] m = randMatrix(size,size);
            System.out.println("\nSize = " + size);
            test(m);
        }*/
    }
}
