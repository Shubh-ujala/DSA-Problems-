class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] cpy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(cpy);
        int rank = 1;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i<cpy.length ; i++){
            if(!hm.containsKey(cpy[i])){
                hm.put(cpy[i],rank);
                rank++;
            }
        }

        for(int i = 0; i<arr.length ; i++){
            int rnk = hm.get(arr[i]);
            arr[i] = rnk;
        }
        return arr;
    }
}