class Pair{
    int x, y;
    double distance;
    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.distance = (x*x)+(y*y);
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingDouble(p -> p.distance));
        for(int point[]:points)
        {
            pq.offer(new Pair(point[0],point[1]));
        }
        int op[][] = new int[k][2];
        int i=0;
        while(i<k)
        {
            Pair temp = pq.poll();
            op[i][0] = temp.x;
            op[i][1] = temp.y;
            i++;
        }
        return op;
    }
}