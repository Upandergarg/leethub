class Solution {
    class pair{
       String node;
        int  step;
        pair(String node,int step){
            this.node=node;
            this.step=step;

        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> q= new LinkedList<>();
        q.add(new pair(beginWord,1));
        HashSet<String> set= new HashSet<>();
        for(String s: wordList) set.add(s);

        while(!q.isEmpty()){
            pair p= q.poll();
            String n= p.node;
            int step= p.step;
            if(n.equals(endWord)) return step;
            for(int i=0; i<n.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char[] carr= n.toCharArray();
                    carr[i]=ch;
                    String temp= new String(carr);
                    if(set.contains(temp)){
                        set.remove(temp);
                        q.add(new pair(temp,step+1));
                    
                    }
                }
            }
        }
        return 0;
        
    }
}