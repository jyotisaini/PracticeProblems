   /*

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P.......A........H.......N
..A..P....L....S....I...I....G
....Y.........I........R
And then read line by line: PAHNAPLSIIGYIR
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
**Example 2 : **
ABCD, 2 can be written as

A....C
...B....D
and hence the answer would be ACBD.

*/

public static String convert(String a, int b) {
        if(b==1)
            return a;
        if(b>a.length())
            return a;
        String returnString ="";
        int i=0;
        int distance = 2*(b-1);
        while(i<a.length())
        {
            returnString+=a.charAt(i);
            i+=distance;
        }
        distance-=2;
         i=1;
        while(i<b-1)
        {
           int j=i;
            while(j<a.length()) {
                returnString += a.charAt(j);
                j += distance;
                if(j<a.length())
                returnString += a.charAt(j);
                j += 2*i;
            }
            i++;
            distance-=2;
        }

        i=b-1;
        distance = 2*(b-1);
        while(i<a.length())
        {
            returnString+=a.charAt(i);
            i+=distance;
        }
        return returnString;
    }


