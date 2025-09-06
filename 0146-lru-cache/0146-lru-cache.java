class Node
{
    int key,value;
    Node prev,next;
    Node(int key, int value)
    {
        this.key=key;
        this.value = value;
    }
}
class LRUCache {
    private final int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    public void insert(Node node)
    {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    public void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
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
        if(map.containsKey(key)) remove(map.get(key));
        Node node = new Node(key,value);
        insert(node);
        map.put(key,node);
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