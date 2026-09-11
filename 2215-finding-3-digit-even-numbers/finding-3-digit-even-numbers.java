class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;


        for(int i = 0 ; i<n ; i++){
            if(digits[i] == 0) continue;
            for(int j = 0 ; j<n ; j++){
                if(i == j) continue;

                for(int k = 0 ; k < n ; k++){
                    if(i == k || k == j) continue;
                   
                    int num = digits[i]*100 + digits[j]*10 +digits[k];
                    if(num%2 == 0)set.add(num);
                    
                }
            }
        }

        List<Integer> list = new ArrayList<>(set);
        int size = list.size();

        int[] res = new int[size];
        for(int i = 0 ; i<size ; i++){
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }
}