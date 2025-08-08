import java.util.*;
public class recurssion1 {

    public static void printdec(int n){
        if(n>=0){
            System.out.println(n);
            printdec(n-1);
        }
    }

    public static void printinc(int n){
        if(n>=1){
            printinc(n-1);
            System.out.println(n);
        }
    }

    public static int printfactorial(int n){

        if( n == 0){
            return 1;
        }

        int num = n * printfactorial(n-1);
        return num;
    }

    public static int printsum(int n){

        if(n==1){
            return 1;
        }
        
        int sum = n + printsum(n-1);
        return sum;
    }

    public static int printfib(int n){

        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        
        int fib = printfib(n-1) + printfib(n-2);
        return fib;
    }

    public static boolean sorted(int arr[], int i){

        if (i == arr.length-1) {
            return true;
        }
        if(arr[i+1] < arr[i]) {
            return false;
        }

         return sorted(arr, i+1);       
    }

    public static int firstoccurance(int arr[], int key, int i){

        if (i == arr.length) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return firstoccurance(arr, key, i+1);
    }

    public static int lastoccurance(int arr[], int key, int i){

        if (i < 0) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return lastoccurance(arr, key, i-1);
    }

    public static int pow(int x, int n){

        if (n == 0) {
            return 1;
        }
        return x * pow(x, n-1);
    }

    public static int optimizedpow(int x, int n){
        if(n==0){
            return 1;
        }
        
        int halfpow = optimizedpow(x, n/2);

        int square = halfpow * halfpow;

        if (n%2 != 0) {
            square *= x ;
        }   

        return square;
    }


    public static void main(String[] args) {
        
        // Scanner sc = new Scanner(System.in);
        // System.out.println("enter the digit n: ");

        // int n = sc.nextInt();

        // printdec(n);

        // printinc(n);

        // int fact = printfactorial(n);
        // System.out.println(fact);

        // int sum = printsum(n);
        // System.out.println(sum);

        // int fib = printfib(n);
        // System.out.println(fib);

        // int arr[] = {1,2,3,4,9,6};
        // boolean sorted = sorted(arr,0);
        // System.out.println(sorted);

        // int arr[] = {3,4,6,9,5,6,8,3,4,7};
        // int key = 7;
        // int ans_index = firstoccurance(arr, key, 0);
        // System.out.println(ans_index);

        // int arr[] = {3,4,6,6,4,3};
        // int key = 4;
        // int i = arr.length-1;
        // int ans_index = lastoccurance(arr, key, i);
        // System.out.println(ans_index);


        // int ans = pow(5,3);
        int ans = optimizedpow(2,15);
        System.out.println(ans);
    }
}
