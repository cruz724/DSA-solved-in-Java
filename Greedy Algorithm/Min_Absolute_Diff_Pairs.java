import java.util.Arrays;

public class Min_Absolute_Diff_Pairs {
    public static void main(String[] args) {
        
        int[] A ={1,2,3};
        int[] B ={2,1,4};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff=0;

        for (int i = 0; i < B.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }

        System.out.println("Min absolute diff of pairs = " + minDiff);
    }
}
