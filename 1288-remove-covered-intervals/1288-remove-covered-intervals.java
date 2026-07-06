class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
      Arrays.sort(intervals,(a,b)->{
        if(a[0]==b[0]) return b[1]-a[1];
        return a[0]-b[0];
      });
      int ans=1;
      int maxEnd=intervals[0][1];
      for(int i=0; i<intervals.length; i++){
        if(maxEnd<intervals[i][1]){
            maxEnd=intervals[i][1];
            ans++;
        }
      }
      return ans;
    }
}