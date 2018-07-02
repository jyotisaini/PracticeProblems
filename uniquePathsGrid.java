/*

Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example :
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

 Note: m and n will be at most 100. 

*/

 public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
        if(a.isEmpty() || a==null)
            return 0;

        int m = a.size();
        int n = a.get(0).size();
        int [][] dp = new int [m][n];

        if(a.get(0).get(0)==1 ||a.get(m-1).get(n-1)==1)
            return 0;

        for ( int i =0; i<m; i++)
            for( int j=0; j<n; j++)
                dp[i][j]=0;

        for( int i=0; i<m ; i++)
        {
            if(a.get(i).get(0)==0)
                dp[i][0]= 1;
            else
                break;
        }


        for( int i=0; i<n ; i++)
        {
            if(a.get(0).get(i)==0)
                dp[0][i]= 1;
            else
                break;
        }

        for( int i =1; i<m ;i++)
        {
            for ( int j =1; j<n;j++)
            {
                if(a.get(i).get(j)==1)
                    continue;
                else
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
