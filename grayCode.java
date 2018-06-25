/*

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
There might be multiple gray code sequences possible for a given n.
Return any such sequence. */

public  ArrayList<Integer> grayCode(int a) {
        if(a==0)
            return null;
        ArrayList<String> intermediate = new ArrayList<String>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        intermediate.add("0");
        intermediate.add("1");
        if(a==1)
        {
            result.add(Integer.parseInt(intermediate.get(0),2));
            result.add(Integer.parseInt(intermediate.get(1),2));
            return result;
        }

        for( int i =1; i<a; i++)
        {
            for( int j=intermediate.size()-1; j>=0; j--)
            {
                intermediate.add(intermediate.get(j));
            }

            int j=0, k = intermediate.size()-1;
            while(j<k)
            {

                String sj = "0"+intermediate.get(j);
                String sk = "1"+ intermediate.get(k);
                intermediate.set(j, sj);
                intermediate.set(k, sk);
               j++;
               k--;
            }

           // System.out.println(intermediate);
        }

        for( int i =0; i<intermediate.size(); i++)
        {
            result.add(Integer.parseInt(intermediate.get(i),2));
        }
        return result;
    }
