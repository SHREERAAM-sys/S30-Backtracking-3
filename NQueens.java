/**

 L.C: 51. N-Queens

 Approach: Forloop based recursion and backtracking

 Time Complexity: O(n!)
 Space Complexity: O(n*n)

 */

class NQueens {
    boolean[][] grid;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {

        if(n == 0) {
            return new ArrayList<>();
        }

        grid = new boolean[n][n];
        result = new ArrayList<>();

        backtrack(0);
        return result;

    }

    private void backtrack(int row){

        //base
        if(row == grid.length) {
            List<String> temp = new ArrayList<>();
            for(int i=0;i<grid.length; i++){
                StringBuffer sb = new StringBuffer();
                for(int j=0;j<grid[0].length; j++) {

                    if(grid[i][j] == true) {
                        sb.append('Q');
                    }
                    else {
                        sb.append('.');
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
        }

        //logic
        for(int col=0;col<grid[0].length; col++) {

            if(isSafe(row,col)) {
                //action
                grid[row][col] = true;

                //recurse
                backtrack(row+1);

                //backtrack
                grid[row][col] = false;

            }
        }
    }

    private boolean isSafe(int row, int col) {


        //check in upward direction

        for(int i=row-1; i>=0; i--) {

            if(grid[i][col] == true) {
                return false;
            }
        }

        //check left diagonally

        int i = row-1;
        int j = col-1;

        while(i >=0 && j>=0){
            if(grid[i][j] == true) {
                return false;
            }
            i--;
            j--;
        }

        i = row - 1;
        j = col+1;

        while(i>=0 && j<grid[0].length) {

            if(grid[i][j] == true) {
                return false;
            }

            i--;
            j++;
        }

        return true;
    }
}