class Solution {
    public int climbStairs(int n) {
        int x=1;
        int y=1;
        int cur=0;
        for(int i=2; i<=n; i++){
            cur=x+y;
            x=y;
            y=cur;
        }
        return y;
    }
}