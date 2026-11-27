class Solution {
    class Node{
        Node [] links= new Node[26];
        boolean flag=false;
        //end count
        int countP=0;
        
        public Node(){
      
        }
        void setEnd(){
            flag=true;
        }
        boolean isEnd(){
            return flag==true;
        }
        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        void put(char ch, Node n){
            links[ch-'a']=n;
        }
        Node get(char ch){
            return links[ch-'a'];
        }
        void inc(){
            countP++;
        }
        int getCp(){
            return countP;
        }
    }
    class trie{
        Node root;
        public trie(){
            root= new Node();
        }
        
        void insert(String w){
            Node node= root;
            for(int i=0; i<w.length(); i++){
                if(!node.containsKey(w.charAt(i))){
                    node.put(w.charAt(i),new Node());
                }
                node= node.get(w.charAt(i));
               
            }
            node.inc();
        }
          
        int check(String w){
            int max=0;
            Node node= root;
            for(int i=0; i<w.length(); i++){
                if(!node.containsKey(w.charAt(i))){
                   
                    break;
                }
                 
                node= node.get(w.charAt(i));
                
                max+=node.getCp();
            }
            return max;
        }
        
        
       
    }
    public int countPrefixes(String[] words, String s) {
        trie obj= new trie();
        
 int max=-1;
         for(int i=0; i<words.length; i++){
          obj.insert(words[i]) ;
        }
        max=Math.max( obj.check(s),max);
        return  max;
    }
}