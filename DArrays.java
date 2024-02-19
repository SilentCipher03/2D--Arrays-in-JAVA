import java.util.*;

public class DArrays {

    //Search for key in 
    public static boolean Search(int matrix[][], int key){
        for(int i =0; i<matrix.length; i++){
            for(int j =0; j<matrix[i].length; j++){
                if (matrix[i][j] == key){
                    System.out.println("We found key at cell " + i + "," +j);
                    return true;
                }
            }
        }
        System.out.println("Key not found");
        return false;
    }

    //Search for largest element in the 2D Array
    public static int LargestElement(int matrix[][]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j =0; j<matrix[i].length; j++){
                if(largest < matrix[i][j]){
                    largest = matrix[i][j];
                }
            }
        }
        return largest;
    }
    //Search for smallest element in matrix
    public static int SmallestElement(int matrix[][]){
        int smallest = Integer.MAX_VALUE;
        for(int i =0; i<matrix.length; i++){
            for(int j =0; j<matrix[i].length; j++){
                if(smallest > matrix[i][j]){
                    smallest = matrix[i][j];
                }
            }
        }
        return smallest;
    }

    //Print Spiral Matrix 
    public static void SpiralMatrix(int matrix[][]){
        int startrow =0;
        int startcol =0;
        int endrow = matrix.length-1;
        int endcol = matrix[0].length-1;

        while(startrow <= endrow && startcol <= endcol){

            //top
            for(int i= startcol; i<=endcol; i++){
                System.out.print(matrix[startrow][i]+ " ");
            }
            //Right
            for(int j= startrow+1; j<=endrow ; j++){
                System.out.print(matrix[j][endcol]+ " ");
            }
            //Bottom
            for(int i = endcol-1; i>=startcol; i--){
                if(startrow== endrow){
                    break;
                }
                System.out.print(matrix[endrow][i]+ " ");
            }
            //Left
            for(int j=endrow-1; j>=startrow+1; j--){
                if(startcol==endcol){
                    break;
                }
                System.out.print(matrix[j][startcol]+ " ");
            }
            startrow++;
            startcol++;
            endrow--;
            endcol--;
        }
        System.out.println();
    }

    //Sum of Diagonals in 2DArrays TC =O(n^2)
    public static int diagonalSum(int matrix[][]){
        //Brute Force Approach
        int sum =0;
        for(int i =0; i<matrix.length; i++){
            for(int j =0; j< matrix[0].length; j++){
                //Primary Diagonal Sum
                if(i==j){
                    sum += matrix[i][i];
                }else if( (i+j) == matrix.length-1){
                    sum +=matrix[i][j];
                }
            }
        }
        return sum;
    }

    //Optimized approach for Diagonal Sum TC = O(n)
    public static int optidiagSum(int matrix[][]){
        int sum =0;
        for(int i =0; i<matrix.length; i++){
            sum+= matrix[i][i];
            if( i!= matrix.length-i-1){
                sum += matrix[i][matrix.length-1-i]; 
            }
        }
        return sum;
    }

    //Staircase search 
    public static boolean staircaseSearch(int matrix[][], int key){
        int row = matrix.length-1;
        int col =0;
        
        while(row >=0 && col<= matrix.length){
            if(matrix[row][col] == key){
                System.out.println("found key at ("+ row + "," +col + ")");
                return true;
            } else if(key < matrix[row][col]){
                row--;
            } else{
                col++;
            }
        }
        System.out.println("Key not found");
        return false;
    }

       
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        /*//Basic Representation of 2D- Arrays
        System.out.println("Enter the numbers");

        //Input 2D array
        int matrix [][] = new int [3][3];
        int n= matrix.length; 
        int m= matrix[0].length;

        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        //Output 2D Array
        for(int i=0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        Search(matrix, 5);
        System.out.println(LargestElement(matrix));
        System.out.println(SmallestElement(matrix));*/

        //Spiral Matrix
        int matrix[][] = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        SpiralMatrix(matrix);
        System.out.println(diagonalSum(matrix));
        System.out.println(optidiagSum(matrix));
        System.out.println(staircaseSearch(matrix, 12));
    }
}
