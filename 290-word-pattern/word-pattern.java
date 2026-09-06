class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] ch = s.split(" ");

        if(pattern.length() != ch.length) return false;

        HashMap<Character, String> hm = new HashMap<>();
        HashMap<String, Character> hm2 = new HashMap<>();

        char[] patt = pattern.toCharArray();

        for(int i = 0; i < patt.length; i++) {

            char c = patt[i];
            String word = ch[i];

            if(hm.containsKey(c)) {

                if(!hm.get(c).equals(word)) {
                    return false;
                }

            } else {

                if(hm2.containsKey(word)) {
                    return false;
                }

                hm.put(c, word);
                hm2.put(word, c);
            }
        }

        return true;
    }
}