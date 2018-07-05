/*

Given an array of integers, find the length of longest subsequence which is first increasing then decreasing.

**Example: **

For the given array [1 11 2 10 4 5 2 1]

Longest subsequence is [1 2 10 4 2 1]

Return value 6
*/

public int longestSubsequenceLength(final List<Integer> a) {
        if(a.isEmpty() || a==null)
            return 0;
        int [] lis = new int [a.size()];
        int [] lds =new int[a.size()];
        for( int i =0; i<a.size() ;i++)
        { 
            lis[i]=1;
            lds[i]=1;
        }
        for( int i =1; i<a.size(); i++)
        {
            for( int j =0; j<i; j++)
            {
                if(a.get(j)<a.get(i) && lis[i] <lis[j]+1)
                    lis[i]= lis[j]+1;
            }
        }
        for (int i = a.size() - 2; i >= 0; i--) {
            for (int j = a.size() - 1; j > i; j--) {
                if (a.get(j) < a.get(i) && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;
            }
        }

        int maxLen = Integer.MIN_VALUE;


        for (int i = 0; i < a.size(); i++) {
            int currLen = lis[i] + lds[i];
            if (currLen > maxLen)
                maxLen = currLen;
        }

        return maxLen - 1;
    
