/*
Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Example :

Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output : 4

*/

public int singleNumber(final List<Integer> a) {
                if(a.isEmpty() || a==null)
                    return 0;
                int result=0;
                double num =0;
                for( int i =0; i<32; i++)
                {
                    result=0;
                    for( int j=0; j<a.size(); j++)
                    {
                        if((a.get(j)&1<<i)!=0)
                        {
                            result++;
                        }
                    }
                    num = (int) num+ (result%3)*Math.pow(2,i);
                }
                return (int)num;
        }

