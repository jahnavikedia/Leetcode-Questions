class LFUCache {
    class Node
    {
        int key, value, freq;
        Node prev, next;
        Node(int key, int value)
        {
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }
    class DLList{
        Node head, tail;
        int size;
        DLList()
        {
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void add(Node node)
        {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node)
        {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast()
        {
        if(size>0)
        {
            Node lru = tail.prev;
            remove(lru);
            return lru;
        }  
        return null;
        }
    }
    private int capacity, size, minFreq;
    private Map<Integer, Node> nodeMap;
    private Map<Integer, DLList> freqMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public void update(Node node)
    {
        int freq = node.freq;
        DLList oldList = freqMap.get(freq);
        oldList.remove(node);
        if(freq == minFreq && oldList.size == 0) minFreq++;
        node.freq++;
        DLList newList = freqMap.getOrDefault(node.freq, new DLList());
        newList.add(node);
        freqMap.put(node.freq, newList);
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(nodeMap.containsKey(key))
        {
            Node node = nodeMap.get(key);
            node.value = value;
            update(node);
        }
        else
        {
            if(size == capacity)
            {
                DLList minList = freqMap.get(minFreq);
                Node evict = minList.removeLast();
                nodeMap.remove(evict.key);
                size--;
            }
            Node node = new Node(key,value);
            nodeMap.put(key,node);
            minFreq = 1;
            DLList newList = freqMap.getOrDefault(minFreq, new DLList());
            newList.add(node);
            freqMap.put(1,newList);
            size++;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */