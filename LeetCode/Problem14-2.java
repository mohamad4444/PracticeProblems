import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder prefix = new StringBuilder(strs[0]);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs.length - 1; i++) {
            while (!strs[i].startsWith(prefix.toString())) {
                prefix.setLength(prefix.length()-1);
                if (prefix.isEmpty()) return "";
            }
        }
        
        return result.toString();
    }

  
    public static void main(String[] args) {
        String[] strs1 = new String[] { "flower", "flow", "flight" };
        String[] strs2 = new String[] {"dog","racecar","car" };
        String[] strs3 = new String[] {""};
        System.out.println("\nHello world");
        System.out.println(longestCommonPrefix(strs2));
    }
}