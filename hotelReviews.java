/*
Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first). We define the “Goodness Value” of a string as the number of “Good Words” in that string.

Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.

 You are expected to use Trie in an Interview for such problems 

Constraints:

1.   1 <= No.of reviews <= 200
2.   1 <= No. of words in a review <= 1000
3.   1 <= Length of an individual review <= 10,000
4.   1 <= Number of Good Words <= 10,000
5.   1 <= Length of an individual Good Word <= 4
6.   All the alphabets are lower case (a - z)
Input:

S : A string S containing "Good Words" separated by  "_" character. (See example below)
R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
Output:

A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews. 

V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
Example:

Input: 
S = "cool_ice_wifi"
R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]

Output:
ans = [2, 0, 1]
Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]
*/

public ArrayList<Integer> solve(String a, ArrayList<String> b) {
        if(a.isEmpty() || a==null ||b.isEmpty() || b ==null)
            return null;

        ArrayList<rank> result = new ArrayList<rank>();
        Trie  root = new Trie();
        String [] good = a.split("_");
        for( int i =0; i<good.length; i++)
            root.insert(good[i]);

        for( int i =0; i<b.size(); i++)
        {
            int ret =0;
            String [] word = b.get(i).split("_");
            for( int j =0; j<word.length; j++)
            {
                if(root.DoesExists(word[j]))
                    ret++;
            }
            rank rank = new rank(ret,i);
            result.add(rank);

        }
        Collections.sort(result, new Comparator<rank>() {
            @Override
            public int compare(rank o1, rank o2) {
                Integer r1 = o1.rank;
                Integer r2= o2.rank;
                return r2.compareTo(r1);
            }
        });
        ArrayList<Integer> res = new ArrayList<Integer>();
        for( int i =0; i<result.size(); i++)
            res.add(result.get(i).index);

        return res;
    }
    
      class rank {
        int rank;
        int index;
        rank(int r, int i)
        {
            rank=r;
            index=i;
        }
     }

     class Trie {
        Trie[] children = new Trie[256];
        int frequency;
        Boolean isWord = false;

        Trie() {
            frequency = 1;
            for (int i = 0; i < 256; i++)
                children[i] = null;
        }

        void insert(String key) {
            int level;
            int length = key.length();
            int index;

            Trie p = root;
            for (level = 0; level < length; level++) {
                index = key.charAt(level);
                if (p.children[index] == null) {
                    p.children[index] = new Trie();
                } else
                    p.children[index].frequency = p.children[index].frequency + 1;
                p = p.children[index];
                if(level==length-1)
                    p.isWord = true;
            }
        }

        Boolean DoesExists(String key)
        {

            int level;
            int length = key.length();
            int index;

            Trie p = root;
            for (level = 0; level < length; level++) {
                index = key.charAt(level);
                if (p.children[index] != null) {
                    p = p.children[index];
                }
                else
                    return false;
            }
            if(p.isWord)
                return true;
            return false;

        }

    };

        Trie root = new Trie();
