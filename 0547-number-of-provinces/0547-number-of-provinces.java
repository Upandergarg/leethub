class Solution {
    class disjointSet {
		int []parent;
		int [] rank;
		public disjointSet(int v) {
			parent = new int[v];
			rank= new int[v];
			for (int i = 0; i<v; i++) {
				parent[i] = i;
				rank[i] = 1;
			}
		}
		int find(int n) {
			if (parent[n] == n)
				return n;
			int ulp = find(parent[n]);
			parent[n] = ulp;
			return parent[n];
		}
		void union(int x, int y) {
			int s1 = find(x);
			int s2 = find(y);
			if (s1 != s2) {
				if (rank[s1] < rank[s2]) {
					parent[s1] = s2;
				} else if (rank[s1] > rank[s2]) {
					parent[s2] = s1;
				} else {
					parent[s2] = s1;
					rank[s1]++;
				}
			}
		}
	}
    public int findCircleNum(int[][] isConnected) {
        int v= isConnected.length;
        disjointSet ds= new disjointSet(v);

       for(int i=0; i<v; i++){
        for(int j=0; j<v; j++){
            if(isConnected[i][j]==1){
                ds.union(i,j);
            }
        }
       }
       int count=0;
       for(int i=0; i<v; i++){
        if(ds.find(i)==i)   count++;
       }
       return count;
    }
}