
/*Largest Rectangle in Histogram

 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 */
import java.util.Stack;

public class Problem84 {
   public static int largestRectangleArea(int[] heights) {
      Stack<int[]> stack = new Stack<>();
      int maxArea = -1;
      stack.add(new int[] { 0, heights[0] });
      for (int i = 1; i < heights.length; i++) {
         if (stack.peek()[1] < heights[i]) {
            stack.add(new int[] { i, heights[i] });
         } else {
            int stackCurrentTop=i;
            while (stack.size()>0 && stack.peek()[1] > heights[i]) {
               int poppedHeight = (i - stack.peek()[0]) * stack.peek()[1];
               if (poppedHeight > maxArea) {
                  maxArea = poppedHeight;
               }
               stackCurrentTop=stack.peek()[0];
               stack.pop();
            }
            stack.add(new int[] { stackCurrentTop, heights[i] });
         }

      }
      System.out.println("Printing stack");
      int stackSize=heights.length;
      while (stack.size()>0) {
         int poppedHeight=(stackSize-stack.peek()[0])*stack.peek()[1];
         if (poppedHeight > maxArea) {
            maxArea = poppedHeight;
         }
         stack.pop();
      }

      return maxArea;
   }

   public static void main(String[] args) {
      System.out.println(largestRectangleArea(new int[] { 2, 1, 2 }));
   }
}