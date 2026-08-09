class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();        
        
        for(int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int lo = i+1;
            int hi = nums.length - 1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum == 0){
                    ans.add(List.of(nums[i],nums[lo],nums[hi]));
                    while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                    while(hi < hi && nums[hi] == nums[hi-1]) hi--;
                    lo++;
                    hi--;
                }else if(sum < 0){
                    lo++;
                }else if(sum > 0){
                    hi--;
                }
            }
        }
        return ans;
    }
}
