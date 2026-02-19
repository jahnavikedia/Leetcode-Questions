class RandomizedSet {
    Map<Integer,Integer> map;
    ArrayList<Integer> arr;
    Random random;
    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int pos = map.get(val);
        if(pos!=arr.size()-1)
        {
            int lastElement = arr.get(arr.size()-1);
            arr.set(pos,lastElement);
            map.put(lastElement,pos);
        }
        arr.remove(arr.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int rand = arr.get(random.nextInt(arr.size()));
        return rand;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */