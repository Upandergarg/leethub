class Solution {
    public int[] buildArray(int[] nums) {
        int n=nums.length;
       
        for(int i=0;i<n;i++){
            int newval= nums[nums[i]]%n;
            nums[i] += n*newval;
        }
        for(int i=0; i<n; i++){
            nums[i]/=n;;
        }
        return nums;
    }
}