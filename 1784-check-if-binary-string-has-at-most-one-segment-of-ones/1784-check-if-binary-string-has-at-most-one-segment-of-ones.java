class Solution {
    public boolean checkOnesSegment(String s) {
        int c=1;

        for(int i=1; i<s.length(); i++){
            if(c==0 && s.charAt(i)=='1'){
               return false;
            }
            else if(s.charAt(i)=='0')c=0;
        
        }
        return true;
      
    }
}