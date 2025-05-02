class Pair{
    int passengers;
    int end;
    Pair(int passengers,int end)
    {
        this.passengers = passengers;
        this.end = end;
    }
}
class cmp implements Comparator<Pair>
{
    public int compare(Pair p1, Pair p2)
    {
        return p1.end-p2.end;
    }
}
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new cmp()); //minheap
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
        int curPass=0;
        for(int i=0;i<trips.length;i++)
        {
            while(!pq.isEmpty() && pq.peek().end <= trips[i][1])
            {
                curPass = curPass-pq.poll().passengers;
            }
            curPass = curPass + trips[i][0];
            if(curPass>capacity) return false;
            pq.add(new Pair(trips[i][0],trips[i][2]));
        }
        return true; 
    }
}