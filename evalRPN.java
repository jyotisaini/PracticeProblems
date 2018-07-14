/*

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
public int evalRPN(ArrayList<String> a)   {

        if(a.isEmpty() || a==null)
            return 0;

        int result =0;
        Stack<Integer> stack = new Stack<Integer>();

        for( int i =0; i<a.size(); i++)
        {
            if(a.get(i).compareTo("*")!=0 && a.get(i).compareTo("+")!=0 && 
                    a.get(i).compareTo("-")!=0&&a.get(i).compareTo("/")!=0 )
            {
                stack.push(Integer.parseInt(a.get(i)));
            }
            else
            {
                if(!stack.isEmpty())
                {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    result =calculate(op2, op1,a.get(i));
                    stack.push(result);

                }
            }
        }
        return stack.peek();
    }

    
    int calculate( int op1, int op2, String operator)
    {
        if(operator.compareTo("+")==0)
            return op1+op2;
        if(operator.compareTo("-")==0)
           return op1-op2;
        if(operator.compareTo("/")==0 && op2!=0)
            return op1/op2;
        return op1*op2;
    }
