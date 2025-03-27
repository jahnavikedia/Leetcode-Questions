public class Pair{
    int point;
    int distance;
    Pair(int point,int distance)
    {
        this.point=point;
        this.distance = distance;
    }
}
class cmp implements Comparator<Pair>
{
    public int compare(Pair p1,Pair p2)
    {
        if (p1.distance != p2.distance) {
            return p2.distance - p1.distance;
        } else {
            return p2.point - p1.point;
        }
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new cmp());
        ArrayList<Integer> op = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            maxHeap.add(new Pair(arr[i],Math.abs(x-arr[i])));
            if(maxHeap.size()>k)
            {
                maxHeap.remove();
            }
        }
        while(!maxHeap.isEmpty())
        {
            op.add(maxHeap.remove().point);
        }
        Collections.sort(op);
        return op;
    }
}