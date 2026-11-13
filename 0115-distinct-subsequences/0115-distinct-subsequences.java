class Solution {
    int f(int i,int j,String s, String t, int [][]dp){

if(j<0 ) return 1;
if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) return dp[i][j]=f(i-1,j,s,t,dp)+f(i-1,j-1,s,t,dp);
return dp[i][j]= f(i-1,j,s,t,dp);

    }
    public int numDistinct(String s, String t) {
        int n= s.length();
        int m= t.length();
        int [] cur= new int[m+1];
        int [] prv= new int [m+1];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }

    //    return f(n-1,m-1,s,t,dp);
 prv[0] = 1;
 cur[0] = 1;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
             if(s.charAt(i-1)==t.charAt(j-1))  cur[j]=prv[j]+prv[j-1];
             else
 cur[j]= prv[j];
        }
      prv = cur.clone();
    }
    return prv[m];
    }
}