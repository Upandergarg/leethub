class Solution {
    int f(int i, int b, int[] p, int [][] dp){
        if(i==p.length) return 0;
if(dp[i][b]!=-1) return dp[i][b];
        if(b==1) return dp[i][b]= Math.max(-p[i]+f(i+1,0,p,dp),f(i+1,1,p,dp));
        return dp[i][b]= Math.max(p[i]+f(i+1,1,p,dp),f(i+1,0,p,dp));
    }
    public int maxProfit(int[] prices) {
        int [][] dp= new int[prices.length][2];
 for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0,1,prices,dp);
    }
}