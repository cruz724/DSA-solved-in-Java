import java.util.*;

public class BuySellStock {

    public static int Buysell(int prices[]){
        int buyprice = Integer.MAX_VALUE;
        int maxprofit =0;

        for (int i =0; i<prices.length; i++){
            if (buyprice < prices[i]) {
                int profit = prices[i] - buyprice;
                maxprofit = Math.max(maxprofit, profit);
            }else{
                buyprice = prices[i];
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int prices[] = {7,1,5,3,4};
        int max = Buysell(prices);
        System.out.println("max profit in stock is : " + max);
    }
}
