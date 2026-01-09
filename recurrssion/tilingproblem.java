package recurrssion;
public class tilingproblem {

    public static int tile(int n){
        if (n==0 || n==1) {
            return 1;
        }

        //vertical choice
        int fnm1 = tile(n-1);

        //horizontal choice
        int fnm2 = tile(n-2);

        return fnm1+fnm2;
    }
    public static void main(String[] args) {
        
        int ans = tile(4);
        System.out.println(ans);
    }
}
