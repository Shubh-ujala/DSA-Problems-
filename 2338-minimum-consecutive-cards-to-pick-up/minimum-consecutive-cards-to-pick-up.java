class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int i = 0;//left
        int j = 0;//right

        int minCards = Integer.MAX_VALUE;
        int n = cards.length;

        while(j < n){
            if(hm.containsKey(cards[j])){
                int prevIdx = hm.get(cards[j]);
                minCards = Math.min(minCards, j - prevIdx + 1);
                i++;
            
            }
            hm.put(cards[j],j);
            j++;            
        }

        return minCards == Integer.MAX_VALUE ? -1 : minCards;

    }
}