class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char,int>  mp;
        int m=0;
        int st=0;
        for(int end=0; end<s.length(); end++){
mp[s[end]]++;
while(mp[s[end]]>1){
mp[s[st]]--;
st++;
}

m =  max(m, end-st+1);
        }
        return m;
    }
};