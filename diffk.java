/* Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

 Example: Input : 
    A : [1 3 5] 
    k : 4
 Output : YES as 5 - 1 = 4 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Try doing this in less than linear space complexity.

*/

 public int diffPossible(ArrayList<Integer> a, int b) {
            int size = a.size();
            int i = 0, j = 1;
            while (i < size && j < size) {
                if (i != j && a.get(j) - a.get(i) == b) {
                    return 1;
                } else if (a.get(j) - a.get(i) < b)
                    j++;
                else
                    i++;
            }

            return 0;
        }
