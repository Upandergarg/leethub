class Solution {
    public int rob(int[] nums) {
        int prv2=0;
        int prv=nums[0];
        int cur=0;
        for(int i=1; i<nums.length; i++){
            int take= nums[i];
            if(i>1){
                take+=prv2;
            }
            int nontake=0+prv;
            cur=Math.max(take,nontake);
            prv2=prv;
            prv=cur;
        }
        return prv;
    }
}