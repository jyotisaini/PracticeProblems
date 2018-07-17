/*

Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]

*/

public ArrayList<ArrayList<Integer>> generate(int a) {
         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(a==0)
            return result;
       
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(1);
        result.add(b);

        for( int i =1; i<a; i++)
        {
            ArrayList<Integer> t = result.get(i-1);
            ArrayList<Integer> c = new ArrayList<Integer>();
            c.add(t.get(0));
            for( int j =1; j<t.size(); j++)
                c.add(t.get(j-1)+t.get(j));
            c.add(t.get(t.size()-1));
            result.add(c);
        }
        return result;
    }
