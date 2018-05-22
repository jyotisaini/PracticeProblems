/* You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1) 
You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.

*/

 public int coverPoints(ArrayList<Integer>a, ArrayList<Integer> b) 
    {
            if(a.isEmpty() || b.isEmpty()|| a.size()==1 || b.size()==1)
                return 0;
            int result =0;
            int prevx=a.get(0);
            int prevy=b.get(0);
            for( int i =1; i<a.size(); i++)
            {
                result = result + Math.max(Math.abs(a.get(i)-prevx), Math.abs(b.get(i)-prevy));
                prevx = a.get(i);
                prevy = b.get(i);
            }
            return result;
        }
