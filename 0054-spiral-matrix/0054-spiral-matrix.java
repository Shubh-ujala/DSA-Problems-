class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length; // row
        int m = matrix[0].length; // column

        int top = 0;
        int bottom = n - 1;

        int left = 0;
        int right = m - 1;

        List<Integer> ans = new ArrayList<>();
        int dir = 0;

        while(left<=right && top<=bottom){
            if(dir == 0){
                // L -> R
                for(int i = left ; i<=right ; i++){
                    ans.add(matrix[top][i]);
                }
                
                top++;
            }
            else if(dir == 1){
                // Top -> bottom
                for(int i = top ; i<=bottom ; i++){
                    ans.add(matrix[i][right]);
                }
                right--;
            }else if(dir == 2){
                // right to left

                for(int i = right ; i>=left ; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }else if(dir == 3){
                // bottom to top
                for(int i = bottom ; i>=top ; i-- ){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            dir++;
            if(dir == 4) dir = 0;
        }

        return ans;

    }
}