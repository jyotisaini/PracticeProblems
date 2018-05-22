/* Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

*/

	public int repeatedNumber(final List<Integer> a) {
            if (a.isEmpty())
                return -1;
            int i = 0;
            HashMap<Integer, Boolean> integerBooleanHashMap = new HashMap<Integer, Boolean>();
            for (i = 0; i < a.size(); i++) {
                if (integerBooleanHashMap.get(a.get(i)) == null)
                    integerBooleanHashMap.put(a.get(i), true);
                else
                    break;


            }
            if (i == a.size())
                return -1;
            return a.get(i);
        }
