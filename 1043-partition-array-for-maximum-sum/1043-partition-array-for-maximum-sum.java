class Solution {
    int f(int i,int[] arr, int k){
        if(i==arr.length) return 0;
int len=0;
int max= Integer.MIN_VALUE;
int maxA= Integer.MIN_VALUE;
int sum=0;
        for(int j=i; j<Math.min(i+k,arr.length); j++){
            len++;
            max= Math.max(max,arr[j]);
            sum= len*max + f(j+1,arr,k);
               maxA= Math.max(maxA,sum);
        }
        return maxA;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n= arr.length;
         return f(0,arr,k);
    }
}