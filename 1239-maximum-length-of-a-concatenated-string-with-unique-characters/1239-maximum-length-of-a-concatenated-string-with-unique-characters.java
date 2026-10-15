class Solution {
    int help(String s){
       
        HashSet<Character> set= new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            set.add(c);
        }
        return set.size()!=s.length()?0:set.size();
    }
    public int maxLength(List<String> arr) {
        HashSet<String> set= new HashSet<>();
  
      
    //    for(int i=0; i<arr.size(); i++){

    //     for(int j=i+1; j<arr.size(); j++){
    //         String t= arr.get(i)+arr.get(j);
    //         set.add(t);
    //     }
    //    }
    //    int max= -(int)1e9;
    //    for(String s: set){
    //     max= Math.max(max,help(s));
    //    }

     int n = arr.size();
        int totalCombinations = 1 << n; // 2^n combinations

        // Start from 1 to skip the empty string combination
        for (int i = 1; i < totalCombinations; i++) {
            List<String> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(arr.get(j));
                }
            }
            // Concatenate the elements using the specified delimiter
            set.add(String.join("", subset));
        }
        
       int max= -(int)1e9;
       for(String s: set){
        max= Math.max(max,help(s));
       }
       return max;
    }
}