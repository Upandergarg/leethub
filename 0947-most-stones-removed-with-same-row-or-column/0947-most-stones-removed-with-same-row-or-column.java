class Solution { 
    class disjointSet {
        int par[];
        int rank[];

        disjointSet(int v) {
            par = new int[v];
            rank = new int[v];
            for (int i = 0; i < v; i++) {
                par[i] = i;
                rank[i] = 1;
            }
        }

        int find(int n) {
            if (par[n] == n)
                return n;
            int ulp = find(par[n]);
            par[n] = ulp;
            return par[n];
        }

        void unionRank(int u,int v){
            int ulp=find(u);
            int vlp=find(v);
            if(rank[ulp]>rank[vlp]) par[vlp]=ulp;
            else if(rank[vlp]>rank[ulp]) par[ulp]=vlp;
            else {
                par[vlp]=ulp;
                rank[ulp]++;
            }
        }
    }


    public int removeStones(int[][] stones) {
        int n= stones.length;
        disjointSet ds= new disjointSet(n);
// i, j is itereting over the stones array, and it represents a stone.
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    ds.unionRank(i,j);
                }
            }
        }
        //hashset to avaid duplicate ulp
        HashSet<Integer> set= new HashSet<>();
        
        for(int i=0; i<n; i++){
            if(i== ds.find(i)){
                set.add(i);
            }
        }
        return n-set.size();
    }
}