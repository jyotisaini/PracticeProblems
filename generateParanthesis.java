/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.


*/

public ArrayList<String> generateParenthesis(int a) {
        if(a==0)
            return  null;

        ArrayList<String> result = new ArrayList<String>();
        generateParenthesisHelper(a,result, "", 0,0);
        return result;
    }
   void  generateParenthesisHelper(int a, ArrayList<String> result, String b, int open , int close) {
       if(open == a&& close==a)
           result.add(b);
       if(open < a) {
           generateParenthesisHelper(a,result,b+"(",open+1, close);
       }
       if(close <open) {
            generateParenthesisHelper(a, result, b+")", open, close+1);
       }

   }
