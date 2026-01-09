import java.util.*;

public class basic {
  
  public static int multiply(int a , int b) {
    int product = a*b;
    return product;
  }

  public static int factorial(int a){
    int fact = 1;
    for(int i = 1; i<=a; i++){
      fact *= i;
    }
    return fact;
  }

  public static float binomial(int n, int r){
    int n_fact = factorial(n);
    int r_fact = factorial(r);
    int nr_fact = factorial((n-r));

    float c = (n_fact / (r_fact * nr_fact));
    return c;
  }

  public static boolean isprime(int n) {
    boolean p = true;

    for(int i =2; i<Math.sqrt(n); i++){

      if (n%i == 0) {
        p = false;
      }
    }
    return p;
  }

  public static void prime_numbers(int n){
    for(int i =2; i<=n; i++){
      if (isprime(i)) {
        System.out.println(i);
      }
    }
  }

  public static void bintodec(int a){
    int mynum = a;
    int pow =0;
    int dec = 0;

    for(; a>0 ; pow++){
      int last_digit = a%10;
      dec = dec +(last_digit * (int)Math.pow(2, pow)) ;
      a = a/10;

    }
    System.out.println("decimal of "+ mynum +"= "+ dec);
  }

  public static void dectobin(int a){
    int mynum = a;
    int pow = 0;
    int bin = 0;

    for( ; a>0  ; pow++ ){

      int last_digit = a%2;
      bin = bin +(last_digit* (int)Math.pow(10, pow));
      a =a/2;
    }
    System.out.println("binary of "+ mynum + "= "+ bin);
  }
  
  public static void avg(int a, int b, int c){
    int avg = (a+b+c)/3;
    System.out.println("avg of given 3 num is : " + avg);
  }
  
  public static boolean iseven(int a){

    boolean result = false;
    if (a%2 == 0) {
      result =true;
    }else{
      result = false;
    }

    return result;
  }

  public static boolean ispalindrone(int a){

    int mynum = a;
    int new_num = 0;
    boolean result = false;
    for(int i = 0; a>0; i++){
      int last_digit = a%10;
      new_num = (new_num * 10 )+ last_digit;
      a = a/10;
    }

    if (new_num == mynum) {
      result = true;
    }else{
      result = false;
    }

    return result;
  }
  public static void main(String[] args) {

  

  }
}