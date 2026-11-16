class Solution {
    int f(int i,int p,int [] nums){
        if(i==nums.length) return 0;
        //not take
        int nt= f(i+1,p,nums);
        //take
        if(p==-1 || nums[i]>nums[p]){
            nt=Math.max( (1+ f(i+1,i,nums)),nt);
        }
        return nt;
    }
    public int lengthOfLIS(int[] nums) {
        // return f(0,-1,nums);
int n= nums.length;
int [][]dp= new int[n+1][n+1];

for(int i=n-1; i>=0; i--){
    for(int p=i-1; p>=-1; p--){
         int nt= dp[i+1][p+1];
        //take
        if(p==-1 || nums[i]>nums[p]){
           nt = Math.max(nt, 1 + dp[i + 1][i + 1]);
        }
        dp[i][p+1]= nt;
    }
}
return dp[0][0];
    }
}