class Solution {

    double bestCaseTimeRemaining(int target, int[] car){
        int distanceRemaining = target - car[0];
        return (double) distanceRemaining/car[1];
    }

    //Will X catchup to Y assuming Y is ahead of X
    boolean willCatchup(int target, int[] carX, int[] carY){
        return  bestCaseTimeRemaining(target, carX) <= bestCaseTimeRemaining(target, carY);
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(a[0],b[0]));
        
        int fleets = n;
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && willCatchup(target, stack.peek(), cars[i])){
                stack.pop();
                fleets--;
            }
            stack.push(cars[i]);
        }

        return fleets;
    }
}
