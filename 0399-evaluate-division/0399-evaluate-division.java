class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> map = new HashMap<>();
        int i=0;
        for(List<String> equation : equations)
        {
            String src = equation.get(0);
            String dest = equation.get(1);
            map.putIfAbsent(src, new HashMap<>());
            map.putIfAbsent(dest, new HashMap<>());
            double val = values[i];i++;
            map.get(src).put(dest,val);
            map.get(dest).put(src,1.0/val);
        }
        i=0;
        double op[] = new double[queries.size()];
        for(List<String> query : queries)
        {
            String src = query.get(0);
            String dest = query.get(1);
            if(!map.containsKey(src) || !map.containsKey(dest)) op[i] = -1.0;
            else if(src.equals(dest)) op[i] = 1.0;
            else
            {
                Set<String> visited = new HashSet<>();
                op[i] = dfs(map,src,dest,visited,1.0);
            }
            i++;
        }
        return op;
    }
    private double dfs(Map<String,Map<String,Double>> map, String src, String dest, Set<String> visited, double prod)
    {
        if(src.equals(dest)) return prod;
        visited.add(src);
        for(Map.Entry<String,Double> nbr : map.get(src).entrySet())
        {
            if(!visited.contains(nbr.getKey()))
            {
               double result =  dfs(map,nbr.getKey(),dest,visited,prod*nbr.getValue());
               if(result!=-1.0) return result;
            }
        }
        return -1.0;
    }
}