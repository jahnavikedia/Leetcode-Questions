class Pair{
    int room;
    int end;
    int count;
    Pair(int room,int end, int count){
        this.room = room;
        this.end = end;
        this.count = count;
    }
}
class Solution {
    public int mostBooked(int k, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> available = new PriorityQueue<>();
        PriorityQueue<Pair> busyRoom = new PriorityQueue<>((a,b)-> {
            if(a.end==b.end) return a.room-b.room;
            else return a.end-b.end;
        });
        for (int i = 0; i < k; i++) {
            available.offer(i);
        }
        int count[] = new int[k];
        for(int meeting[] : meetings)
        {
            int start = meeting[0]; int end = meeting[1]; int duration = end-start;
            while(!busyRoom.isEmpty() && busyRoom.peek().end<=start)
            {
                available.offer(busyRoom.poll().room);
            }
            if(!available.isEmpty())
            {
                int room = available.poll();
                count[room]++;
                busyRoom.offer(new Pair(room,end,count[room]));
            }
            else
            {
                Pair earliest = busyRoom.poll();
                count[earliest.room]++;
                busyRoom.offer(new Pair(earliest.room,earliest.end + duration, count[earliest.room]));
            }
        }
        int maxCount = -1, result=0;
        for(int i=0;i<k;i++)
        {
            if(count[i]>maxCount || (count[i]==maxCount && i<result))
            {
                maxCount = count[i];
                result = i;
            }
        }
        return result;
    }
}