/* Given an array of integers, sort the array into a wave like array and return it, 
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

*/

 public ArrayList<Integer> wave(ArrayList<Integer> a) {
            if(a.isEmpty())
                return a;
            
            Collections.sort(a);
            
            for(int i=0; i< a.size() && i+1< a.size(); i+=2)
            {
                int temp = a.get(i);
                a.set(i, a.get(i+1));
                a.set(i+1, temp);
            }
            return a;
        }
