class Solution {
    public int maxArea(int[] height) {
        int area = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;

        while(i < j){
            int w = j  - i;
            int h = Math.min(height[i],height[j]);
            int currArea = w * h;
            area = Math.max(currArea,area);
            if(height[i] < height[j]){
                i++;
            }else if(height[i] > height[j]){
                j--;
            }else{
                i++;
                j--;
            }
        }

        return area;
    }
}