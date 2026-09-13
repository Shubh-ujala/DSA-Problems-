class Solution {
    public boolean checkIfPangram(String sentence) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char ch : sentence.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }

        return hm.size() == 26;
    }
}