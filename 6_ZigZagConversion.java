//Sort by Row, O(n)

class Solution {
    public String convert(String s, int numRows) {
		if (numRows == 1)	return s;

		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < numRows; i++){
			rows.add(new StringBuilder());
		}

		int currentRow = 0;
		boolean goDown = false;

		for(char c : s.toCharArray()){
			rows.get(currentRow).append(c);
			if (currentRow == 0 || currentRow == numRows - 1)
				goDown = !goDown;
			currentRow += goDown ? 1 : (-1);
		}

		StringBuilder ans = new StringBuilder();
		for (StringBuilder row : rows){
			ans.append(row);
		}

		return ans.toString();
    }
}


//Visit by row
class Solution {
    public String convert(String s, int numRows) {
		if (numRows == 1)	return s;

		StringBuilder ans = new StringBuilder();

		int n = s.length();
		int step = 2 * numRows - 2;

		for (int i = 0; i < numRows; i++){
			for (int j = 0; j + i < n; j += step){
				ans.append(s.charAt(j + i));
				if (i != 0 && i != numRows - 1 && j + step - i < n)
					ans.append(s.charAt(j + step - i));
			}
		}

		return ans.toString();
    }
}
