class Solution {
    public List<Integer> partitionLabels(String s) {
        int n=s.length();
        int [] last= new int[26];
        for(int i=0; i<n; i++){
            last[s.charAt(i)-'a']=i;
        }
        int l=0;
        int c=0;
        List<Integer> ans=new ArrayList<>();
        for(int i=0; i<n; i++){
             l= Math.max(l,last[s.charAt(i)-'a']);
            c++;
            if(i==l){
                ans.add(c);
                c=0;
            }


        }
        return ans;
    }
}