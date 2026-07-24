class Pair {
    int num;
    int freq;

    Pair(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.freq, b.freq)
        );

        for (int key : map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int i = 0;

        while (!pq.isEmpty()) {
            ans[i++] = pq.poll().num;
        }

        return ans;
    }
}