import java.util.*;

public class sortingAlgo {

    public static void printarr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void Bubblesort(int arr[]){
        for(int turn =0; turn < arr.length-1; turn++){
            for(int j=0; j<arr.length-1-turn; j++){
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void selectionsort(int arr[]){
        for(int i=0;i<arr.length; i++){
            int minpos = i;
            for(int j=i+1; j<arr.length; j++){
                if (arr[minpos] > arr[j])  {
                    minpos = j;
                }   
            }
            int temp = arr[minpos];
            arr[minpos]= arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionsort(int arr[]){
        for(int i = 1; i<arr.length; i++){
            int curr = arr[i];
            int prev = i-1;
            
            while (prev>=0 && arr[prev]>curr) {
                arr[prev+1]= arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
            
        }
    }

    public static void countingsort(int arrs[]){
        int largest = Integer.MIN_VALUE;

        for(int i=0; i<arrs.length; i++){
            largest = Math.max(largest, arrs[i]);
        }

        int count[] = new int [largest+1];

        for(int i=0; i<count.length; i++){
            count[arrs[i]]++;
        }

        int j=0;
        for(int i=0; i<count.length; i++){
            while (count[i]>0) {
                arrs[j] = i;
                j++;
                count[i]--;
            }
        }
    }
    
    public static void main(String[] args) {
        
        int arr[] = {5,4,1,3,2};

        // -------------------------------Bubble sort ------------------------------
        System.out.println("Bubble sort:");
        Bubblesort(arr);
        printarr(arr);
        System.out.println();
        System.out.println();

        //-------------------------------Selection sort ------------------------------
        System.out.println("Selection sort:");
        selectionsort(arr);
        printarr(arr);
        System.out.println();
        System.out.println();

        //-------------------------------Insertion sort ------------------------------
        System.out.println("Insertion sort:");
        insertionsort(arr);
        printarr(arr);
        System.out.println();
        System.out.println();

        //-------------------------------Inbuild sort ------------------------------
        System.out.println("Inbuild sort:");
        Arrays.sort(arr);
        printarr(arr);
        System.out.println();
        System.out.println();

        //-------------------------------Inbuild sort ------------------------------
        System.out.println("Inbuild sort:");
        Arrays.sort(arr);
        printarr(arr);
        System.out.println();
        System.out.println();

        //-------------------------------counting sort ------------------------------
        System.out.println("counting sort:");
        int arrs[] = {1,4,1,3,2,4,3,7};
        countingsort(arrs);
        printarr(arrs);
        System.out.println();
        System.out.println();



    }
}