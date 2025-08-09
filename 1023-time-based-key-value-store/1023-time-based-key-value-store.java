class TimeMap {
    private static class Entry
    {
        int time;
        String val;
        Entry(int time, String val)
        {
            this.time = time;
            this.val = val;
        }
    }
    private Map<String,List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key,new ArrayList<>());
        map.get(key).add(new Entry(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Entry> list = map.get(key);
        int start = 0,end = list.size()-1;
        String res="";
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(list.get(mid).time==timestamp) return list.get(mid).val;
            else if(list.get(mid).time<timestamp)
            {
                start=mid+1;
                res = list.get(mid).val;
            }
            else end=mid-1;
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */