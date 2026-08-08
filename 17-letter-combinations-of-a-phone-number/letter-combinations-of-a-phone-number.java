class Solution {
    public List<String> letterCombinations(String digits) {
        
        String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }


        solve("",digits,map,res);
        return res;
    }

    private void solve(String st , String digits, String[] map, List<String> res){
        if(digits.length() == 0){
            res.add(st);
            return;
        }

        int digit = digits.charAt(0) - '2';

        String letters = map[digit];

        for (char ch : letters.toCharArray()) {
            solve(st + ch, digits.substring(1), map, res);
        }
    }
}