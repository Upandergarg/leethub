class Solution {
    void f(int index,int[] c, int target, List<List<Integer>> ans,List<Integer>  t ){
if(target==0){
  ans.add(new ArrayList(t));
  return;
}
for(int i=index; i<c.length; i++){
if( index!=i && c[i]==c[i-1]) continue;
if(c[i]>target) break;
    t.add(c[i]);
    f(i+1,c,target-c[i],ans,t);
    t.remove(t.size()-1);
}
      
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> ans= new ArrayList<>();
        List<Integer> t= new ArrayList<>();
      Arrays.sort(candidates);
f(0,candidates,target,ans,t);
  
return ans;
    }
}