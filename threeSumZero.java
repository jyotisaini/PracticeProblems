/* Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
(-1, 0, 1)
(-1, -1, 2) 

*/

public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
                if(a.isEmpty() || a == null)
                    return null;
                Collections.sort(a);
                ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
                for( int i=0;i <a.size(); i++){
                    int start = i+1; int end = a.size()-1;
                    while(start< end)
                    {
                        ArrayList<Integer> result = new ArrayList<Integer>();
                        if(start!= end && a.get(start)+a.get(end)+a.get(i)==0)
                        {
                            result.add(a.get(i));
                            result.add(a.get(start));
                            result.add(a.get(end));
                            Collections.sort(result);
                            r.add(result);
                            start++;
                            end--;
                        }
                        else if(a.get(start)+a.get(end)+a.get(i)<0)
                            start++;
                        else end--;
                    }
                }
                return r;
        }
