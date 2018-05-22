/*Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.
*/

 public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {  
        ArrayList<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.end < newInterval.start) {
        
                result.add(interval);
            } else if (newInterval.end < interval.start) {
              
                result.add(newInterval);
                result.addAll(intervals.subList(i, intervals.size()));
                return result;
            } else {
                int start = Math.min(newInterval.start, interval.start);
                int end = Math.max(newInterval.end, interval.end);
                newInterval.start = start;
                newInterval.end = end;
            }
        }
        result.add(newInterval);
        return result;
    }
