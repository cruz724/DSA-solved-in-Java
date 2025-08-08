import java.util.*;

public class array {

    public static int linearsearch(int numbers[], int keys){
        for(int i=0; i<numbers.length; i++){
            if (numbers[i] == keys) {
                return i;
            }
        }
        return -1;
    }
    
    public static void largestnumber(int number[]){
        int largest = Integer.MIN_VALUE;

        for(int i=0; i<number.length; i++){
            if (largest < number[i]) {
                largest = number[i];
            }
        }

        System.out.println("largest number of array is: "+ largest);
    }
    
    public static void binarysearch(int binary_array[], int key){
        int start = 0;
        int end = binary_array.length - 1;

        while (start <= end) {
            int mid = (start + end)/2;
            
            if (mid == key) {
                System.out.println("binary search :: the key is at index : " + mid);
            }
            if (mid<key) {
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
    }
    
    public static void reverse_array(int reverse[]){
        int start=0;
        int end = reverse.length -1 ;

        while (start<end) {
            int temp = reverse[end];
            reverse[end] = reverse[start];
            reverse[start] = temp;

            start++;
            end--;
        }
    }

    public static void pairarray(int pair[]){

        for(int i= 0; i<pair.length;i++){
            for(int j=i+1; j<pair.length; j++){
                System.out.print("("+ pair[i] + "," + pair[j] + ")");
            }
            System.out.println();
        }

    }
    
    public static void printsub(int sub[]){

        for(int i=0; i<sub.length; i++){
            for(int j=i; j<sub.length; j++){
                for(int k = i ; k<=j; k++){
                    System.out.print( sub[k]+ " ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }
    
    public static void kadanes_alo(int Kadanes_arr[]){
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for(int i =0; i<Kadanes_arr.length; i++){
            cs = cs + Kadanes_arr[i];
            if (cs<0) {
                cs=0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println("max subarray sum is : "+ ms);
    }

    
    public static void main(String[] args) {

        // ---------------linear search-------------------------------------
        int numbers[] = {2,4,6,8,10,12,14,16};
        int keys = 4;

        int index = linearsearch(numbers, keys);

        if (index == -1) {
            System.out.println("not found");
        }else{
            System.out.println("linear serach ::  the keys is at index: " + index );
        }

        // ---------------largest number-------------------------------------

        int number[] = {1,2,4,6,3,5};
        largestnumber(number);

        // ---------------Binary search-------------------------------------

        int binary_array[] = {2,4,6,8,10,12,14};
        int key = 6;
        binarysearch(binary_array, key);
        

        // ---------------reverse array-------------------------------------

        int reverse[] = {1,2,3,4,5,6,7,8,9};
        reverse_array(reverse);

        for(int i=0;i<reverse.length; i++){
            System.out.print(reverse[i] +" ");
        }
        System.out.println();
        System.out.println();


        // ---------------Pair of array-------------------------------------

        int pair[] = {2,4,6,8,10};
        pairarray(pair);

        System.out.println();
        System.out.println();


        // ---------------printing subarray of array-------------------------------------
        int sub[] = {2,4,6,8,10};
        printsub(sub);

        // ---------------Max sum of subarray (Kadanes algorithm)-------------------------------------
        int Kadanes_arr[] = {-2,-3,4,-1,-2,1,5,-3};
        kadanes_alo(Kadanes_arr);
    }
}