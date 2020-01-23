class Solution{
	public String getPermutation(int n, int k){
		boolean[] visited = new boolean[n];
		// Sort n! permutations into n groups, each contains (n - 1)! permutations

		return recursive(n, factorial(n - 1), k, visited);
	}

	// @param n Left digit number, --
	// @param f number of permutaions in each groups

	private String recursive(int n, int f, int k, boolean[] visited){
		int offset = k % f; // Shift in group
		int groupIndex = k / f + (offset > 0 ? 1 : 0); // Group
		// Find groupIndex in unvisited numbers
		int i = 0;
		for (; i < visited.length && groupIndex > 0; i++){
			if (!visited[i]){
				groupIndex--;
			}
		}
		visited[i - 1] = true;
		if (n - 1 > 0){
			// When offset = 0, select Group i Permutaion f, otherwise select Group i Permutation offset
			return String.valueOf(i) + recursive(n - 1, f / (n - 1), offset == 0 ? f : offset, visited);
		}else{
			return String.valueOf(i);
		}
	}

	// Find n!
	private int factorial(int n){
		int res = 1;
		for (int i = n; i > 1; i--){
			res *= i;
		}
		return res;
	}
}
