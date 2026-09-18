class Solution {
    // int help(int[] cost,int ind,int[]dp){
    //     if(dp[ind]!=-1) return dp[ind];
    //     if(ind==0){
    //         return cost[0];
    //     }
        
    //        int c1= cost[ind];
    //     if(ind>1){
    //    c1+= help(cost,ind-2,dp);
    //     }
     
    //     int c= cost[ind]+help(cost,ind-1,dp);
    //     return dp[ind]=Math.min(c1,c);
    // }
    public int minCostClimbingStairs(int[] cost) {
        int dp[]= new int[cost.length+1];
        // Arrays.fill(dp,-1);
        // int [] a= Arrays.copyOfRange(cost,1,cost.length);
        // return Math.min(help(cost,cost.length-1,dp),help(cost,a.length-1,dp));
        dp[0]=cost[0];
    
        for(int ind=1; ind<cost.length; ind++){
            int c1=cost[ind];
            if(ind>1) c1+=dp[ind-2];
int c2= cost[ind]+dp[ind-1];
dp[ind]=Math.min(c1,c2);
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}