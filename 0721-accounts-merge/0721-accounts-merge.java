class DSU
{
    int parent[];
    int size[];
    public DSU(int n)
    {
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findParent(int x)
    {
        if(x!=parent[x]) parent[x] = findParent(parent[x]);
        return parent[x];
    }
    public void union(int a, int b)
    {
        int s1 = findParent(a);
        int s2 = findParent(b);
        if(s1==s2) return;
        if(s1<s2)
        {
            parent[s1] = s2;
            size[s2]++;
        }
        else
        {
            parent[s2] = s1;
            size[s1]++;
        }
        return;
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                String email = accounts.get(i).get(j);
                if(map.containsKey(email))
                {
                    dsu.union(i,map.get(email));
                }
                else
                {
                    map.put(email, i);
                }
            }
        }
        Map<Integer,List<String>> mergedList = new HashMap<>();
        for(Map.Entry<String,Integer> entry : map.entrySet())
        {
            int parent = dsu.findParent(entry.getValue());
            if(!mergedList.containsKey(parent))
                mergedList.put(parent,new ArrayList<String>());
            mergedList.get(parent).add(entry.getKey()); 
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Integer,List<String>> entry : mergedList.entrySet())
        {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(entry.getKey()).get(0));
            account.addAll(emails);
            result.add(account);
        }
        return result;
    }
}