public List<List<Integer>> subsetsWithDup(int[] nums){
	List<List<Integer>> ans = new ArrayList<>();
	Arrays.sort(nums);
	getAns(nums, 0, new ArrayList<>(), ans);
	return ans;
}

private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans){
	ans.add(new ArrayList<>(temp));
	for (int i = start; i < nums.length; i++){
		if (i > start && nums[i] == nums[i - 1]){
			continue;
		}
		temp.add(nums[i]);
		getAns(nums, i + 1, temp, ans);
		temp.remove(temp.size() - 1);
	}
}


//
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    ans.add(new ArrayList<>());
    Arrays.sort(nums);
    int start = 1;
    for (int i = 0; i < nums.length; i++) {
        List<List<Integer>> ans_tmp = new ArrayList<>();

        for (int j = 0; j < ans.size(); j++) {
            List<Integer> list = ans.get(j);

            if (i > 0 && nums[i] == nums[i - 1] && j < start) {
                continue;
            }
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(nums[i]);
            ans_tmp.add(tmp);
        }

        start = ans.size(); 
        ans.addAll(ans_tmp);
    }
    return ans;
}
