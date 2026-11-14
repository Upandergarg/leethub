class Solution {
    int f(int i,int j,String w1, String w2,int [][]dp){
        
        if(i<0) return j+1;
        if(j<0) return i+1;
if(dp[i][j]!=0) return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)) return dp[i][j]= f(i-1,j-1,w1,w2,dp);
        return dp[i][j]= Math.min(1+f(i,j-1,w1,w2,dp),Math.min(1+f(i-1,j,w1,w2,dp),1+f(i-1,j-1,w1,w2,dp)));

    }
    public int minDistance(String w1, String w2) {
        int n=w1.length();
        int m=w2.length();
        int [][]dp= new int[n+1][m+1];

        return f(n-1,m-1,w1,w2,dp);
    }
}