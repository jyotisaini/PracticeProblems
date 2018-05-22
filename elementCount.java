Given a sorted array of integers, find the number of occurrences of a given target value.
Your algorithm’s runtime complexity must be in the order of O(log n).
If the target is not found in the array, return 0

 public int findCount(final List<Integer> a, int b) {

            if(a.isEmpty() || a ==null)
                return 0;

            int mid =0, high = a.size()-1, low =0;
            mid = (high-low)/2;
            if(a.get(mid)==b)
            {
                return 1+findCount(a.subList(low,mid),b)+ findCount(a.subList(mid+1, high+1),b);
            }
            else if(a.get(mid) > b)
                return findCount(a.subList(low, mid), b);
            return findCount(a.subList(mid+1, high+1), b);
        }
