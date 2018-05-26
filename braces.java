/* Write a program to validate if the input string has redundant braces?
Return 0/1

0 -> NO
1 -> YES
Input will be always a valid expression

and operators allowed are only + , * , - , /

Example:

((a + b)) has redundant braces so answer will be 1
(a + (a + b)) doesn't have have any redundant braces so answer will be 0


*/

public int braces(String a) {
            if(a.isEmpty() || a==null)
                return 0;
            Stack<Character> stack = new Stack<Character>() ;
            int i=0;
            while(i< a.length())
            {
                if(a.charAt(i)== '('||a.charAt(i)== '+'|| a.charAt(i)== '*'|| a.charAt(i)== '-'|| a.charAt(i)== '/') {
                    stack.push(a.charAt(i));
                    
                }
                else if(a.charAt(i)==')')
                {
                    if(stack.peek()=='(')
                        return 1;
                    else
                    {
                        while(!stack.isEmpty() && stack.peek()!='(' )
                            stack.pop();
                        stack.pop();
                    }
                }
                i++;

            }

            return 0;

        }
