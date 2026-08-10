class Solution {

    public int largestRectangleArea(int[] heights) {
        //index of closest bar to the right with lower height than current bar
        int[] indexOfClosestBarOfLowerHeightForward = new int[heights.length];
        //index of closest bar to the left with lower height than current bar
        int[] indexOfClosestBarOfLowerHeightBackward = new int[heights.length];

        //Calculate index of closest bar to the right with lower height than current bar
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                indexOfClosestBarOfLowerHeightForward[stack.pop()] = i;
            }
            stack.push(i);
        }
        //handle all leftover items on stack
        while(!stack.isEmpty()){
            indexOfClosestBarOfLowerHeightForward[stack.pop()] = heights.length;
        }

        //Calculate index of closest bar to the left with lower height than current bar
        stack = new ArrayDeque<>();
        for(int i = heights.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                indexOfClosestBarOfLowerHeightBackward[stack.pop()] = i;
            }
            stack.push(i);
        }
        //handle all leftover items on stack
        while(!stack.isEmpty()){
            indexOfClosestBarOfLowerHeightBackward[stack.pop()] = -1;
        }


        //Area = height[i] * (rightIndex - LeftIndex - 1);
        //Current rectangle height, stretched as far to left and right as possible
        //indexOfClosestBarOfLowerHeightForward is how far we can stretch to the right
        //indexOfClosestBarOfLowerHeightBackward is how far we can stretch to the left
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
