class LRUCache {
    class Node{
        int key,val;
        Node next,prev;

        Node(){
            key = -1;
            val = -1;
            next = null;
            prev = null;
        }

        Node(int key , int val){
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }

    int cap;
    HashMap<Integer,Node> map = new HashMap<>();
    Node head;
    Node tail;

    public void insertAfterHead(Node node){
        Node nextNode = head.next;
        head.next = node;
        nextNode.prev = node;

        node.prev = head;
        node.next = nextNode;
    }

    public void deleteNode(Node node){

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        int val = node.val;

        deleteNode(node);
        insertAfterHead(node);

        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;

            deleteNode(node);
            insertAfterHead(node);
            return;
        }

        if(cap == map.size()){
            Node node = tail.prev;
            map.remove(node.key);

            deleteNode(node);
        }

        Node newNode = new Node(key,value);
        map.put(key,newNode);
        insertAfterHead(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */