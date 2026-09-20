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
        int [] prv= new int[n];
       
            Arrays.fill(prv,0);
        
        // return help(m-1,n-1,dp);

        for(int i=0; i<m; i++){
            int [] cur= new int[n];
            for(int j=0; j<n; j++){
                if(i==0 && j==0) cur[j]=1;
                else{
                   
                    int up=0;
                    int left=0;
                    if(i>0) up+=prv[j];
                    if(j>0) left+=cur[j-1];
                    cur[j]= up+left;
                     System.out.println(cur[j]);
                }
               
            }
             prv=cur;
        }
        return prv[n-1];
    }
}