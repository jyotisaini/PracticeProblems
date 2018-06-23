 /*

You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

Note:

If K > N, return empty array.
For example,

A=[1, 2, 1, 3, 4, 3] and K = 3

All windows of size K are

[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]

So, we return an array [2, 3, 3, 2].

*/

public static ArrayList<Integer> dNums(ArrayList<Integer> a, int b) {
        if(a==null || a.isEmpty() || b==0)
            return null;
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(a.size()< b)
            return result;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int i=0;
        for(  i= 0; i<b; i++)
        {
            if(!hashMap.containsKey(a.get(i)))
                hashMap.put(a.get(i), 1);
            else
                hashMap.put(a.get(i), hashMap.get(a.get(i))+1);
        }
        result.add(hashMap.size());
        if(i==a.size())
            return result;

        for( int j=i; j<a.size(); j++)
        {
            if(hashMap.get(a.get(j-b))==1)
                hashMap.remove(a.get(j-b));
            else
                hashMap.put(a.get(j-b), hashMap.get(a.get(j-b))-1);

            if(!hashMap.containsKey(a.get(j)))
                hashMap.put(a.get(j), 1);
            else
                hashMap.put(a.get(j), hashMap.get(a.get(j))+1);

            result.add(hashMap.size());
        }
        return result;
    }
