class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, boolean[]> hm = new HashMap<>();

        for (int[] res : reservedSeats) {
            int row = res[0];
            int col = res[1];

            if (!hm.containsKey(row)) {
                hm.put(row, new boolean[11]);
            }

            hm.get(row)[col] = true;
        }

        int count = (n - hm.size()) * 2;

        for (boolean[] reserved : hm.values()) {

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for (int j = 2; j <= 5; j++) {
                if (reserved[j]) {
                    left = false;
                    break;
                }
            }

            for (int j = 4; j <= 7; j++) {
                if (reserved[j]) {
                    middle = false;
                    break;
                }
            }

            for (int j = 6; j <= 9; j++) {
                if (reserved[j]) {
                    right = false;
                    break;
                }
            }

            if (left && right) {
                count += 2;
            } 
            else if (left || middle || right) {
                count += 1;
            }
        }

        return count;
    }
}