import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static String longestCommonPrefix(String[] strs) {

        int common = 0;
        boolean flag = true;
        if (strs.length == 0) {
            flag = false;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder result = new StringBuilder();
        while (flag) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (common < strs[i].length() && common < strs[i + 1].length()) {
                    if (strs[i].charAt(common) != strs[i + 1].charAt(common)) {
                        return result.toString();
                    }
                } else {
                    return result.toString();
                }
            }
            result.append(strs[0].charAt(common));
            common++;
        }
        return result.toString();
    }

  
    public static void main(String[] args) {
        String[] strs1 = new String[] { "flower", "flow", "flight" };
        String[] strs2 = new String[] {"dog","racecar","car" };
        String[] strs3 = new String[] {""};
        System.out.println("\nHello world");
        System.out.println(longestCommonPrefix(strs1));
    }
}