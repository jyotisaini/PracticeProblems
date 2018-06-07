  /*

Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.

*/

public int diffPossible(final List<Integer> a, int b) {
        if(a.isEmpty() || a==null)
            return 0;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for( int i =0; i< a.size();i++)
        {
            if(hashMap.containsKey(a.get(i)-b) || hashMap.containsKey(b+a.get(i)))
                return 1;
            if(!hashMap.containsKey(a.get(i)))
                hashMap.put(a.get(i),i);
        }
        return 0;
    }


