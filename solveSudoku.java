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
                            p.set(j, Character.forDigit(k, 1));
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
        for( int i =1;i <10; i++)
            if(a.get(row).get(i) !='.' && a.get(row).get(i) ==k)
                return false;
        return true;
    }


    boolean notInColumn(ArrayList<ArrayList<Character>> a, int col, char k){
        for( int i =1;i <10; i++)
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

