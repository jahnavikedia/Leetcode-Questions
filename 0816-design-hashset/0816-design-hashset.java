class MyHashSet {
    public ArrayList<Integer> arr = new ArrayList<>();
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        if(!arr.contains(key))
        {
            arr.add(key);
        }
        return;
    }
    
    public void remove(int key) {
        if(arr.contains(key))
        {
            arr.remove(arr.indexOf(key));
        }
    }
    
    public boolean contains(int key) {
        return arr.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */