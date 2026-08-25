import java.util.*;

class Solution {
    int gcd(int a,int b){
        if(b==0) return a;
     return   gcd(b,a%b);
    }
    public int maxPoints(int[][] points) {

       
        int ans = 0;

        for (int i = 0; i < points.length; i++) {
                  HashMap<String, Integer> map = new HashMap<>();
           
            for (int j = i + 1; j < points.length; j++) {

                int y= points[j][1]- points[i][1];
                int x= points[j][0]- points[i][0];

                int gcd= gcd(y,x);

                y/=gcd;
                x/=gcd;
                if(x<0){
                    x=-x;
                    y=-y;
                }

                
                String slope= y+ "/" +x;
                map.put(slope,map.getOrDefault(slope,0)+1);
               ans= Math.max(ans,map.get(slope));

               
            }
        }

        return ans+1;
    }
}