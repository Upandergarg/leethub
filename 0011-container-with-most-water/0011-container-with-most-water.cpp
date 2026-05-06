class Solution {
public:
    int maxArea(vector<int>& height) {
        int n= height.size();
        int maxwater= 0;

        int lp=0; int rp=n-1;
  while(lp<rp){
     int h= min(height[lp],height[rp]);
     int w= rp-lp;
     int currwater= w*h;

      if(height[lp]<height[rp]){
        lp++;
      }
      else{
        rp--;
      }
      maxwater= max(maxwater,currwater);
      
  }
  return maxwater;
   
    }
};