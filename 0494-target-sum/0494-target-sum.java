class Solution {
    int help(int i,int[] nums, int target){
     
               
        if(i==0){
      if(nums[i]==target && target==0) return 2;
        if(nums[i]==target || target==0) return 1;
        return 0;
        }
        int npick= help(i-1,nums,target);
        int pick=0;
        if(nums[i]<=target) pick= help(i-1,nums,target-nums[i]);
        return pick+npick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int i: nums) sum+=i;

        if (Math.abs(target) > sum) return 0;
        if ((sum + target) % 2 != 0) return 0;
        target=(target+sum)/2;
        return help(n-1,nums,target);
    }
}