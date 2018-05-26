/* Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

Note that even though we want you to return the new length, make sure to change the original array as well in place

Do not allocate extra space for another array, you must do this in place with constant memory.

*/

public int removeDuplicates(ArrayList<Integer> a) {
            if(a.isEmpty() || a ==null)
                return 0;
            int slow =0;
            int  i =0;
            while(i< a.size()-1)
            {
               if(a.get(i).equals(a.get(i+1))) {
                    i++;
                }
                else
                    a.set(++slow,  a.get(++i));

            }
            return slow+1;
        }
