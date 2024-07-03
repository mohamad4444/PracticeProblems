public class Problem04 {
    public double kthSmallest(int pos,int[] nums1, int[] nums2) {
        int mid1[]=new int[3];
        int mid2[]=new int[3];
        mid1[1]=nums1.length;
        mid2[1]=nums2.length;
        boolean posFound=false;
        while(!posFound){
            mid1[2]=(mid1[0]+mid1[1])/2;
            mid2[2]=(mid2[0]+mid2[1])/2;
            // [1,3,5,6,7] [2,4,9,10,11,12,14];
            if(nums1[mid1[2]]<nums2[mid2[2]]){//2-5,6-8. 
                int minRight=mid1[2]+1+mid2[2]; 
                int maxRight=nums1.length+mid2[2];
                int minLeft=mid1[2];
                int maxLeft = mid1[2]+mid2[2];
                if(pos>maxLeft){ 
                    mid2[1]=mid2[2]; //remove right from nums2
                    mid1[1]=mid1[2]; //remove right from nums1
                }else  if(pos<mid2[2] && pos<mid1[2]){
                    mid1[0]=mid1[2]; //remove left from nums1
                    mid2[0]=mid2[2];// remove left from nums2
                }else  if(pos<mid2[2] && pos<mid1[2]){

                }else  if(pos<mid2[2] && pos<mid1[2]){

                }
            }else{

            }
        }
        return 0.0;

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0.0;

    }
}
