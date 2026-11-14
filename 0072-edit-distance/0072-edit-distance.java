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
        int []prv= new int[m+1];
 int []cur= new int[m+1];
        // return f(n-1,m-1,w1,w2,dp);

        for(int j=0; j<=m; j++) prv[j]=j;

        for(int i=1; i<=n; i++){
cur[0]=i;
            for(int j=1; j<=m; j++){
                  if(w1.charAt(i-1)==w2.charAt(j-1))  cur[j]= prv[j-1];
        else cur[j]= Math.min(1+cur[j-1],Math.min(1+prv[j],1+prv[j-1]));
            }
            prv=cur.clone();
        }
        return prv[m];
    }
}