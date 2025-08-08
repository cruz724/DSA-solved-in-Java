import java.util.*;

public class container {

    public static int StoreWater(ArrayList<Integer> list){
        int max_water =0;

        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){

                int height = Math.min(list.get(i), list.get(j));
                int width = j-i;
                int store = height*width;

                if (store > max_water) {
                    max_water = store;
                }

            }
        }

        return max_water;
    }

    public static int optimized_code(ArrayList<Integer> list){

        int max = 0;
        int left = 0;
        int right = list.size()-1;

        while (left < right) {
            
            int b = right - left;
            int l = Math.min(list.get(left), list.get(right));

            int water = l*b;
            max = Math.max(water, max);

            if (list.get(right) > list.get(left)) {
                left ++;
            }else{
                right--;
            }

        }
        return max;
    }


    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);

        int ans = StoreWater(list);

        System.out.println(ans);

        int optimized_result = optimized_code(list);

        System.out.println(optimized_result);
    }
}
