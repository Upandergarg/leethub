class Solution {
    public boolean canJump(int[] nums) {
        int dis=0;
        for(int i=0; i<nums.length; i++){
      
            if(i>dis) return false;
                  dis=Math.max(dis,i+nums[i]);
        }
        return true;
    }
}