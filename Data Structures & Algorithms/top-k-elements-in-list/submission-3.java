class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int x : nums){
            hm.merge(x, 1, Integer::sum);
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for(Map.Entry<Integer, Integer> e : hm.entrySet()){
            if(minHeap.size() < k){
                minHeap.offer(new int[] {e.getKey(), e.getValue()});
            }else{
                if(hm.get(minHeap.peek()[0]) < e.getValue()){
                    minHeap.poll();
                    minHeap.offer(new int[] {e.getKey(), e.getValue()});
                }
            }
        }

        int[] ans = new int[k];
        int i = 0;
        for(int[] x : minHeap){
            ans[i++] = x[0];
        }

        return ans;
    }
}
