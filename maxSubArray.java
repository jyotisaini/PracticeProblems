 /*

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:

Given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

For this problem, return the maximum sum.

*/

public static int maxSubArray(final List<Integer> a) {

        if(a.isEmpty() || a==null)
            return 0;

        int sum =0;

        int result =Integer.MIN_VALUE;
        for( int i =0; i<a.size(); i++)
        {
            sum+=a.get(i);
            result= Math.max(result, sum);

            if(sum<0){
                sum =0;
            }
        }
        return result;
    }
