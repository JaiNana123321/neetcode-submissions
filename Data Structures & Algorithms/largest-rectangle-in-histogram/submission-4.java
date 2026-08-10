class Solution {

    public int largestRectangleArea(int[] heights) {
        int[] indexOfClosestBarOfLowerHeightForward = new int[heights.length];
        int[] indexOfClosestBarOfLowerHeightBackward = new int[heights.length];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                indexOfClosestBarOfLowerHeightForward[stack.pop()] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            indexOfClosestBarOfLowerHeightForward[stack.pop()] = heights.length;
        }
        stack = new ArrayDeque<>();
        for(int i = heights.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                indexOfClosestBarOfLowerHeightBackward[stack.pop()] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            indexOfClosestBarOfLowerHeightBackward[stack.pop()] = -1;
        }


        int maxArea = heights[0];
        for(int i = 0; i < heights.length; i++){
            int leftIndex = indexOfClosestBarOfLowerHeightBackward[i];
            int rightIndex = indexOfClosestBarOfLowerHeightForward[i];
            int area = heights[i] * (rightIndex - leftIndex - 1);
            if(area > maxArea) maxArea = area;
        }

        //System.out.println(Arrays.toString(indexOfClosestBarOfLowerHeightForward));
        //System.out.println(Arrays.toString(indexOfClosestBarOfLowerHeightBackward));
        return maxArea;
    }
}
