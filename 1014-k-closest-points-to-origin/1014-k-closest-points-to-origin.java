class Pair
{
    int x;
    int y;
    double distance;
    Pair(int x,int y)
    {
        this.x= x;
        this.y = y;
        this.distance = (x * x) + (y * y);
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingDouble(p -> p.distance));
        for(int i = 0;i<points.length;i++)
        {
            minHeap.offer(new Pair(points[i][0],points[i][1]));
        }
        int op[][] = new int[k][2];
        int i=0;
        while(i<k)
        {
            Pair temp = minHeap.poll();
            op[i][0] = temp.x;
            op[i][1] = temp.y;
            i++;
        }
        return op;
    }
}