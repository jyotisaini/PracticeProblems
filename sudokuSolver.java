/*

Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.' 
You may assume that there will be only one unique solution.



A sudoku puzzle,



and its solution numbers marked in red.

Example :

For the above given diagrams, the corresponding input to your program will be

[[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
and we would expect your program to modify the above array of array of characters to

[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]

*/



     public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        if (a.isEmpty() || a == null)
            return;
        solveSudokuHelper(a);
    }

    boolean solveSudokuHelper(ArrayList<ArrayList<Character>> a)
    {
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                if (a.get(i).get(j) == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (notInrow(a, i, k) && notInColumn(a, j, k) && notInDiagonal(a, i, j, k)) {
                            ArrayList<Character> p = a.get(i);
                            p.set(j, k);
                            a.set(i, p);
                          if(!solveSudokuHelper(a))
                          {
                              p = a.get(i);
                              p.set(j, '.');
                              a.set(i, p);
                          }
                          else return true;
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }


    boolean notInrow(ArrayList<ArrayList<Character>> a,int row, char k){
        for( int i =0;i <9; i++)
            if(a.get(row).get(i) !='.' && a.get(row).get(i) ==k)
                return false;
        return true;
    }


    boolean notInColumn(ArrayList<ArrayList<Character>> a, int col, char k){
        for( int i =0;i <9; i++)
            if(a.get(i).get(col)!='.' && a.get(i).get(col) ==k)
                return false;
        return true;
    }

    boolean notInDiagonal(ArrayList<ArrayList<Character>> a, int row, int col, char k){

            for( int i =0; i<9; i++)
                if(a.get(3 * (row / 3) + i / 3).get( 3 * (col / 3) + i % 3)!= '.' && a.get(3 * (row / 3) + i / 3).get( 3 * (col / 3) + i % 3)==k)
                    return false;

        return true;
    }

