/* 

Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]

*/

public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {

                if(a==null || b==null || a.isEmpty() || b.isEmpty())
                    return null;

                ArrayList<Integer> result = new ArrayList<Integer>();
                int first=0; int second=0;

             while(first < a.size()&& second < b.size())
                {
                    if(a.get(first).equals(b.get(second))) {
                        result.add(a.get(first));
                        first++; second++;
                    }
                    else if(a.get(first)>b.get(second))
                        second++;
                    else first++;
                }
                return result;
        }


