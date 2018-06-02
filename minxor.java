/* Given an array of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

Examples : 
Input 
0 2 5 7 
Output 
2 (0 XOR 2) 
Input 
0 4 7 9 
Output 
3 (4 XOR 7)

Constraints: 
2 <= N <= 100 000 
0 <= A[i] <= 1 000 000 000

*/
 public int findMinXor(ArrayList<Integer> a) {
            if (a.isEmpty())
                return 0;
            Collections.sort(a);

            int minXor = Integer.MAX_VALUE;
            int val = 0;
            for (int i = 0; i < a.size() - 1; i++) {
                val = a.get(i) ^ a.get(i + 1);
                minXor = minXor < val ? minXor : val;
            }

            return minXor;
        }
