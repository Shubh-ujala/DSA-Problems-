class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = Integer.MIN_VALUE;
        int n = fruits.length;
        int basket_size =2;
        while(j<n){
            hm.put(fruits[j], hm.getOrDefault(fruits[j],0)+1);
            if(hm.size()>basket_size){
                // we have to shrink the window
                hm.put(fruits[i],hm.get(fruits[i]) - 1);
                if(hm.get(fruits[i]) == 0) hm.remove(fruits[i]);
                i++;
            }
            ans = Math.max(ans, (j-i+1));
            j++;
        }
        return ans;
    }
}