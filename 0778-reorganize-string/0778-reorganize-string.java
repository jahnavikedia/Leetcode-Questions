class Pair
{
    char key; int value;
    Pair(char key, int value)
    {
        this.key = key;
        this.value = value;
    }
}
class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->b.value - a.value);
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            maxHeap.add(new Pair(entry.getKey(),entry.getValue()));
        }
        int n = s.length();
        char arr[] = new char[n];
        Arrays.fill(arr,'#');
        while(!maxHeap.isEmpty())
        {
            Pair out = maxHeap.poll();
            char ele = out.key;
            int freq = out.value;
            for(int i=0;i<n;i++)
            {
                if(i==0 && arr[i] == '#')
                {
                    arr[i] = ele;
                    break;
                }
                else if(arr[i]=='#' && arr[i-1]!= ele)
                {
                    arr[i] = ele;
                    break;
                }
            }
            if(freq-1>0) maxHeap.add(new Pair(ele,freq-1));
        }
        for(char ch : arr)
        {
            if(ch=='#') return "";
        }
        String res =  Arrays.toString(arr);

        String result = new String(arr);
        return result;
    }
}