/*

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Read more details about roman numerals at Roman Numeric System

Example :

Input : "XIV"
Return : 14
Input : "XX"
Output : 20

*/
   public int romanToInt(String a) {
        if(a==null || a.length()==0 || a.isEmpty())
            return 0;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
        int sign =1;
        int ret =0;
        StringBuffer b = new StringBuffer(a);
        b.reverse();
        for( int i=0; i<b.length()-1; i++)
        {
            ret=ret+sign*hashMap.get(b.charAt(i));
            if(hashMap.get(b.charAt(i+1)) < hashMap.get(b.charAt(i)))
                    sign=-1;
            else
                sign=1;
        }
        ret+=sign*hashMap.get(b.charAt(b.length()-1));
        return ret;

    }
