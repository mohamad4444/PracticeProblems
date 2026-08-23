class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int start=0;
        int end=nums.length; 
        int mid=(end+start)/2;

        while(nums[mid]!=target &&start!=mid && end!=mid){
            if(nums[mid]>target){
               end=mid;
               mid=(end+start)/2;
            }else if(nums[mid]<target){
                start=mid;
                mid=(end+start)/2;
            }else{
                return mid;
            }
        }
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid]>target){
            return mid;
        }else{
            return mid+1;
        }
    }
}