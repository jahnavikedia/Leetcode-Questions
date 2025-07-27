class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        String start = "0000";
        if(dead.contains(start)) return -1;
        int steps = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                String curr = q.poll();
                if(curr.equals(target)) return steps;
                for(String next : getNeighbors(curr))
                {
                    if(!dead.contains(next) && !visited.contains(next))
                    {
                        q.offer(next);
                        visited.add(next);
                    }
                }       
            }
            steps++;
        }
        return -1;
    }

    public List<String> getNeighbors(String s)
    {
        List<String> op = new ArrayList<>();
        for(int i=0;i<4;i++)
        {
            char arr[] = s.toCharArray();
            if(arr[i] == '9')arr[i]='0'; else arr[i] = (char) (arr[i]+1);
            op.add(new String(arr));
            arr = s.toCharArray();
            if(arr[i]=='0') arr[i] = '9';else arr[i] = (char) (arr[i]-1);
            op.add(new String(arr));
        }
        return op;
    }
}