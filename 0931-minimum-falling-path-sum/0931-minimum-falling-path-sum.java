class Solution {
    int help(int i,int j,int[][] matrix,int dp[][]){
      
        
        if(j>=matrix[0].length || j<0) return (int)1e8;
        if(dp[i][j]!=-1) return dp[i][j];
          if(i==0) return matrix[i][j];
        int down= matrix[i][j]+ help(i-1,j,matrix,dp); 
        int ld= matrix[i][j]+ help(i-1,j-1,matrix,dp);
        int rd= matrix[i][j]+help(i-1,j+1,matrix,dp);
        return dp[i][j]=Math.min(down, Math.min(ld,rd));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m= matrix[0].length;
        int max=(int)1e8;
        int dp[][]= new int[n][m];
        // for(int i[]: dp){
        //     Arrays.fill(i,-1);
        // }
        // for(int i=0; i<m; i++){
        //     max= Math.min(max,help(n-1,i,matrix,dp));
        // }
for(int i=0; i<m; i++) dp[0][i]= matrix[0][i];

        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                int ld=matrix[i][j];
                int rd=matrix[i][j];
        int down= matrix[i][j]+ dp[i-1][j]; 
       if(i>0 && j>0)ld+=  dp[i-1][j-1];
       else ld=(int)1e8;
        if(i>0 && j<m-1) rd+= dp[i-1][j+1];
        else rd=(int)1e8;
        dp[i][j]=Math.min(down, Math.min(ld,rd));
            }
        }
   for(int i=0; i<m; i++){
            max= Math.min(max,dp[n-1][i]);
        }
        return max;
    }
}