class Solution {
    int help(int i,int j, int[][] dp){
        if(i==0&&j==0) return 1;
        if(i<0|| j<0)return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int left= help(i,j-1,dp);
        int up=help(i-1,j,dp);
        return dp[i][j]= left+up;
    }
    public int uniquePaths(int m, int n) {
        int [][] dp= new int[m][n];
        for(int []i: dp){
            Arrays.fill(i,-1);
        }
        return help(m-1,n-1,dp);
    }
}