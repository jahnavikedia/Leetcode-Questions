class Solution {
    public String predictPartyVictory(String senate) {
       int n=senate.length();
       Queue<Integer> radiant = new LinkedList<>();
       Queue<Integer> dire = new LinkedList<>();
       int i=0;
       for(char ch: senate.toCharArray())
       {
        if(ch=='D') dire.offer(i);
        else radiant.offer(i);
        i++;
       }
       while(!radiant.isEmpty() && !dire.isEmpty())
       {
        int r = radiant.poll();
        int d = dire.poll();
        if(r<d) radiant.offer(r+n);
        else dire.offer(d+n);
       }
       return radiant.isEmpty()?"Dire":"Radiant";
    }
}