class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] present = new boolean[10];

        //Check rows
        for(int i = 0; i < 9; i++){
            Arrays.fill(present, false);
            for(int j = 0; j < 9; j++){
                int num = board[i][j] - '0';
                if(num > 0 && num < 10){
                    if(present[num] == true)
                        return false;
                    else
                        present[num] = true;
                }
            }
        }

        //Check cols
        for(int i = 0; i < 9; i++){
            Arrays.fill(present, false);
            for(int j = 0; j < 9; j++){
                int num = board[j][i] - '0';
                if(num > 0 && num < 10){
                    if(present[num] == true)
                        return false;
                    else
                        present[num] = true;
                }
            }
        }

        //Check 3x3s
        int[][] middles = {
            {1,1},{1,4},{1,7},
            {4,1},{4,4},{4,7},
            {7,1},{7,4},{7,7}
        };
        int[][] neighbors = {
            {0,0},
            {0,1},{0,-1},{1,0},{-1,0},
            {1,1},{-1,-1},{-1,1},{1,-1}
        };

        for(int i = 0; i < middles.length; i ++){
            Arrays.fill(present, false);
            for(int j = 0; j < neighbors.length; j++){
                int x = middles[i][0] + neighbors[j][0];
                int y = middles[i][1] + neighbors[j][1];
                int num = board[x][y] - '0';
                if(num > 0 && num < 10){
                    if(present[num] == true)
                        return false;
                    else
                        present[num] = true;
                }
            }
        }

        return true;
        
    }
}
