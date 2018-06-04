/*  Given an input string, reverse the string word by word.

Example:

Given s = "the sky is blue",

return "blue is sky the".

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.

*/

	public String reverseWords(String a) {
                if(a.isEmpty() || a==null)
                    return  "";

                StringBuffer stringBuffer = new StringBuffer(a);
                stringBuffer.reverse();
                int i=0; 
                String retString="";
                while(i<stringBuffer.length())
                {
                    if(stringBuffer.charAt(i)==' '){
                        retString += stringBuffer.charAt(i); 
                        i++;
                    }
                    else
                    {
                        StringBuffer b = new StringBuffer();
                        while(i<stringBuffer.length() && stringBuffer.charAt(i)!=' ')
                        {
                            b.append(stringBuffer.charAt(i));
                            i++;
                        }
                        retString+=b.reverse();
                    }
                }
                return retString;
        }

