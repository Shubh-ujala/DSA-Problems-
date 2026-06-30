class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int count = 0;
        int n = s.length();

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int right = 0; right < n; right++) {

            char ch = s.charAt(right);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            while (hm.size() == 3) {

                count += (n - right);

                char leftChar = s.charAt(left);
                hm.put(leftChar, hm.get(leftChar) - 1);

                if (hm.get(leftChar) == 0) {
                    hm.remove(leftChar);
                }

                left++;
            }
        }

        return count;
    }
}