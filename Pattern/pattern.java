
public class pattern {

    public static void Hollow_Pyramid(int tot_rows, int tot_col){

        for(int i =1; i<=tot_rows; i++){
            for(int j=1; j<=tot_col; j++){
                if (i==1 || i==tot_rows||j==1||j==tot_col) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void Inverted_half_pyramid(int a){
        for(int i=1; i<=a; i++){
            for(int j=1; j<=a-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void Inverted_Number_pyramid(int a){
        for(int i =1; i<=a; i++){

            for(int j=1; j<=(a-i+1); j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    
    public static void Floyd_triangle(int n){

        int digit =1;
        for(int i = 1; i<=n; i++){
            for(int j= 1; j<=i; j++){
                System.out.print(digit+ " ");
                digit++;
            }
            System.out.println();
        }
    }

    public static void zero_one_triangle(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                if ((i+j)%2==0) {
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void butterfly(int n){

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }

            for(int j = 1; j<= (2*(n-i)); j++){
                System.out.print(" ");
            }

            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }

            for(int j = 1; j<= (2*(n-i)); j++){
                System.out.print(" ");
            }

            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
    
    public static void Solid_rombus(int n){
        for(int i =1; i<=n; i++){
            for(int j= 1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j= 1; j<=n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void Hollow_rombus(int n){
        for(int i=1; i<=n; i++){

            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            for(int j=1; j<=n; j++){
                if (i==1|| i == n || j==1 || j==n) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int n){
        for(int i =1; i<=n; i++){

            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            for(int j=1; j<=(2*i-1); j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i =n; i>=1; i--){

            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            for(int j=1; j<=(2*i-1); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        Hollow_Pyramid(4, 5);

        System.out.println();
        System.out.println();

        Inverted_half_pyramid(4);

        System.out.println();
        System.out.println();

        Inverted_Number_pyramid(5);

        System.out.println();
        System.out.println();

        Floyd_triangle(6);

        System.out.println();
        System.out.println();

        zero_one_triangle(5);

        System.out.println();
        System.out.println();

        butterfly(5);

        System.out.println();
        System.out.println();

        Solid_rombus(5);

        System.out.println();
        System.out.println();

        Hollow_rombus(5);

        System.out.println();
        System.out.println();

        diamond(5);
  

    }
}
