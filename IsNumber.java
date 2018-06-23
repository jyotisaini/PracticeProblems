/* 

Validate if a given string is numeric.

Examples:

"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Return 0 / 1 ( 0 for false, 1 for true ) for this problem



*/

 public int isNumber(final String a) {
        String A = a.toLowerCase();
        if(A.charAt(A.length()-1) == '.')
            return 0;

        if(A.contains(".") ) {
            int index = A.indexOf('.');
            if(index <A.length()-1 && A.charAt(index+1)=='e')
                return 0;
        }
        try
        {
            Float.parseFloat(A);

        }
        catch (NumberFormatException e)
        {
            return 0;
        }
        return 1;
    }
