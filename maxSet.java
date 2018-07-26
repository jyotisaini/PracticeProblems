/*

Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:

A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]
NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index

*/

public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(a.isEmpty() || a==null)
            return result;
        int i=0;
        long maxSum=Integer.MIN_VALUE;
        int start=0;
        long sum =0;
        for(  i =0; i<a.size(); i++)
        {
            if(a.get(i)<0) {
                if(maxSum == sum)
                {
                    if(result.size()<i-start)
                    {
                        result.clear();
                        result = new ArrayList<Integer>(a.subList(start,i));
                    }
                }
                else if(maxSum < sum)
                {
                    result.clear();
                    result = new ArrayList<Integer>(a.subList(start,i));
                    maxSum = sum;
                }
                start =i+1;
                sum =0;
            }
            else
                sum+=a.get(i);
        }
        if(maxSum < sum)
        {
            result.clear();
            result = new ArrayList<Integer>(a.subList(start, i));
        }
        else if(maxSum == sum && result.size() < i-start)
            result = new ArrayList<Integer>(a.subList(start, i));

        return result;
    }
