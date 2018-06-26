/* 
Find shortest unique prefix to represent each word in the list.

Example:

Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}
where we can see that
zebra = z
dog = dog
duck = du
dove = dov
 NOTE : Assume that no word is prefix of another. In other words, the representation is always possible. 
*/


      class Trie {
         Trie[] children = new Trie[256];
         int frequency;

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
             }
         }
         String getSmallestPRefix(String key) {
            int level;
            int length = key.length();
            int index;
            Trie p = root;
            String str = "";
            for (level = 0; level < length; level++) {
                index = key.charAt(level);
                if (p.children[index].frequency != 1) {
                    str += key.charAt(level);
                    p = p.children[index];
                } else {
                    str += key.charAt(level);
                    break;
                }
            }
            return str;
        }
     };
     Trie root = new Trie();
     
    public ArrayList<String> prefix(ArrayList<String> a) {
            if (a == null || a.isEmpty())
                return null;

            ArrayList<String> result = new ArrayList<String>();

            Trie trie = new Trie();
            for (int i = 0; i < a.size(); i++) {
                trie.insert(a.get(i));

            }

            for (int i = 0; i < a.size(); i++) {
                result.add(trie.getSmallestPRefix(a.get(i)));
            }

            return result;
        }
