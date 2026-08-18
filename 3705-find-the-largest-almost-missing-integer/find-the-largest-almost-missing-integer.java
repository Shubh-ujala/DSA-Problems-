class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        int res = 0;
        if (k == 1) {
            int temp = Integer.MIN_VALUE;
            for (int key : hm.keySet()) {
                if (hm.get(key) == 1 && key > temp) {
                    temp = key;
                }
            }

            return temp == Integer.MIN_VALUE ? -1 : temp;
        } else if (k == n) {
            int max_i = Integer.MIN_VALUE;
            for (int i : nums) {
                max_i = Math.max(max_i, i);
            }

            return max_i;
        } else {
            int temp = -1;

            if (hm.get(nums[0]) == 1) {
                temp = Math.max(temp, nums[0]);
            }

            if (hm.get(nums[n - 1]) == 1) {
                temp = Math.max(temp, nums[n - 1]);
            }

            return temp;
        }
    }
}