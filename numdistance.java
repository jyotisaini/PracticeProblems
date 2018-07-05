 /*

Given two sequences S, T, count number of unique ways in sequence S, to form a subsequence that is identical to the sequence T.

 Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none ) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not). 
Example :

S = "rabbbit" 
T = "rabbit"
Return 3. And the formations as follows:

S1= "ra_bbit" 
S2= "rab_bit" 
S3="rabb_it"
"_" marks the removed character.

*/

public int numDistinct(String a, String b) {
        if(a.isEmpty() || a==null || b.isEmpty() || b==null || a.compareTo(b)==0 || b.length() > a.length())
            return 0;
        int [][] dp = new int [a.length()+1][b.length()+1];

        for( int i =0; i<=a.length();i++)
            for( int j =0; j<=b.length();j++)
                dp[i][j]=0;

        for( int i =0; i<=a.length() ;i++)
            dp[i][0]=1;
        
        for( int i =1; i<=a.length(); i++)
            for( int j =1; j<=b.length(); j++)
            {
                if(a.charAt(i-1)==b.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];

            }
            return dp[a.length()][b.length()];
    }
