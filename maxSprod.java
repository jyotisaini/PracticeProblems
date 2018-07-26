/*
You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:<ul>

LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (i>j). If multiple A[j]’s are present in multiple positions, the LeftSpecialValue is the maximum value of j. 

RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (j>i). If multiple A[j]s are present in multiple positions, the RightSpecialValue is the minimum value of j.

Write a program to find the maximum special product of any integer in the array.

Input: You will receive array of integers as argument to function.

Return: Maximum special product of any integer in the array modulo 1000000007.

Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are considered to be 0.

Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9
*/

public int maxSpecialProduct(ArrayList<Integer> a) {
        if(a.isEmpty() || a==null)
            return 0;
        long maxProd =0;
        Stack<Integer> leftStack = new Stack<Integer>();
        int[] left = new int[a.size()];
        int [] right = new int[a.size()];
        left[0]=0;
        leftStack.push(0);
        for( int i=1; i<a.size(); i++)
        {
            while(!leftStack.isEmpty()&& a.get(leftStack.peek()) <= a.get(i))
                leftStack.pop();
            if(leftStack.empty())
                left[i]=0;
            else left[i]= leftStack.peek();
            leftStack.push(i);
        }

        Stack<Integer> rightStack =  new Stack<Integer>() ;
        right[a.size()-1]=0;
        rightStack.push(a.size()-1);
        for( int i=a.size()-2; i>=0; i--)
        {
           while(!rightStack.empty() && a.get(rightStack.peek())<= a.get(i))
               rightStack.pop();
           if(rightStack.empty())
               right[i]=0;
           else
               right[i]= rightStack.peek();
           rightStack.push(i);
        }

        for( int i=0; i<a.size(); i++)
        {
           long prod = (left[i]*right[i])%1000000007;
           maxProd = Math.max(maxProd, prod)%1000000007;
        }
        return (int)maxProd%1000000007;
    }
