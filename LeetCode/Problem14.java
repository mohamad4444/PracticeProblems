import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        int common = 0;

        boolean flag = true;
        if(strs.length==0){
            flag=false;
        }
        if(strs.length==1){
            return strs[0];
        }
        while (flag) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (common < strs[i].length() && common < strs[i+1].length()) {
                    if (strs[i].charAt(common) != strs[i + 1].charAt(common)) {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                }
            }
            if (flag == true) {
                common++;
            } else {
                break;
            }
        }
        return strs[0].substring(0, common);

    }

    public static void main(String[] args) {
        String[] strs = new String[] { "flower", "flow", "flight" };
        String[] strs2 = new String[] {"dog","racecar","car" };
        String[] strs3 = new String[] {""};
        System.out.println("\nHello world");
        System.out.println(longestCommonPrefix(strs3));
    }
}