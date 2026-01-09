package recurrssion;
public class removeduplicate {

    public static void duplicate(String str, StringBuilder newstr, int idx, boolean map[]){

        //base case
        if(idx == str.length()){
            System.out.println(newstr);
            return;
        }

        //kaam
        char curr = str.charAt(idx);
        if (map[curr - 'a'] == false) {
            map[curr - 'a'] = true;
            newstr.append(curr);
        }

        duplicate(str, newstr, idx+1, map);
    }
    public static void main(String[] args) {
        
        String str = "appnacollege";
        boolean map[] = new boolean[26];
        StringBuilder newstr = new StringBuilder();
        duplicate(str, newstr, 0, map);
    }
}

