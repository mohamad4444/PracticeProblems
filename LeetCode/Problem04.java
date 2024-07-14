public class Problem04 {
    public static int kthSmallest(int k,int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return kthSmallest(k,nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {
            int i = (low + high) / 2;
            int j = k - i;

            int nums1Left = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int nums1Right = (i < n) ? nums1[i] : Integer.MAX_VALUE;
            int nums2Left = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int nums2Right = (j < m) ? nums2[j] : Integer.MAX_VALUE;

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                return Math.max(nums1Left, nums2Left);
            } else if (nums1Left > nums2Right) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or k is out of range.");
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int combinedLength = nums1.length + nums2.length;

        if (combinedLength % 2 == 0) {
            System.out.println(combinedLength / 2 - 1);
            System.out.println(combinedLength / 2);
            double firstElement = kthSmallest(combinedLength / 2 - 1, nums1, nums2);
            double secondElement = kthSmallest(combinedLength / 2, nums1, nums2);
            return (firstElement + secondElement) / 2;
        } else {
            return kthSmallest(combinedLength / 2, nums1, nums2);
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 3, 5, 7, 9, 12 };
        int[] nums2 = new int[] { -10, -5, 2, 4, 6, 8, 10, 15, 17, 18, 29 };

        // System.out.println();
        System.out.println();
        // System.out.println(kthSmallest(5,nums1,nums2));
        // System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
        // System.out.println(kthSmallest(1,new int[]{1,2},new int[]{3,4}));
        // System.out.println(kthSmallest(3,new int[]{1,2},new int[]{3,4}));
        // System.out.println(findMedianSortedArrays(new int[]{1},new
        // int[]{2,3,4,5,6}));
        // System.out.println(findMedianSortedArrays(new int[]{2,3,4,5,6},new
        // int[]{1}));
        // System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,7}));
        System.out.println(kthSmallest(0,new int[]{2,3,4,5,6},new int[]{1}));
        System.out.println(kthSmallest(1,new int[]{2,3,4,5,6},new int[]{1}));
        System.out.println(kthSmallest(2,new int[]{2,3,4,5,6},new int[]{1}));
        System.out.println(kthSmallest(3,new int[]{2,3,4,5,6},new int[]{1}));
        System.out.println(kthSmallest(4,new int[]{2,3,4,5,6},new int[]{1}));
        System.out.println(kthSmallest(6,new int[]{2,3,4,5,6},new int[]{1}));

        // 1,2,3,4,5,6,7,8
        System.out.println(kthSmallest(4, new int[] { 1, 7 }, new int[] { 2, 3, 4, 5, 6, 8 }));

        // System.out.println(kthSmallest(0,new int[]{1},new int[]{2,3,4,5,6}));
        // System.out.println(kthSmallest(1,new int[]{1},new int[]{2,3,4,5,6}));
        // System.out.println(kthSmallest(2,new int[]{1},new int[]{2,3,4,5,6}));
        // System.out.println(kthSmallest(3,new int[]{1},new int[]{2,3,4,5,6}));
        // System.out.println(kthSmallest(4,new int[]{1},new int[]{2,3,4,5,6}));
        // System.out.println(kthSmallest(5,new int[]{1},new int[]{2,3,4,5,6}));
        // System.out.println(kthSmallest(1,new int[]{1,3},new int[]{2,7}));
        // System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2,7}));

    }
}
