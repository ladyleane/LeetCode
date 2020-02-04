class Solution{
	List<List<Integer>> output = new LinkedList();
	int n, k;

	public void backtrack(int first, LinkedList<Integer> curr){
		if (curr.size() == k)
			output.add(new LinkedList(curr));

		for (int i = first; i < n + 1; ++i){
			curr.add(i);
			backtrack(i + 1, curr);
			curr.removeLast();
		}
	}

	public List<List<Integer>> combine(int n, int k){
		this.n = n;
		this.k = k;
		backtrack(1, new LinkedList<Integer>());
		return output;
	}
}



//Dict Order
class Solution {
  public List<List<Integer>> combine(int n, int k) {
    // init first combination
    LinkedList<Integer> nums = new LinkedList<Integer>();
    for(int i = 1; i < k + 1; ++i)
      nums.add(i);
    nums.add(n + 1);

    List<List<Integer>> output = new ArrayList<List<Integer>>();
    int j = 0;
    while (j < k) {
      // add current combination
      output.add(new LinkedList(nums.subList(0, k)));
      // increase first nums[j] by one
      // if nums[j] + 1 != nums[j + 1]
      j = 0;
      while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
        nums.set(j, j++ + 1);
      nums.set(j, nums.get(j) + 1);
    }
    return output;
  }
}
