class LRUCache {
    class Node
    {
        int key,value;
        Node prev, next;
        Node(int key, int value)
        {
            this.key = key;
            this.value= value;
        }
    }
    public final int capacity;
    private Map<Integer,Node> map;
    private Node head,tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    public void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node)
    {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
            remove(map.get(key));
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            insert(newNode);
            if(map.size()>capacity)
            {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */