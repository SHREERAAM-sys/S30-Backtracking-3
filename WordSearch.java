/*

    L.C: 79.Word Search

    Approach: DFS and backtracking

    Working:
        iterate through the matrix and find the starting character in string word
            if backtrack(matrix, index -> 0 startign index, row, col) is true
                return true;
        return false;

        backtrack(matrix, index, row, col) {

            //base
            chaek if index id equal to word lenght
                return true;
            check for row/col index bounds
                return false;

            //logic
            check if matrix[row][col] char is equal to char at word index

                store the current char in temp - used in backtracking step
                //action
                set the curent row,col value in matrix to #

                //recurse
                recures in all 4 directions UDLR
                    if(backtrack(matrix, index+1 -> moving to next index in word, newRow, newCol) -> true) {
                        return true;
                    }

                //backtrack - undo the action
                set the curent row,col value in matrix to temp - the original value

            return false

        }


    Time Complexity: 2^N (exponential)
    Space Complexity: O(len(word)) - the max number of entries in the stack for a particular point
 */

class WordSearch {

    int[][] directions = {
            {-1, 0}, //U
            {1, 0}, //D
            {0, -1}, //L
            {0, 1} //R
    };
    public boolean exist(char[][] board, String word) {

        if(board == null || board.length == 0 ){
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m; i++){
            for(int j=0; j<n; j++){

                char c = board[i][j];
                if(c == word.charAt(0)) {
                    if(backtrack(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int row, int col) {

        //base
        if(index == word.length()) {
            return true;
        }

        if(row<0 || row == board.length || col<0 || col == board[0].length || board[row][col] == '#') {
            return false;
        }

        //logic
        if(board[row][col] == word.charAt(index)) {

            //action
            char temp = board[row][col];
            board[row][col] = '#';

            //recurse
            for(int[] dir : directions) {

                int nr = row+dir[0];
                int nc = col+dir[1];

                if(backtrack(board, word, index+1, nr, nc)) {
                    return true;
                }
            }

            //backtrack
            board[row][col] = temp;
        }

        return false;
    }
}
