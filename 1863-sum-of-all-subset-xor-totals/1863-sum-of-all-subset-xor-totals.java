class Solution {
    
    void help(int i, int [] nums,int sum, ArrayList<Integer> res){
        if(i<0) {
            res.add(sum);
            return;
        }
        help(i-1,nums,sum^nums[i],res);
        help(i-1,nums,sum,res);

    }
    public int subsetXORSum(int[] nums) {
        int sum=1;
        ArrayList<Integer> res= new ArrayList<>();
      help(nums.length-1, nums,0,res);
      int ans=0;
      for(int i: res) ans+=i;
      return ans;
    }
}