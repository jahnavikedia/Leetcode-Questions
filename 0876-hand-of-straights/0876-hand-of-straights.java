class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize > 0) return false;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int card:hand)
        {
            map.put(card,map.getOrDefault(card,0)+1);
        }
        for(int card: map.keySet())
        {
            int count = map.get(card);
            if(count==0) continue;
            for(int i=1;i<groupSize;i++)
            {
                int nextCard = card+i;
                if(map.getOrDefault(nextCard,0)<count) return false;
                map.put(nextCard,map.get(nextCard)-count);
            }
        }
        return true;
    }
}