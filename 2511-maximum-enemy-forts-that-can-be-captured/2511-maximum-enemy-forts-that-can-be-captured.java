class Solution {
    public int captureForts(int[] forts) {
        int prv=-1;
        int ans=0;
        for(int i=0; i<forts.length; i++){
            if(forts[i]==0)continue;
            if(prv!=-1 && forts[i]!=forts[prv]){
                ans= Math.max(ans,i-prv-1);
            }
            prv=i;
        }
        return ans;
    }
}