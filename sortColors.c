/*Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.


*/

public void sortColors(ArrayList<Integer> a) {
            if(a.isEmpty() || a ==null )
                return;
            int low =0, i =0, high=a.size()-1;
            while(i< high)
            {
                if(a.get(i)==0){
                    int temp = a.get(i);
                    a.set(i,a.get(low) );
                    a.set(low, temp);
                    low++;
                }
                else if(a.get(i)==2)
                {
                    int temp = a.get(high);
                    a.set(high,a.get(i) );
                    a.set(i, temp);
                    high--;
                }
                else i++;
            }
        }
