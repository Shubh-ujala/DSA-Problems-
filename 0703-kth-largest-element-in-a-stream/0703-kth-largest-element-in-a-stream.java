class KthLargest {
    // asked highest -> min Heap
    PriorityQueue<Integer> pq;
    int size;
    public KthLargest(int k, int[] nums) {
       pq = new PriorityQueue<>(k);
       size = k;
       for(int i : nums) add(i);
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>size){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */