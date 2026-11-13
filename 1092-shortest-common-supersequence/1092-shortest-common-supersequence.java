class Solution {
    void f(String s1, String s2,int [][] dp){
        int n= s1.length();
        int m= s2.length();
    
        for(int i=1; i<=n; i++) dp[i-1][0]=0;
        for(int i=1; i<=m; i++) dp[0][i-1]=0;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
    }
    public String shortestCommonSupersequence(String s1, String s2) {
        int i= s1.length();
        int j= s2.length();
         int [][] dp= new int [i+1][j+1];
          f(s1,s2,dp);
        
        String ans="";
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                    ans+=s1.charAt(i-1);
                    i--;
                    j--;
                }
            else if(dp[i-1][j]>dp[i][j-1]){
                ans+=s1.charAt(i-1);
                i--;
            }
            else{
                ans+=s2.charAt(j-1);
                j--;
            }
        }
        while(i>0){
            ans+=s1.charAt(i-1);
            i--;
        }
        while(j>0){
ans+=s2.charAt(j-1);
j--;
        } 
        return  new StringBuilder(ans).reverse().toString();
    }
}