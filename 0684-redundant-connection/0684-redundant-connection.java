class DSU{
    int parent[];
    int size[];
    public DSU(int n){
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=1;i<=n;i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x)
    {
        if(x!=parent[x]) parent[x]=find(parent[x]);
        return parent[x];
    }
    public boolean union(int a, int b)
    {
        int s1 = find(a);
        int s2 = find(b);
        if(s1==s2) return false;
        if(size[s1]<size[s2])
        {
            parent[s1] = s2;
            size[s2]+= size[s1];
        }
        else
        {
            parent[s2] = s1;
            size[s1]+=size[s2];
        }
        return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);
        for(int[] edge: edges)
        {
            if(!dsu.union(edge[0],edge[1])) return edge;
        }
        return new int[0];
    }
}