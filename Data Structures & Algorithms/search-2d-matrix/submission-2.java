class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            
            int mid_x = mid/n;
            int mid_y = mid%n;


            if(matrix[mid_x][mid_y] == target){
                return true;
            }else if(matrix[mid_x][mid_y] > target){
                right = mid - 1;
            }else if(matrix[mid_x][mid_y] < target){
                left = mid + 1;
            }
        }

        return false;
    }
}
