class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> [] bucket= new ArrayList[nums.length+1];

        for(int key: map.keySet()){
            int f= map.get(key);
            if(bucket[f]==null) bucket[f]=new ArrayList<>();
            bucket[f].add(key);
        }
        int [] ans= new int[k];
        int ind=0;
        for(int i=nums.length; i>=1; i--){
            if(bucket[i]!=null){
                for(int j: bucket[i]){
                    ans[ind++]= j;
                    if(ind==k) return ans;
                }
            }
        }
        return ans;
    }
}