	/* Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array will not contain duplicates.


*/

public int findMin(final List<Integer> a) {
            if( a.isEmpty() || a==null)
                return Integer.MIN_VALUE;

            int mid=0, low=0, high=a.size()-1;
            while( low <= high)
            {
                mid = low+(high-low)/2;
                if(mid >0 && a.get(mid) <= a.get(mid-1))
                    return a.get(mid);
                else if(a.get(mid) >= a.get(low) && a.get(high) < a.get(low))
                    low = mid+1;
                else
                    high = mid-1;
            }
            return a.get(low);
        }
