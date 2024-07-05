public class Problem04 {
    public static Double kthSmallest(int pos,int[] nums1, int[] nums2) {
        if (pos>nums1.length+nums2.length-1){
            return null;
        }
        if (nums1.length==0){
            return (double) nums2[pos];
        }else if(nums2.length==0){
            return (double) nums1[pos];
        }
        int mid1[]=new int[3];
        int mid2[]=new int[3];
        mid1[1]=nums1.length-1;
        mid2[1]=nums2.length-1;

        boolean posFound=false;
        while(!posFound){
            mid1[2]=(mid1[0]+mid1[1])/2;
            mid2[2]=(mid2[0]+mid2[1])/2;
            if(mid1[1]<mid1[0]){
                return (double) nums2[mid2[2]];
            }
            if(mid2[1]<mid2[0]){
                return (double) nums1[mid1[2]];
            }
            // [1,3,5,6,7] [2,4,9,10,11,12,14];
            if(nums1[mid1[2]]<nums2[mid2[2]]){//2-5,6-8.
                //combined positions
                int minRight=mid1[2]+1+mid2[2]; 
                int maxRight=mid1[1]+1+mid2[2];
                int minLeft=mid1[2];
                int maxLeft = mid1[2]+mid2[2];
                if(pos<minLeft){
                    mid1[1]=mid1[2]-1;
                }
                else if(pos>maxRight){
                    mid2[0]=mid2[2]+1;
                }else if(pos<minRight){ 
                    mid2[1]=mid2[2]-1; //remove right from nums2
                }else if(pos>maxLeft){
                    mid1[0]=mid1[2]+1;// remove left from nums1
                }else if(minRight==maxRight && minRight==pos){
                    return (double) nums2[mid2[2]];
                }
            }else{
                int minLeft=mid1[2]+1+mid2[2]; 
                int maxLeft=mid2[1]+1+mid1[2];
                int minRight=mid2[2];
                int maxRight = mid2[2]+mid1[2];
                if(pos<minRight){
                    mid2[1]=mid2[2]-1;
                }else if(pos<minLeft){ 
                    mid1[1]=mid1[2]-1; //remove right from nums2
                }else if(pos>maxLeft){
                    mid1[0]=mid1[2]+1;// remove left from nums1
                }else if(pos>maxRight){
                    mid2[0]=mid2[2]+1;
                }else if(minLeft==maxLeft && maxLeft==pos){
                    return (double) nums1[mid1[2]];
                }
            }
        }
        return null;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int combinedLength=nums1.length+nums2.length;

        if(combinedLength%2==0){
            System.out.println(combinedLength/2-1);
            System.out.println(combinedLength/2);
            double firstElement=kthSmallest(combinedLength/2-1,nums1,nums2);
            double secondElement=kthSmallest(combinedLength/2,nums1,nums2);
            return (firstElement+secondElement)/2;
        }else{
            return kthSmallest(combinedLength/2,nums1,nums2);
        }

    }

    public static void main(String[] args) {
        int[] nums1=new int[]{1,3,5,7,9,12};
        int[] nums2=new int[]{-10,-5,2,4,6,8,10,15,17,18,29};

        // System.out.println();
        System.out.println();
        // System.out.println(kthSmallest(5,nums1,nums2));
        // System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
        // System.out.println(kthSmallest(1,new int[]{1,2},new int[]{3,4}));
        //System.out.println(kthSmallest(3,new int[]{1,2},new int[]{3,4}));
        // System.out.println(findMedianSortedArrays(new int[]{1},new int[]{2,3,4,5,6}));
        // System.out.println(findMedianSortedArrays(new int[]{2,3,4,5,6},new int[]{1}));
        // System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,7}));
        // System.out.println(kthSmallest(0,new int[]{2,3,4,5,6},new int[]{1}));
        // System.out.println(kthSmallest(1,new int[]{2,3,4,5,6},new int[]{1}));
        // System.out.println(kthSmallest(2,new int[]{2,3,4,5,6},new int[]{1}));
        // System.out.println(kthSmallest(3,new int[]{2,3,4,5,6},new int[]{1}));
        // System.out.println(kthSmallest(4,new int[]{2,3,4,5,6},new int[]{1}));
        // System.out.println(kthSmallest(5,new int[]{2,3,4,5,6},new int[]{1}));

        //1,2,3,4,5,6,7,8
        System.out.println(kthSmallest(4,new int[]{1,7},new int[]{2,3,4,5,6,8}));

        // System.out.println(kthSmallest(0,new int[]{1},new int[]{2,3,4,5,6}));
        // System.out.println(kthSmallest(1,new int[]{1},new int[]{2,3,4,5,6}));
        // System.out.println(kthSmallest(2,new int[]{1},new int[]{2,3,4,5,6}));
        // System.out.println(kthSmallest(3,new int[]{1},new int[]{2,3,4,5,6}));
        // System.out.println(kthSmallest(4,new int[]{1},new int[]{2,3,4,5,6}));
        // System.out.println(kthSmallest(5,new int[]{1},new int[]{2,3,4,5,6}));
        // System.out.println(kthSmallest(1,new int[]{1,3},new int[]{2,7}));
        //System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2,7}));


    }
}
