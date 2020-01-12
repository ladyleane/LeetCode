import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution{
	private List<List<Integer>> res = new ArrayList<>();
	private int[] candidates;
	private int len;

	private void findCombinationSum(int residue, int start, Stack<Integer> pre){
		if (residue == 0){
			res.add(new ArrayList<>(pre));
			return;
		}

		for (int i = start; i < len && residue - candidates[i] >= 0; i++){
			pre.add(candidates[i]);
			findCombinationSum(residue - candidates[i], i, pre);
			pre.pop();
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target){
		int len = candidates.length;
		if (len == 0){
			return res;
		}
		Arrays.sort(candidates);
		this.len = len;
		this.candidates = candidates;
		findCombinationSum(target, 0, new Stack<>());
		return res;
	}

	public static void main(String[] args){
		int[] candidates = {2, 3, 6, 7);
		int target = 7;
		Solution solution = new Solution();
		List<List<Integer>> combintaionSum = solution.combinationSum(candidates, target);
		System.out.println(combinationSum);
	}
}
