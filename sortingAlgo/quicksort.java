package sortingAlgo;
public class quicksort {

    public static void quicksorts(int arr[], int si, int ei){

        if (si>=ei) {
            return;
        }

        int pidx = partation(arr, si, ei);

        quicksorts(arr, si, pidx-1);
        quicksorts(arr, pidx+1, ei);
    }

    public static int partation(int arr[], int si, int ei){

        int pivot = arr[ei];
        int i = si-1;
        
        for(int j=si; j<ei;j++){
            if (arr[j] <= pivot) {
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }
            i++;
            int temp = pivot;
            arr[ei] = arr[i];
            arr[i] = temp;
            return i;
    }

    public static void printarr(int arr[]){
        for(int i=0; i<=arr.length-1; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {6,7,5,3,9,2,1};

        quicksorts(arr,0,arr.length-1);
        printarr(arr);
    }
}
