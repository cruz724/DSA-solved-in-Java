public class Assg14 {

    public static void countof7(int matrix[][], int key){
        int count = 0;

        for(int i =0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] == key) {
                    count++;
                }
            }

        }
        System.out.println("no. of keys are: " + count);
    }

    public static void sumof2ndrow(int nums[][]){
        int row = 1;
        int sum =0;
        for(int j=0; j<nums[0].length; j++){
            sum += nums[row][j];
        }
        System.out.println("sum of 2nd row is : " + sum);
    }

    public static void transpose(int matrix[][]){

        int rows = matrix.length;
        int col = matrix[0].length;

        int transpose[][] = new int[col][rows];
        for(int i=0; i<rows; i++){
            for(int j=0; j<col; j++){
                transpose[j][i] = matrix[i][j];
            }
        }

        for(int i=0; i<col; i++){
            for(int j =0; j<rows; j++){
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static void printarr(int arr[][]){
        int rows = arr.length;
        int col = arr[0].length;
        for(int i=0; i<rows; i++){
            for(int j =0; j<col; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        int matrix[][] = {{4,6,7}, {8,8,7}};
        int key = 7;

        countof7(matrix, key);

        int nums[][] = {{1,4,9},{11,4,3},{2,2,3}};
        sumof2ndrow(nums);


        System.out.println("the original matrix : ");
        printarr(matrix);
        System.out.println();
        System.out.println("the transpose matrix is :");
        transpose(matrix);
        
    }
}
