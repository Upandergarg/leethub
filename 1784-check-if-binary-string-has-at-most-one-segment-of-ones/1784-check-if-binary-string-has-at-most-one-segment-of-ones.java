class Solution {
    public boolean checkOnesSegment(String s) {
      int i=0;
      while(i<s.length()){
        if(s.charAt(i)!='1') break; 
        i++;
      }
      if(i==s.length()) return true;

      while(i<s.length()){
if(s.charAt(i)=='1') return false;

        i++;
      }
      return true;

    }
}