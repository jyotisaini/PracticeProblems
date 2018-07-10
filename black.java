/*
Given N * M field of O's and X's, where O=white, X=black
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Example:

OOOXOOO
OOXXOXO
OXOOOXO

answer is 3 shapes are  :
(i)    X
     X X
(ii)
      X
 (iii)
      X
      X
Note that we are looking for connected shapes here.

For example,

XXX
XXX
XXX
is just one single connected black shape.

*/

public int black(ArrayList<String> a) {
    int len=0;
        if(a.isEmpty() || a==null)
            return 0;
        visited = new int[a.size()][a.get(0).length()];
        for( int i =0; i<a.size(); i++)
        {
            for( int j =0; j<a.get(i).length() ;j ++)
                visited[i][j] =0;
        }

        for( int i =0; i<a.size(); i++)
            for( int j =0; j<a.get(i).length(); j++)
            {
                if(visited[i][j]!=1 && a.get(i).charAt(j)=='X') {
                    blackHelper(a, i, j);
                    len++;
                }
               
            }
            return len;
    }

   void  blackHelper(ArrayList<String> a,int i,int j) {
        if(i>a.size() || i<0|| j>a.get(i).length() || j<0 || visited[i][j]==1 || a.get(i).charAt(j)=='O')
            return;
        visited[i][j] =1;
       blackHelper(a,i-1,j);
       blackHelper(a,i+1,j);
       blackHelper(a,i,j-1);
       blackHelper(a,i,1);

   }
