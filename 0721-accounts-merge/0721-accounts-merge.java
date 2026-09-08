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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n= accounts.size();
        HashMap<String,Integer> map= new HashMap<>();
        disjointSet ds= new disjointSet(n);
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                if(map.containsKey(accounts.get(i).get(j))){
                    ds.unionRank(i,map.get(accounts.get(i).get(j)));
                }
                else{
                    map.put(accounts.get(i).get(j),i);
                }
            }
        }

        List<List<String>> merged= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            merged.add(new ArrayList<>());
        }
        for(String s: map.keySet()){
            int no=ds.find(map.get(s));
            merged.get(no).add(s);
        }
        List<List<String>> ans= new ArrayList<>();


 
        for(int i=0; i<n; i++){
            if(merged.get(i).size()==0) continue;
            Collections.sort(merged.get(i));
            List<String> temp= new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(merged.get(i));
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}