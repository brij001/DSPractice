package arrays.Others;

import java.util.ArrayList;
import java.util.List;
import arrays.Others.*;

// https://www.geeksforgeeks.org/merging-intervals/
public class MergeIntervals {


     public ArrayList<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> output = new ArrayList<Interval>();

        int i = 0;
        int size = intervals.size();

        // Add all the points before we encounter the interval
        intervals.get(0);
        while (i < size && newInterval.start > intervals.get(i).end) {
            output.add(intervals.get(i));
            i++;
        }

        // For the overlapping ranges, compute the minimum start point and maximum end point of the range
        while (i < size && newInterval.end >= intervals.get(i).start) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        output.add(newInterval);

        // Add the points after we encounter the interval
        while (i < size) {
            output.add(intervals.get(i));
            i++;
        }
        return output;
    }

}


class Interval {
    public int start;
    public int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
