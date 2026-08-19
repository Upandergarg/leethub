class Solution {
    class tuple{
        int n;
        int s;
        int p;
        tuple(int p,int n,int s){
            this.p=p;
            this.n=n;
            this.s=s;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      Queue<tuple> q= new LinkedList<>();
        List<List<int []>> adj= new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<flights.length; i++){
            adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
        int[] dis= new int [n];
        for(int i=0; i<n; i++){
            dis[i]= (int)1e9;
        }
        dis[src]=0;
        q.add(new tuple(0,src,0));
        while(!q.isEmpty()){
            tuple t= q.poll();
            int no=t.n;
            int p=t.p;
            int s=t.s;
            if(s>k) continue;
            for(int[] i: adj.get(no)){
                int newp=p+i[1];
                if(newp<dis[i[0]]) {
                    dis[i[0]]= newp;
                    q.add(new tuple(newp,i[0],s+1));
                }
            }
        }
        if(dis[dst]==(int)1e9) return -1;
        return dis[dst];
    }
}