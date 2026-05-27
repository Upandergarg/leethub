class Solution {
    public int numberOfSpecialChars(String word) {
        //upper
        HashMap<Character,Integer> m= new HashMap<>();
        //lower
        HashMap<Character,Integer> h= new HashMap<>();
        for(int i=0; i<word.length(); i++){
            char s= word.charAt(i);
            if(Character.isUpperCase(s) && !m.containsKey(Character.toLowerCase(s))) m.put(Character.toLowerCase(s),i);
             if(Character.isLowerCase(s)) h.put(s,i);
        }
        int c=0;
   for(char i: h.keySet()){
    if(m.containsKey(i)&& m.get(i)>h.get(i) ) c++;
   }
        return c;
        
    }
}