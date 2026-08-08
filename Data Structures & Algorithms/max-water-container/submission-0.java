class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxVolume = (right - left) * Math.min(heights[left],heights[right]);
        while(left < right){
            if(heights[left] < heights[right]){
                left++;
            }else if (heights[left] > heights[right]){
                right--;
            }else{
                left++;
            }
            int newVolume = (right - left) * Math.min(heights[left],heights[right]);
            maxVolume = maxVolume > newVolume ? maxVolume : newVolume;
        }
        return maxVolume;
    }
}
