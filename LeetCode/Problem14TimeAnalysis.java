import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        long startTotal = System.nanoTime();

        long startInit = System.nanoTime();
        int common = 0;
        boolean flag = true;
        if (strs.length == 0) {
            flag = false;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder result = new StringBuilder();
        long endInit = System.nanoTime();

        long loopTime = 0;
        long comparisonTime = 0;
        long appendTime = 0;

        while (flag) {
            long startLoop = System.nanoTime();
            for (int i = 0; i < strs.length - 1; i++) {
                long startComp = System.nanoTime();
                if (common < strs[i].length() && common < strs[i + 1].length()) {
                    if (strs[i].charAt(common) != strs[i + 1].charAt(common)) {
                        printTimings(endInit - startInit, loopTime, comparisonTime, appendTime, startTotal);
                        return result.toString();
                    }
                } else {
                    printTimings(endInit - startInit, loopTime, comparisonTime, appendTime, startTotal);
                    return result.toString();
                }
                comparisonTime += System.nanoTime() - startComp;
            }
            long startAppend = System.nanoTime();
            result.append(strs[0].charAt(common));
            appendTime += System.nanoTime() - startAppend;

            common++;
            loopTime += System.nanoTime() - startLoop;
        }

        long endTotal = System.nanoTime();

        printTimings(endInit - startInit, loopTime, comparisonTime, appendTime, startTotal);

        return result.toString();
    }

    private static void printTimings(long initTime, long loopTime, long compTime, long appendTime, long startTotal) {
        long endTotal = System.nanoTime();
        System.out.println("Initialization time (ms): " + initTime / 1_000_000.0);
        System.out.println("Loop total time (ms): " + loopTime / 1_000_000.0);
        System.out.println("Character comparison time (ms): " + compTime / 1_000_000.0);
        System.out.println("StringBuilder append time (ms): " + appendTime / 1_000_000.0);
        System.out.println("Total execution time (ms): " + (endTotal - startTotal) / 1_000_000.0);
    }
    public static void main(String[] args) {
        String[] strs1 = new String[] { "flower", "flow", "flight" };
        String[] strs2 = new String[] {"dog","racecar","car" };
        String[] strs3 = new String[] {""};
        System.out.println("\nHello world");
        System.out.println(longestCommonPrefix(strs1));
    }
}