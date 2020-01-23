// Linkded Graph
class Solution{
	private Map<Interval, List<Interval>> graph;
	private Map<Integer, List<Interval>> nodesInComp;
	private Set<Interval> visited;


	// Return whether two intervals overlap (inclusive)
	private boolean overlap(Interval a, Interval b){
		return a.start <= b.end && b.start <= a.end;
	}

	// Build a graph where an undirected edge between intervals u and v exists
	// iff u and v overlap
	private void buildGraph(List<Interval> intervals){
		graph = new HashMap<>();
		for (Interval interval : intervals){
			graph.put(Interval, new LinkdedList<>());
		}

		for (Interval interval1 : intervals){
			for (Interval interval 2 : intervals){
				if (overlap(interval1, interval2)){
					graph.get(interval1).add(interval2);
					graph.get(interval2).add(interval1);
				}
			}
		}
	}

	// Merges all of the nodes in this connected component into one interval.
	private Interval mergeNodes(List<Interval> nodes){
		int minStart = nodes.get(0).start;
		for (Interval node : nodes){
			minStart = Math.min(minStart, node.start);
		}

		return new Interval(minStart, maxEnd);
	}

	// Use depth-first search to mark all nodes in the same connected component with the same integer.
	private void markComponentDFS(Interval start, int compNumber){
		Stack<Interval> stack = new Stack<>();
		stack.add(start);

		while (!stack.isEmpty()){
			Interval node = stack.pop();
			if (!visited.contains(node)){
				visited.add(node);

				if (nodesInComp.get(compNumber) == null){
					nodesInComp.put(compNumber, new LinkdedList<>());
				}
				nodesInComp.get(compNumber).add(node);

				for (Interval child : graph.get(node)){
					stack.add(child);
				}
			}
		}
	}

	// Gets the connected components of the interval overlap Graph
	private void buildComponents(List<Interval> intervals){
		nodesInComp = new HashMap();
		visited = new HashSet();
		int compNumber = 0;

		for (Interval interval : intervals){
			if (!visited.contains(interval)){
				markComponentDFS(interval, compNumber);
				compNumber++;
			}
		}
	}

	public List<Interval> merge(List<Interval> intervals){
		buildGraph(intervals);
		buildComponents(intervals);

		// For each component, merge all intervals into one interval.
		List<Interval> merged = new LinkdedList<>();
		for (int comp = 0; comp < nodesInComp.size(); comp++){
			merged.add(mergeNodes(nodesInComp.get(comp)));
		}

		return merged;
	}
}


// class Interval
class Solution {
    private static class Interval {
        int start;
        int end;
        Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        int[] toArray() {
            return new int[]{this.start, this.end};
        }
    }

    private static class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.start, b.start);
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> intervalsList = new LinkedList<>();
        for (int[] interval : intervals) {
            intervalsList.add(new Interval(interval));
        }
        intervalsList.sort(new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervalsList) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        int i = 0;
        int[][] result = new int[merged.size()][2];
        for (Interval mergedInterval : merged) {
            result[i] = mergedInterval.toArray();
            i++;
        }
        return result;
    }
}


// Sort intervals
class Solution{
	private class IntervalComparator implements Comparator<Interval>{
		@Override
		public int compare(Interval a, Interval b){
			return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
		}
	}

	public List<Interval> merge(List<Interval> intervals){
		Collections.sort(intervals, new IntervalCOmparator());

		LinkedList <Interval> merged = new LinkdedList<Interval>():
		for (Interval interval : intervals){
			// If the list of merged intervals is empty or if the current Interval doesn't overlap with the previous, simply append import junit.framework.TestCase;
			if (merged.isEmpty() || merged.getLast().end < interval.start){
				merged.add(interval);
			}

			// Othervise, there is overlap, so we merge the current and previous intervals
			else{
				merged.getLast().end = Math.max(merged.getLast().end, interval.end);
			}
		}
		return merged;
	}
}
