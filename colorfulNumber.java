/* For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1

*/

public int colorful(int a) {
                if(a==0)
                    return 1;
               // a=99;
                HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
                ArrayList<Integer> list = new ArrayList<Integer>();

                while(a!=0)
                {
                  //  System.out.println(a);
                    list.add(a%10);
                    a = a/10;
                }


                for( int i =0; i<list.size(); i++) {
                    if(hashMap.containsKey(list.get(i)))
                        return 0;
                    hashMap.put(list.get(i), 1);
                }

                for( int i =0 ;i < list.size(); i++) {
                    int product = list.get(i);
                    for (int j = i+1 ; j < list.size(); j++) {
                        if (hashMap.containsKey(product*list.get(j)))
                            return 0;
                        else {
                            product = product*list.get(j);
                            hashMap.put(product,1);
                        }

                    }
                }
         return 1;
        }
