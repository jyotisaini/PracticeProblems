/* Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.



*/

public int lengthOfLastWord(final String a) {
                if(a.isEmpty() || a==null)
                    return 0;
                String b = a.trim();
                int i=0;
                int length=0;
                while(i< b.length())
                {
                    if(b.charAt(i)==' ')
                    {
                      length=0;
                    }
                    else 
                        length++;
                    i++;
                }
                return length;
        }
