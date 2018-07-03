  /*

Given an array of integers, return the highest product possible by multiplying 3 numbers from the array

Input:

array of integers e.g {1, 2, 3}
 NOTE: Solution will fit in a 32-bit signed integer 
Example:

[0, -1, 3, 100, 70, 50]

=> 70*50*100 = 350000


*/

public static int maxp3(ArrayList<Integer> a) {
            if (a.isEmpty())
                return 0;
            if (a.size() < 3)
                return 0;

            if (a.size() == 3)
                return (a.get(0) * a.get(1) * a.get(2));

            Collections.sort(a);
            int prod1 = a.get(0) * a.get(1) * a.get(a.size() - 1);
            int prod2 = a.get(a.size() - 3) * a.get(a.size() - 2) * a.get(a.size() - 1);

            return Math.max(prod1, prod2);
        }
