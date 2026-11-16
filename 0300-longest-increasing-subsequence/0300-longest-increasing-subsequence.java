class Solution {
    int f(int i,int p,int [] nums){
        if(i==nums.length) return 0;
        //not take
        int nt= f(i+1,p,nums);
        //take
        if(p==-1 || nums[i]>nums[p]){
            nt=Math.max( (1+ f(i+1,i,nums)),nt);
        }
        return nt;
    }

      int lowerBound(ArrayList<Integer> temp, int num) {
        int low = 0, high = temp.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (temp.get(mid) < num)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
    public int lengthOfLIS(int[] nums) {
        // return f(0,-1,nums);
// int n= nums.length;
// int [][]dp= new int[n+1][n+1];

// for(int i=n-1; i>=0; i--){
//     for(int p=i-1; p>=-1; p--){
//          int nt= dp[i+1][p+1];
//         //take
//         if(p==-1 || nums[i]>nums[p]){
//            nt = Math.max(nt, 1 + dp[i + 1][i + 1]);
//         }
//         dp[i][p+1]= nt;
//     }
// }
// return dp[0][0];

// int n= nums.length;
// int []dp= new int[n];
//     Arrays.fill(dp, 1);
// int len=0;
// for(int i=0; i<n; i++){
//     for(int p=0; p<i; p++){
        
//         if(nums[i]>nums[p]){
//            dp[i] = Math.max(dp[i], 1 + dp[p]);
//         }
//     }
//     len= Math.max(dp[i],len);
// }
// return len;

    ArrayList<Integer> temp = new ArrayList<>();

        for (int num : nums) {

            if (temp.isEmpty() || num > temp.get(temp.size() - 1)) {
                temp.add(num);
            } 
            else {
                int idx = lowerBound(temp, num);
                temp.set(idx, num);
            }
        }

        return temp.size();

    }
}