class Solution {
    int parent[], rank[];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=0;i<=n;i++) parent[i] = i;
        for(int edge[] : edges)
        {
            if(!union(edge[0],edge[1])) return edge;
        }
        return new int[]{};
    }
    
    public int find(int x)
    {
        if(parent[x]!=x) return parent[x] = find(parent[x]);
        return parent[x];
    }
    private boolean union(int x, int y)
    {
        int rootX = find(x); int rootY = find(y);
        if(rootX == rootY) return false;
        if(rank[rootX]>rank[rootY]) parent[rootY] = rootX;
        else if(rank[rootX] < rank[rootY]) parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}