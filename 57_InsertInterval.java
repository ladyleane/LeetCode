//Greedy
class Solution{
	public int[][] insert(int[][] intervals, int[] newInterval){
		// Init data
		int newStart = newInterval[0], newEnd = newInterval[1];
		int idx = 0, n = intervals.length;
		LinkedList<int[]> output = new LinkedList<int[]>();

		// Add all intervals starting befor newInterval
		while (idx < n && newStart > intervals[idx][0])
			output.add(intervals[idx++]);

		// Add newInterval
		int[] interval = new int[2];

		// If there is no overlap, just add the interval
		if (output.isEmpty() || output.getLast()[1] < newStart)
			output.add(newInterval);

		// If there is an overlap, merge with the last interval
		else{
			interval = output.removeLast();
			interval[1] = Math.max(interval[1], newEnd);
			output.add(interval);
		}

		// Add next intervals, merge with newInterval if needed
		while (idx < n){
			interval = intervals[idx++];
			int start = interval[0], end = interval[1];

			// If there is no overlap, just add an intervalsList
			if (output.getLast()[1] < start) output.add(interval);
			// If there is an overlap, merge with the last interval
			else{
				interval = output.removeLast();
				interval[1] = Math.max(interval[1], end);
				output.add(interval);
			}
		}
		return output.toArray(new int[output.size()][2]);
	}
}
