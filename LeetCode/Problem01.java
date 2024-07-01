import java.util.HashMap;
class Problem01 {
    //Brute Force
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 1; j < nums.length; j++) {
                if (i != j) {
                    sum = nums[i] + nums[j];
                    if (sum == target) {
                        return new int[] { i, j };
                    }
                }
            }
        }
        return new int[] { 0, 0 };
    }
    //Hash Method
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }

        return new int[]{}; // No solution found
    }
}