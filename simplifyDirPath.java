/*

Given an absolute path for a file (Unix-style), simplify it.

Examples:

path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Note that absolute path always begin with ‘/’ ( root directory )
Path will not have whitespace characte

*/

public String simplifyPath(String a) {
        if(a.isEmpty() || a ==null || a== "")
            return a;

        String[] path = a.split("/");
        String st= "";
        Stack<String> stack = new Stack<String>();
        int i=0;
        while( i<path.length)
        {

            if(path[i].compareTo("/")==0 || path[i].compareTo(".")==0  || path[i].isEmpty()) {
                i++;
                continue;
            }
            if(path[i].compareTo("..")!=0) {
                stack.push(path[i]);
                i++;
            }
            else
            {
               if(!stack.isEmpty()) 
               stack.pop();
                i++;
            }

        }

        while(!stack.isEmpty())
        {
            st = "/"+ stack.pop()+st;
        }
        
        if(st=="")
            st = "/";
        return st;

    }
