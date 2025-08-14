import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Indian_Coin {
    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};

        Arrays.sort(coins, Comparator.reverseOrder());

        int countOfCoin =0;
        int amount = 590;

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            if (amount >= coins[i]) {
                while (amount >= coins[i]) {
                    countOfCoin++;
                    amount -= coins[i];
                    ans.add(coins[i]);
                }
            }
        }

        System.out.println("number of coins used: " + countOfCoin);
        System.out.print("coins used are : ");

        for (int j = 0; j < ans.size(); j++) {
            System.out.print(" "+ ans.get(j));
        }
    }
}
