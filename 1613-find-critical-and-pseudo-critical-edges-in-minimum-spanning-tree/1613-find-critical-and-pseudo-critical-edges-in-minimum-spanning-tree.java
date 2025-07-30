class DSU
{
    int parent[];
    int size[];
    DSU(int n)
    {
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x)
    {
        if(parent[x]!=x) parent[x] = find(parent[x]);
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
            size[s1] += size[s2];
        }
        return true;
    }
}
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int newEdges[][] = new int[m][4];
        for(int i=0;i<m;i++)
        {
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges,(a,b)->a[2]-b[2]);
        int baseWeight = kruskal(newEdges,n,-1,-1);
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            int withoutWeight= kruskal(newEdges,n, i,-1);
            if(withoutWeight>baseWeight)
            {
                critical.add(newEdges[i][3]);
            }
            else
            {
                int withWeight = kruskal(newEdges,n,-1,i);
                if(withWeight == baseWeight) pseudo.add(newEdges[i][3]);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(critical);
        result.add(pseudo);
        return result;
    }

    private int kruskal(int newEdges[][], int n,int skipEdge, int includeEdge)
    {
        DSU dsu = new DSU(n);
        int weight=0;
        int count=0;
        int m = newEdges.length;
        if(includeEdge != -1)
        {
            dsu.union(newEdges[includeEdge][0],newEdges[includeEdge][1]);
            weight+=newEdges[includeEdge][2];
            count+=1;
        }
        for(int i=0;i<m;i++)
        {
            if(skipEdge==i) continue;
            if(dsu.union(newEdges[i][0],newEdges[i][1]))
            {
                weight+=newEdges[i][2];
                count+=1;
            }
            if(count==n-1) break;
        }
        return (count==n-1)?weight:Integer.MAX_VALUE;
    }
}