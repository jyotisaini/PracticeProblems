/*

There are N coins (Assume N is even) in a line. Two players take turns to take a coin from one of the ends of the line until there are no more coins left. The player with the larger amount of money wins. Assume that you go first.

Write a program which computes the maximum amount of money you can win.

Example:

suppose that there are 4 coins which have value
1 2 3 4
now you are first so you pick 4
then in next term
next person picks 3 then
you pick 2 and
then next person picks 1
so total of your money is 4 + 2 = 6
next/opposite person will get 1 + 3 = 4
so maximum amount of value you can get is 6
*/

   private int[][] memo;
   public int maxcoin(ArrayList<Integer> a) {
            int size = a.size();
            memo = new int[size][size];
            for (int i = 0; i < memo.length; i++) {
                for (int j = 0; j < memo.length; j++) {
                    memo[i][j] = -1;
                }
            }
            return maxcoinHelper(0, size - 1, a);
        }

        private int maxcoinHelper(int start, int end, ArrayList<Integer> a) {
            if (start > end) {
                return 0;
            } else if (start == end) {
                return a.get(start);
            } else if (memo[start][end] != -1) {
                return memo[start][end];
            }

            int min1 = a.get(start) + Math.min(maxcoinHelper(start + 2, end, a), maxcoinHelper(start + 1, end - 1, a));
            int min2 = a.get(end) + Math.min(maxcoinHelper(start + 1, end - 1, a), maxcoinHelper(start, end - 2, a));
            int max = Math.max(min1, min2);
            memo[start][end] = max;
            return max;
        }
