class Pair{
    int key;
    int val;

    Pair(int key, int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    ArrayList<Pair> cache ;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new ArrayList<>(capacity);
    }
    
    public int get(int key) {
    for (int i = 0; i < cache.size(); i++) {
        Pair p = cache.get(i);
        if (p.key == key) {
            cache.remove(i);
            cache.add(p);
            return p.val;
        }
    }
    return -1;
}
    
    public void put(int key, int value) {
    // Key already exists
    for (int i = 0; i < cache.size(); i++) {
        Pair p = cache.get(i);
        if (p.key == key) {
            p.val = value;
            cache.remove(i);
            cache.add(p);   // Move to most recently used
            return;
        }
    }

    // Cache full
    if (cache.size() == capacity) {
        cache.remove(0);    // Remove least recently used
    }

    cache.add(new Pair(key, value));
}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */