class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left_prods = new int[nums.length];
        int[] right_prods = new int[nums.length];

        left_prods[0] = 1;
        for(int i = 1; i < nums.length; i++){
            left_prods[i] = left_prods[i-1] * nums[i-1];
        } 

        right_prods[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0; i--){
            right_prods[i] = right_prods[i+1] * nums[i+1];
        }

        int[] soln = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            soln[i] = left_prods[i] * right_prods[i];
        }
        return soln;
    }
}  
