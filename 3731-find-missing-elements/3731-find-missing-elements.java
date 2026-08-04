class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int min = nums[0];
        int max = nums[0];


        for(int i : nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        int[] arr = new int[max+1];

        for(int i : nums){
            arr[i]++;
        }


        
        for(int i = min ; i<=max ; i++){
            if(arr[i] == 0) list.add(i);
        }

        return list;
    }
}