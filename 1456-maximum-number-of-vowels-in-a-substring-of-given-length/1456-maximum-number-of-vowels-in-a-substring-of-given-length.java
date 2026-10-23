class Solution {
      public static boolean isVowel(char ch) {
        String vowels = "aeiou";
        return vowels.indexOf(Character.toLowerCase(ch)) != -1;
    }
    public int maxVowels(String s, int k) {
      int l=0;
      int r=0;
    int max=Integer.MIN_VALUE;
    int c=0;
      while(r<s.length()){
    if(isVowel(s.charAt(r)))c++;
        if(r-l+1==k){
            max= Math.max(max,c);
        if (isVowel(s.charAt(l))) c--;
            l++;
        }

        r++;
      }
      return max;
    }
}