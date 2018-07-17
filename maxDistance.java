/*

Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

Example :

A : [3 5 4 2]

Output : 2 
for the pair (3, 4)

*/

public int maximumGap(final List<Integer> a) {
        if(a.isEmpty() || a==null)
            return 0;

        int result = Integer.MIN_VALUE;
        int [] lmin = new int[a.size()];
        int [] rmax = new int[a.size()];
        lmin[0]= a.get(0);
        for( int i =1; i<a.size(); i++)
            lmin[i] =Math.min(lmin[i-1],a.get(i));

        rmax[a.size()-1]= a.get(a.size()-1);
        for( int i =a.size()-2; i>=0; i--)
            rmax[i] =Math.max(rmax[i+1],a.get(i));
        int  i=0; int j =0;
        while(i<a.size() && j<a.size())
        {
            if(lmin[i]<=rmax[j]) {
                result = Math.max(result, j - i);
                j++;
            }
            else
                i++;

        }
        return  result;
    }
