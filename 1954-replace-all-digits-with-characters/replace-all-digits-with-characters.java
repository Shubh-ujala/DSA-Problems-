class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();

        char prev = s.charAt(0);
        sb.append(prev);

        for (int i = 1; i < s.length(); i++) {
            if (i % 2 == 0) {
                prev = s.charAt(i);
                sb.append(prev);
            } else {
                int n = s.charAt(i) - '0';
                sb.append((char)(prev + n));
            }
        }

        return sb.toString();
    }
}
