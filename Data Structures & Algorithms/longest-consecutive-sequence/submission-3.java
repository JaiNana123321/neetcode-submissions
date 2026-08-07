class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int x : nums) {
            hs.add(x);
        }

        List<Integer> possible_starts_of_seq = new ArrayList<>(nums.length);
        for(int x : hs){
            if(!hs.contains(x-1)){
                possible_starts_of_seq.add(x);
            }
        }

        int max_len = possible_starts_of_seq.size() > 0 ? 1 : 0;

        int len = 0;
        for(int candidate : possible_starts_of_seq){
            while(hs.contains(len + candidate)){
                len++;
            }
            if(len > max_len) max_len = len;
            len = 0;
        }

        return max_len;
        
    }
}
