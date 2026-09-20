class Solution {
    public int uniquePathsWithObstacles(int[][] o) {
        
        int n=o[0].length;
        int m=o.length;

    
          int [] prv= new int[n];
       
            Arrays.fill(prv,0);
        
        // return help(m-1,n-1,dp);

        for(int i=0; i<m; i++){
            int [] cur= new int[n];
            for(int j=0; j<n; j++){
                 if(o[i][j]==1) continue;
                
                else if(i==0 && j==0) cur[j]=1;
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